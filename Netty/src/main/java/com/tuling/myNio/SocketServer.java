package com.tuling.myNio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio单线程模型
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true){
            System.out.println("服务器等待连接");
            //阻塞方法
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了");
            new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        System.out.println("线程处理begin......");
                        handler(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            //handler(clientSocket);

        }
    }

    /**
     * 处理接入的连接
     * @param clientSocket
     */
    public static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];//1kb的字节大小
        System.out.println("准备read...");
        //接收客户端的数据,阻塞方法,没有数据可读时就会阻塞
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read完毕...");
        if(read != -1){
            System.out.println("接收到客户端的数据"+new String(bytes,0,read));
        }
        clientSocket.getOutputStream().write("HelloClient".getBytes());
        clientSocket.getOutputStream().flush();

    }
}
