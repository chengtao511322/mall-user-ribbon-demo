package com.ct.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 * 线程状态测试
 */
public class ThreadState {
    //每个线程执行的轮次
    public static final long MAX_TURN = 5;

    //线程编号
    static int threadNumber = 0;

    //全局静态的线程列表
    public static List<Thread> threadList = new ArrayList<>();

    //输出静态线程列表中的每个线程状态
    private static void printStatus(){
        for (Thread thread : threadList) {
            System.out.println(thread.getName()+"状态为"+thread.getState());
        }
    }

    private static void addThread(Thread thread){
        threadList.add(thread);
    }

    //线程类
    static class StatusDemoThread extends Thread{
        public StatusDemoThread(){
            //新建线程,自增线程编号
            super("statusThread"+(++threadNumber));
            addThread(this);
        }

        @Override
        public void run() {
            System.out.println(getName()+"状态为"+getState());
            for (long i = 0; i < MAX_TURN; i++) {
                //线程睡眠
                sleepMillSeconds(500);
                //输出所有线程的状态
                printStatus();
            }
            System.out.println(getName()+"线程运行结束");
        }
    }

    public static void sleepMillSeconds(int millSecond){
        LockSupport.parkNanos(millSecond*1000L*1000L);
    }

    public static void main(String[] args) {
        //将当前的main线程也加入全局列表
        addThread(Thread.currentThread());
        //新建三个线程
        Thread thread1 = new StatusDemoThread();
        System.out.println(thread1.getName()+"-状态为"+thread1.getState());
        Thread thread2 = new StatusDemoThread();
        System.out.println(thread2.getName()+"-状态为"+thread2.getState());
        Thread thread3 = new StatusDemoThread();
        System.out.println(thread3.getName()+"-状态为"+thread3.getState());

        //驱动第一个
        thread1.start();
        sleepMillSeconds(500);
        System.out.println("==================第一次休眠============");
        thread2.start();
        sleepMillSeconds(500);
        System.out.println("==================第二次休眠============");

        thread3.start();
        sleepMillSeconds(10000);
        System.out.println("==================第三次休眠============");
    }
}
