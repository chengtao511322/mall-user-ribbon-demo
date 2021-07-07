package com.ct.thread;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println("当前线程"+Thread.currentThread().getName());
        System.out.println("当前线程id"+Thread.currentThread().getId());
        System.out.println("当前线程状态"+Thread.currentThread().getState());
        System.out.println("当前线程优先级"+Thread.currentThread().getPriority());
    }
}
