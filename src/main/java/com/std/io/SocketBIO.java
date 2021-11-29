package com.std.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zyc
 * @date 2021/8/11 10:49
 */
public class SocketBIO {

    private static volatile boolean flag = true;

    public static void main(String[] args) {
        //这里使用try resouce 管理资源
        //创建ServerSocket
        try (ServerSocket ss = new ServerSocket(9090)){
            System.out.println("服务器启动...");
            //创建线程池
            ExecutorService pool = Executors.newCachedThreadPool();
            while(flag){
                System.out.println("等待连接...");
                //等待客户段连接 没有连接会阻塞
                final Socket socket = ss.accept();
                System.out.println("连接到一个客户端");
                //异步处理数据
                pool.execute(() -> handle(socket));
            }
        } catch (Exception ignore){}
    }
    public static void exit () {
        flag = false;
    }
    /**
     * 接受数据
     * @param socket
     */
    public static void handle(Socket socket){
        try (Socket socketnew = socket){
            OutputStream out = socket.getOutputStream();
            out.write("连接成功:".getBytes());
            System.out.println("当前线程ID:"+Thread.currentThread().getId() +" 当前线程name: "+Thread.currentThread().getName());
            InputStream in = socketnew.getInputStream();
            byte[] data = new byte[1024];
            System.out.println("等待输入内容...");
            int len = 0 ;
            //获取流中的数据  这里如果没有数据 会阻塞
            while((len= in.read(data))!=-1){
                System.out.println(new String(data,0,len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}