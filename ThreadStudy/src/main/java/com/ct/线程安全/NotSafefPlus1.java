package com.ct.线程安全;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class NotSafefPlus1 {

    //模拟
    private int a;

    public synchronized void incrementA(){
        a++;
    }

    public int getA(){
        return this.a;
    }
}
