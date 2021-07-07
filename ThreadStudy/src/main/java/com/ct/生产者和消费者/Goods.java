package com.ct.生产者和消费者;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class Goods {

    //商品名称
    private String name;

    //商品重量
    private int weight;

    //商品编号
    private static AtomicInteger goodsNo = new AtomicInteger(0);

    //商品重量
    private static AtomicInteger goodsWeight = new AtomicInteger(0);


    //随机生产一个商品
    public static Goods produceOne(){
        Goods goods = new Goods();
        goods.setName("商品编号:=="+goodsNo.incrementAndGet()+"==");
        goods.setWeight(goodsWeight.incrementAndGet());
        return goods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
