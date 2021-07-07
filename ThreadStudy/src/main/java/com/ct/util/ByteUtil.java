package com.ct.util;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class ByteUtil {

    //转成小端模式的字节数组
    public static byte[] int2Bytes_LE(int n) {
        byte[] b = new byte[4];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        b[2] = (byte) (n >> 16 & 0xff);//高字节在后是与java存放内存相反, 与书写顺序相反
        b[3] = (byte) (n >> 24 & 0xff);//数据组结束位,存放内存起始位, 即:高字节在后
        return b;
    }

    /**
     * 转成16进制字符串
     * @param a
     * @return
     */
    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }
}
