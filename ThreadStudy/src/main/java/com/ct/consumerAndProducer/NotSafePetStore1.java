package com.ct.consumerAndProducer;

import com.ct.生产者和消费者.Goods;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class NotSafePetStore1 {

    //先的定义好一个数据缓冲区
    public static DataBuffer<Goods> dataBuffer = new DataBuffer();


    //定义生产行为
    static Callable<Goods> produceAction = ()->{
        Goods goods = Goods.produceOne();
        try {
            dataBuffer.addElement(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    };

    static Callable<Goods> consumeAction = ()->{
        Goods goods = null;
        try {
           goods = dataBuffer.getElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    };

    public static void main(String[] args) {
        System.setErr(System.out);
        ExecutorService exe = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            exe.submit(new Producer(produceAction,500));
            exe.submit(new Consumenr(consumeAction,1500));
        }
    }
}
