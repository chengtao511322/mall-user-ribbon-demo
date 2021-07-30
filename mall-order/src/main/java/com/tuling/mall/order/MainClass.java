package com.tuling.mall.order;

import com.tuling.mall.order.config.MainConfig;
import com.tuling.mall.order.entity.OrderEntity;
import com.tuling.mall.order.event.OrderEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1);
        orderEntity.setAmount(500);
        System.out.println("下单");
        //发布事件
        ac.publishEvent(new OrderEvent(orderEntity,"减库存"));

        System.out.println("打印日志");
    }
}
