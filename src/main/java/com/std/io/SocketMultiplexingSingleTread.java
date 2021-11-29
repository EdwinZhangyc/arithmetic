package com.std.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zyc
 * @date 2021/8/11 17:06
 */
public class SocketMultiplexingSingleTread {

    private volatile boolean flag = true;

    private ServerSocketChannel server = null;
    /**
     * Linux 多路复用器，接口模式，首先采用epoll，没有epoll在用select/poll
     */
    private Selector selector = null;
    int port = 9999;

    public void initServer () {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));
            //如果在epoll模式下，open = epoll_create  -> fd3  <- fd4
            // select poll epoll 优先选择 epoll  可以通过-D修正
            selector = Selector.open();

            // server 约等于 listen状态的fd4
            /*
             * register
             *      select poll: JVM 里开辟一个数组 fd4 放进去
             *      epoll: epoll_ctl(fd3, ADD, fd4, event.OP_ACCEPT)
             */
            server.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception ignore) {}
    }
    public void start() {
        initServer();
        System.out.println("server start");
        try {
            while (flag) {
                Set<SelectionKey> keys = selector.keys();
                System.out.println("select key size=" +keys.size());
                // 1 调用多路复用器（select，poll，epoll（epoll_wait））
                /*
                 * select()是什么意思
                 *      1、select poll 内核的select(fd4) poll(fd4)
                 *      2、epoll: 内核的epoll_wait()
                 * 参数可以带时间，没有时间不阻塞，有时间阻塞设置一个超时时间 0表示一直阻塞
                 * selector.wakeup() 结果返回0
                 */
                while(selector.select(500) > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    // so 管你什么多路复用器，你只能给我返回状态，我还得一个个去处理他们的R/W 同步好辛苦
                    // NIO 自己对着每一个fd调用系统调用，浪费资源，那么你看，这里是不是调用了一次select方法
                    while(iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        // 不移除会重复循环处理
                        iterator.remove();
                        if(key.isAcceptable()){
                            /*
                             * 看代码的时候，这里是重点，如果要去接收一个新的连接予语意上，accept接受连接且返回
                             * 新连接的FD对吧，那新的FD怎么办？
                             * select poll 因为他们内核没有空间，那么在jvm中保存和前边的fd4那个listen的一起
                             * epoll 我们希望通过epoll_ctl把新的客户端连接fd注册到内核中
                             */
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                            readHandler(key);
                            // 在当前线程，这个方法可能会阻塞，如果阻塞了十年，其他IO早就没电了
                            // 可以考虑采用线程池
                        }
                    }
                }
            }
        } catch (Exception ignore) {}
    }

    public void exit () {
        flag = false;
    }

    private void readHandler(SelectionKey key) {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        int read = 0;
        try {

        } catch (Exception ignore) {}
    }

    private void acceptHandler(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            // 目的是调用accept接收客户端 fd7
            SocketChannel client = ssc.accept();
            client.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocateDirect(8192);
            /*
             * 调用registry
             * select poll: JVM 里开辟一个数组 fd4 放进去
             * epoll: epoll_ctl(fd3, ADD, fd4, event.OP_ACCEPT)
             */
            client.register(selector, SelectionKey.OP_READ, buffer);
            System.out.println("---------------------------------");
            System.out.println("新客户端："+client.getRemoteAddress());
            System.out.println("---------------------------------");
        } catch (Exception ignore){}
    }


}