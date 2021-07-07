package com.ct.executors;

import java.util.concurrent.*;

/**
 * @author by chentao
 * 通过submit返回的结果获取结果
 */
public class SubmitGetResult {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                //返回200-300的随机数
                return (int)(Math.random()*1000);
            }
        });

        try {
            Integer result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //关闭线程池
        pool.shutdown();
    }
}
