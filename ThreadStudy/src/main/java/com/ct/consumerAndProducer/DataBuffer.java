package com.ct.consumerAndProducer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class DataBuffer<T> {

    //定义一个数据缓冲区
    private List<T> dataList = new LinkedList<>();

    //缓冲区最多数量
    private static final int MAX_AMOUNT = 10;

    //保存数量
    private AtomicInteger amount = new AtomicInteger(0);

    //往缓冲区添加集合
    public void addElement(T element) throws Exception {
        synchronized (this){
            if(amount.get() > MAX_AMOUNT){
                System.out.println("队列放不下了");
                return;
            }
            dataList.add(element);
            amount.incrementAndGet();
            if(dataList.size() != amount.get()){
                throw new Exception("缓冲区数量不一致了:"+dataList.size() +"!="+amount.get());
            }
        }

    }

    //取
    public T getElement() throws Exception {
        synchronized (this){
            if(dataList.size() <= 0){
                System.out.println("队里已经没有了");
                return null;
            }
            //移除
            T element = dataList.remove(0);
            System.out.println(element+"被移除了");
            amount.decrementAndGet();
            if(dataList.size() != amount.get()){
                throw new Exception("缓冲区数量不一致了:"+dataList.size() +"!="+amount.get());
            }
            return element;
        }

    }
}
