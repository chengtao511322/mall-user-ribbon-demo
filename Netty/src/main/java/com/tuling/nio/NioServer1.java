package com.tuling.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class NioServer1 {

    public static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(9000));
        //设置serverSocketChannel为非阻塞
        channel.configureBlocking(false);
        System.out.println("服务启动成功");

        while (true){
            //非阻塞模式调用accpet方法不会阻塞,当有连接进来的时候会获得连接对象
            SocketChannel socketChannel = channel.accept();
            if(socketChannel != null){
                System.out.println("连接成功");
                socketChannel.configureBlocking(false);
                //保存客户端连接到list当中
                channelList.add(socketChannel);
            }
            Iterator<SocketChannel> iterator = channelList.iterator();
            while (iterator.hasNext()){
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                //非阻塞模式read不会阻塞
                int len = sc.read(byteBuffer);
                if(len > 0){
                    System.out.println("接收到消息"+new String(byteBuffer.array()));
                }else if(len == -1){
                    iterator.remove();
                    System.out.println("客户端断开了连接");
                }
            }
        }
    }
}
