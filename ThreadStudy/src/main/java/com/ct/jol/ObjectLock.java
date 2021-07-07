package com.ct.jol;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import com.ct.util.ByteUtil;
import org.openjdk.jol.vm.VM;

/**
 * 对象布局分析
 */
public class ObjectLock {
    private Integer amount = 0;//整型字段占用4个字节

    public void increase(){
        synchronized (this){
            amount++ ;
        }
    }

    /**
     * 输出16进制的hashCode
     */
    public String hexHash(){
        int hashCode = this.hashCode();

        //转成小端模式
        byte[] hashcode_LE = ByteUtil.int2Bytes_LE(hashCode);

        //转成16进制得字符串
        return ByteUtil.byteArrayToHex(hashcode_LE);
    }

    /**
     * 输出二进制
     */
    public String binaryHash(){
        int hashCode = this.hashCode();
        byte[] bytes = ByteUtil.int2Bytes_LE(hashCode);
        return null;
    }



}
