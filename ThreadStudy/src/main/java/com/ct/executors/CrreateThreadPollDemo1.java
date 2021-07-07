package com.ct.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by chentao
 * 线程池Demo1
 */
public class CrreateThreadPollDemo1 {

    public static final int SLEEP_GAP = 500;

    //异步任务执行目标类
    static class TargetTask implements Runnable{
        static AtomicInteger taskNo = new AtomicInteger(1);

        private String taskName;

        public TargetTask(){
            this.taskName = "task"+taskNo.get();
            taskNo.incrementAndGet();
        }
        @Override
        public void run() {
            System.out.println("任务:"+taskName+"doing");
            //线程睡眠一会
            try {
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(taskName+"运行结束========");
        }
    }

    //调用示例

    public  void testSingleThreadExecutor() {
        ExecutorService poll = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5 ; i++) {
            poll.execute(new TargetTask());
            poll.submit(new TargetTask());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭线程池
        poll.shutdown();
    }

    //固定数量的线程池
    public static void testNewFixedThreadPool(){
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            pool.execute(new TargetTask());
            pool.submit(new TargetTask());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

    public static void main(String[] args) {
        testNewFixedThreadPool();
    }
}
