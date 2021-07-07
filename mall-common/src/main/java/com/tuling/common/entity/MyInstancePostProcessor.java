package com.tuling.common.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 * 实现了instant接口，会中断bean的创建
 */
@Component
public class MyInstancePostProcessor implements InstantiationAwareBeanPostProcessor {

	private String name;

	private String age;

	@Autowired
	private Tank tank;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
			MyInstancePostProcessor myInstancePostProcessor = new MyInstancePostProcessor();
			myInstancePostProcessor.setName("通过后置处理器在bean初始化之前返回");
			return myInstancePostProcessor;


	}

//	@Override
//	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		return null;
//	}

	@Override
	public String toString() {
		return "MyInstancePostProcessor{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				", tank=" + tank +
				'}';
	}
}
