package com.tuling.mall.order.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 下单事件
 */
public class OrderEvent extends ApplicationEvent {

	private String name;

	public OrderEvent(Object source) {
		super(source);
		this.name=name;
	}

	public OrderEvent(Object source, String name) {
		super(source);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
