package com.tuling.common.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Repository;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 * 模拟实现bean的后置出来器
 */
@Repository
public class Car implements BeanFactoryPostProcessor {

	private String name;
	@Autowired
	private Tank tank;

	public Car() {
		System.out.println("Car正在加载当中.............");
	}

	public void initMethod(){
		System.out.println("正在初始化..............");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank) {
		this.tank = tank;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//可以在此处修改bean定义
		GenericBeanDefinition car = (GenericBeanDefinition)beanFactory.getBeanDefinition("car");
		car.setBeanClassName("com.ct.entity.Tank");

	}
}
