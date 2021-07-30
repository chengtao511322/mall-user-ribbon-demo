package com.tuling.iostreamm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Documents\\WeChat Files\\kingforct\\FileStorage\\File\\2021-07\\服务监控.txt");
        FileOutputStream fos = new FileOutputStream("myTest");
        byte[] bytes = new byte[1024*1024];
        int readCount = 0;//定义每一次读取到的字节数量
        while ((readCount = fis.read(bytes)) != -1){
            fos.write(bytes,0,readCount);
        }


    }
}
