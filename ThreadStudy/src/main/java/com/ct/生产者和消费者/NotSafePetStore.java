package com.ct.生产者和消费者;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class NotSafePetStore {

    //定义缓冲区静态实例
    private static NotSafeBuffer<Goods> notSafeBuffer = new NotSafeBuffer<>();

    //生产者的工作
    static Callable<Goods> prouceAction = ()->{
      //首先生成一个随机商品
        Goods goods = null;
        try {
            goods = Goods.produceOne();
            notSafeBuffer.addElement(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods ;
    };

    //消费者执行的动作
    static Callable<Goods> consumerAction = ()->{
        Goods goods = null;
        try {
            goods = notSafeBuffer.getElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    };

    public static void main(String[] args) {
        System.setErr(System.out);
        //同时并发执行线程
        final int THREA_TOTAL = 20;
        //线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(THREA_TOTAL);
        for (int i = 0; i < 5; i++) {
            //生产者实例没生产一个产品间隔500
            threadPool.submit(new Proucer(prouceAction,500));
            threadPool.submit(new Consumer(consumerAction,1500));
        }
    }
}
