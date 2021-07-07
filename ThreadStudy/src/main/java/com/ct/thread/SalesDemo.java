package com.ct.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class SalesDemo {
    public static final int MAX_AMOUNT = 5;//商品数量

    //商店商品类
    static class StoreGoods extends Thread{
        StoreGoods(String name){
            super(name);
        }

        private int goodsAmount = MAX_AMOUNT;
        //重写run方法,需要执行并发的代码
        public void run(){
            for (int i = 0; i < MAX_AMOUNT; i++) {
                if(this.goodsAmount > 0){
                    System.out.println(CreateDemo.getCurThreadName() +" 卖出一件,还剩："+ (--goodsAmount));
                }
            }
            System.out.println(CreateDemo.getCurThreadName() +"运行结束.");
        }
    }

    //实现Runnable接口
    static class MallGoods implements Runnable{

        private AtomicInteger goodsAmount = new AtomicInteger(MAX_AMOUNT);
        @Override
        public void run() {
            for (int i = 0; i < MAX_AMOUNT; i++) {
                if(this.goodsAmount.get() > 0){
                    System.out.println(CreateDemo.getCurThreadName()+"卖出一件 还剩"+ goodsAmount.decrementAndGet());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("线程运行结束");

        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("商店版本");
        for (int i = 0; i < 2; i++) {
            Thread thread = null;
            thread = new StoreGoods("店员-"+i);
            thread.start();

        }
        Thread.sleep(1000);

        System.out.println("商城版本的销售");
        MallGoods mallGoods = new MallGoods();
        for (int i = 0; i < 2; i++) {
            Thread thread = null;
            thread = new Thread(mallGoods,"商场销售员-"+i);
            thread.start();
        }
        System.out.println("运行结束");
    }
}
