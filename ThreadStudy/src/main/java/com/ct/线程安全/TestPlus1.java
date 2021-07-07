package com.ct.线程安全;

import java.util.concurrent.CountDownLatch;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class TestPlus1 {

    public static final int MAX_THREAD = 10;
    //模拟线程调用1000次
    public static final int MAX_TURN = 10000;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(MAX_THREAD);
        //对象
        NotSafefPlus1 notSafefPlus1 = new NotSafefPlus1();
        //线程执行去调用testPlus1自增的方法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    notSafefPlus1.incrementA();
                }
                countDownLatch.countDown();
            }
        };
        //启动10个线程去争抢资源
        for (int i = 0; i < MAX_THREAD; i++) {
            new Thread(runnable).start();
        }
        countDownLatch.await();
        System.out.println(notSafefPlus1.getA());
    }
}
