package com.tuling.mall.order.event;

import com.tuling.mall.order.entity.OrderEntity;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 */
@Component
public class OrderListener implements ApplicationListener<OrderEvent> {

	@Override
	public void onApplicationEvent(OrderEvent event) {
		OrderEntity orderEntity;
		Object source = event.getSource();
		if(source instanceof OrderEntity){
			orderEntity = (OrderEntity)source;
			System.out.println("顾客买了"+orderEntity.getAmount());
		}
		if(event.getName().equals("减库存")){
			System.out.println("减库存");
		}
	}
}
