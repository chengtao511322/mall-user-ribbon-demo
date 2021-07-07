package com.ct.生产者和消费者;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者和消费这
 */
public class NotSafeBuffer<T> {

    //最大数量定义为10个
    private static final int MAX_AMOUNT = 10;

    private List<T> dataList = new LinkedList<>();

    //保存数量是
    private AtomicInteger amount = new AtomicInteger(0);

    //往数据区集合添加一个元素
    public void addElement(T element) throws Exception {
        if(amount.get() > MAX_AMOUNT){
            System.out.println("队列已经满了放不下");
            return;
        }
        dataList.add(element);
        System.out.println("data"+" ");
        amount.incrementAndGet();

        //如果集合大小和总数不一致则抛异常
        if(dataList.size() != amount.get()){
            throw new Exception("缓冲区数量不一致");
        }
    }

    public T getElement() throws Exception {
        if(amount.get() <= 0){
            System.out.println("队列已经没有数据");
            return null;
        }
        T element = dataList.remove(0);
        System.out.println("element被移除");
        amount.decrementAndGet();
        //如果数据不一致还是抛出异常
        if(dataList.size() != amount.get()){
            throw new Exception("缓冲区数量不一致");
        }
        return element;
    }
}
