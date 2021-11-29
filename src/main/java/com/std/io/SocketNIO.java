package com.std.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author zyc
 * @date 2021/8/11 10:56
 */
public class SocketNIO {

    private static volatile boolean flag = true;

    public static void exit () {
        flag = false;
    }

    public static void main(String[] args) throws Exception {

        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        // 重点  OS NONBLOCKING
        ss.configureBlocking(false);

        //  接收客户端连接
        while (flag) {
            // 不是必须的，为了 strace 好定位才需要睡眠
            Thread.sleep(10000);
            // 不会阻塞
            SocketChannel client = ss.accept();
            if (Objects.isNull(client)) {
                System.out.println("null....");
            } else {
                // 重点 socket服务端的listen socket连接请求三次握手后，读取数据时设置为非阻塞
                client.configureBlocking(false);
                System.out.println("client port:" + client.socket().getPort());
                clients.add(client);
            }

            // 可以在堆外
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);

            // 遍历已经连接进来的客户端能不能读写请数据
           for (SocketChannel s : clients){
                // 不会阻塞
                int num = s.read(buffer);
                if (num > 0) {
                    buffer.flip();
                    byte[] aa = new byte[buffer.limit()];
                    buffer.get(aa);

                    String b = new String (aa);
                    try { System.out.println(client.socket().getPort() + ":" + b); } catch (NullPointerException ignore){}
                    buffer.clear();
                }
            }
        }
    }
}