package com.ct.consumerAndProducer;

import com.ct.生产者和消费者.Proucer;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 定义通用的消费者
 */
public class Producer implements Runnable{

    //名称
    private String name;

    //行为
    private Callable action;

    //生产间隔
    private int gap = PRODUCE_GAP;

    //生产时间间隔
    public static final int PRODUCE_GAP = 200;

    //总生产记录次数
    public static final AtomicInteger TURN = new AtomicInteger(0);

    //生产的对象编号
    public static final AtomicInteger PRODUCE_NO = new AtomicInteger(0);


    public Producer(Callable action,int gap){
        this.action = action;
        this.gap = gap;
        this.name = "生产者-"+PRODUCE_NO.incrementAndGet();
    }


    @Override
    public void run() {
        while (true){
            //开始生产
            try {
                Object out = action.call();
                //输出生产结果
                if(null != out){
                    TURN.incrementAndGet();
                    System.out.println("第"+TURN.get()+"轮生产"+out);
                }
                Thread.sleep(gap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
