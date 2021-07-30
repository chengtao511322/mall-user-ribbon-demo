package com.tuling.myNio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 自己实现Nio,没有使用多路复用器
 */
public class NioServer {

    //保存客户端连接
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //创建nioSocketChannel
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));//serverSocketChannel与9000端口绑定
        //设置serverSocketChannel为费阻塞
        serverSocket.configureBlocking(false);
        System.out.println("服务启动成功....");
        while (true){
            //非阻塞模式accept不会阻塞
            //Nio的非阻塞是由操作系统内部实现,底层调用了linux的accept函数
            SocketChannel socketChannel = serverSocket.accept();
            if(socketChannel != null){
                //如果有新的连接进来放入集合,先设置为非阻塞
                socketChannel.configureBlocking(false);
                channelList.add(socketChannel);
            }
            //遍历连接进行数据读取
            Iterator<SocketChannel> iterator = channelList.iterator();
            while (iterator.hasNext()){
                SocketChannel socket = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                int len = socket.read(byteBuffer);
                //如果有数据
                if(len > 0){
                    System.out.println("接收到消息了"+new String(byteBuffer.array()));
                }else if(len == -1){
                    iterator.remove();
                    System.out.println("客户端断开连接");
                }

            }
        }

    }
}
