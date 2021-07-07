package com.ct.线程安全;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class TestPlus {

    public final int MAX_TREAD = 10;
    public final int MAX_TURN = 1000;

    @Test
    public void testNoSafePlus() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(MAX_TREAD);
        NotSafePlus counter = new NotSafePlus();
        Runnable runnable = () ->{
            for (int i = 0; i < MAX_TURN; i++) {
                //这里是线程去调用1000出
                counter.selfPlus();
            }
            latch.countDown();//倒数阀门减少一次
        };
        for (int i = 0; i < MAX_TREAD; i++) {
            new Thread(runnable).start();
        }
        latch.await();
        Thread.sleep(100);
        System.out.println(counter.getAmount());
    }

}
