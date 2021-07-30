package com.tuling.myNio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 基于Selector实现的Nio
 */
public class NioSelector {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        serverSocket.configureBlocking(false);
        //打开Selector处理channel
        Selector selector = Selector.open();

        //把serverSocketChannel注册到selector上
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务启动成功,serverSocket已经创建并且绑定到selector中");
        while (true){
            System.out.println("新一轮探测");
            //阻塞等待需要处理的事件发生
            selector.select();

            //获取selector注册的全部事件的SelectionKey实例
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();

            //遍历
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    //这里只注册了读事件
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    System.out.println("客户端连接成功。。");
                }else if(key.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int len = socketChannel.read(byteBuffer);
                    // 如果有数据，把数据打印出来
                    if (len > 0) {
                         System.out.println("接收到消息：" + new String(byteBuffer.array()));
                        } else if (len == -1) { // 如果客户端断开连接，关闭Socket
                        System.out.println("客户端断开连接");
                        socketChannel.close();
                        }
                }
                iterator.remove();
            }
        }
    }
}
