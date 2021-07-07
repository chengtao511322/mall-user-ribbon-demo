package com.ct.生产者和消费者;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通用消费者的定义
 */
public class Consumer implements Runnable{
    //消费时间间隔
    public static final int CONSUME_GAP = 100;

    //消费总次数
    static final AtomicInteger TURN = new AtomicInteger(0);

    //生产者对象编号
    static final AtomicInteger CONSUME_NO = new AtomicInteger(1);

    //生产者名称
    private String name = null;

    //生产者的行为
    Callable action = null;

    private int gap = CONSUME_GAP;

    public Consumer(Callable action,int gap){
        this.action = action;
        this.gap = gap;
        this.name = "消费者-"+CONSUME_NO.incrementAndGet();
    }
    @Override
    public void run() {
        while (true){
            try {
                //增加消费次数
                TURN.incrementAndGet();
                //执行消费动作
                Object out = action.call();
                if(null != out){
                    System.out.println("第"+TURN.get()+"轮消费:"+out);
                }
                //每一轮生产完成后等待
                Thread.sleep(gap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
