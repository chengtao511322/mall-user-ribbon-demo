package com.ct.thread;

/**
 * @author by chentao
 * 线程睡眠~
 */
public class ThreadSleep {

    public static final int MAX_SELLP = 5000;//睡眠时长为5s

    public static final int MAX_TURN = 50;

    static class ThreadSleepDemo extends Thread{
        static int threadSeqNo = 1;

        public ThreadSleepDemo(){
            super("sleepThread"+threadSeqNo);
            threadSeqNo++;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_TURN; i++) {
                System.out.println(getName()+",睡眠轮次"+i);
                try {
                    Thread.sleep(MAX_SELLP);
                } catch (InterruptedException e) {
                    System.out.println(getName()+"发生异常被中断了");
                }
            }
            System.out.println("线程运行结束");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            Thread thread = new ThreadSleepDemo();
            thread.start();
        }
        System.out.println("main线程运行结束了");
    }
}
