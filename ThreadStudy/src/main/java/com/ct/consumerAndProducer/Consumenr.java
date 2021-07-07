package com.ct.consumerAndProducer;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class Consumenr implements Runnable{

    //名称
    private String name;

    //行为
    private Callable action;

    //消费间隔
    private int gap = CONSUME_GAP;

    //生产时间间隔
    public static final int CONSUME_GAP = 300;

    //总生产记录次数
    public static final AtomicInteger TURN = new AtomicInteger(0);

    //生产的对象编号
    public static final AtomicInteger PRODUCE_NO = new AtomicInteger(0);


    public Consumenr(Callable action,int gap){
        this.action = action;
        this.gap = gap;
        this.name = "消费者-"+PRODUCE_NO.incrementAndGet();
    }

    @Override
    public void run() {
        while (true){
            try {
                Object get = action.call();
                if(null != get){
                    System.out.println("第"+TURN.incrementAndGet()+"轮消费"+get);
                }
                Thread.sleep(gap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
