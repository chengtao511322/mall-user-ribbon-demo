package com.tuling.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true){
            System.out.println("等待连接");
            //阻塞方法
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了");

            new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        handler(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }

    public static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read");
        //接收客户端数据,这里也会阻塞
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read完毕");
        if(read != -1){
            System.out.println("接受到客户端数据"+new String(bytes,0,read));
        }
        clientSocket.getOutputStream().write("helloClinet".getBytes());
        clientSocket.getOutputStream().flush();

    }

}
