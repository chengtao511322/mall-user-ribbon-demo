package com.tuling.nio;

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
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class NioSelector {
    public static void main(String[] args) throws IOException {
        //创建NIO ServerSocketChannel
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));

        serverSocket.configureBlocking(false);
        Selector selector = Selector.open();
        //把ServerSocketChannel 注册到多路复用器selector
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务启动成功");
        while (true){
            //阻塞等待需要处理的,监听channel上面的事件
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            //遍历SelectorKey对事件进行处理
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //如果是OP_ACCPET事件，则进行连接获取事件注册
                if(key.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel)key.channel();
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    //这里只注册了读事件,如果需要给客户端发送数据可以注册写事件
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    System.out.println("客户端连接成功");
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    byteBuffer.put("欢迎来到聊天室".getBytes());
                    socketChannel.write(byteBuffer);


                }else if(key.isReadable()){//如果是OP_READ事件，则进行读取和打印
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int len = socketChannel.read(byteBuffer);
                    //如果有数据
                    if(len > 0){
                        System.out.println("接收到消息："+new String(byteBuffer.array()));
                        byteBuffer.put("欢迎来到聊天室".getBytes());
                        socketChannel.write(byteBuffer);
                    }else if(len == -1){
                        iterator.remove();
                        System.out.println("客户端断开了连接");
                    }
                }
                //移除key
                iterator.remove();
            }
        }
    }
}
