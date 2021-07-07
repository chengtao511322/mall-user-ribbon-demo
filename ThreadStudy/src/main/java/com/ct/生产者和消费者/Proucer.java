package com.ct.生产者和消费者;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 定义生产者
 */
public class Proucer implements Runnable{

    //生产时间间隔
    public static final int PRODUCE_GAP = 200;

    //总次数
    static final AtomicInteger TURN = new AtomicInteger(0);

    //生产者对象编号
    static final AtomicInteger PROUCER_NO = new AtomicInteger(1);

    //生产者名称
    private String name = null;

    //生产者的行为
    Callable action = null;

    private int gap = PRODUCE_GAP;

    public Proucer(Callable action,int gap){
        this.action = action;
        this.gap = gap;
        this.name = "生产者-"+PROUCER_NO.incrementAndGet();
    }

    @Override
    public void run() {
        while (true){
            try {
                //执行生产的工作
                Object out = action.call();
                //输出生产得到结果
                if(null != out){
                    TURN.incrementAndGet();
                    System.out.println("第"+TURN.get()+"轮生产"+out);
                }
                //每一轮生产完成后等待
                Thread.sleep(gap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
