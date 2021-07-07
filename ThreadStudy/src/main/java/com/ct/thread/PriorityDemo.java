package com.ct.thread;

/**
 * @author by
 * 线程优先级测试
 */
public class PriorityDemo {

    public static final int MAX_SELLEP = 1000;

    //内部类
    static class PriorityThread extends Thread{
        private static int threadNo=1;//线程号

        public PriorityThread(){
            super("thread-"+threadNo);
            threadNo ++ ;
        }
        //用于计数
        public long opportunties = 0;

        @Override
        public void run(){
            //无限加
            for(int i=0;;i++){
                opportunties ++;
            }
        }
    }

    public static void main(String[] args) {
        //创建一个线程数组
        PriorityThread[] threads = new PriorityThread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new PriorityThread();
            //设置线程的优先级
            threads[i].setPriority(i+1);
        }

        //10个线程设置完成轮流启动线程
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        //10个线程启动完运行1s,阻塞main线程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //轮流停止
        for (int i = 0; i < threads.length; i++) {
            threads[i].stop();
        }

        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].getName()+
                    "线程优先级为"+threads[i].getPriority()+
                    "机会值为"+threads[i].opportunties);
        }
    }
}
