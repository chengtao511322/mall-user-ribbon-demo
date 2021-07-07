package com.tuling.common.test;


import com.tuling.anno.SpringConfig;
import com.tuling.common.entity.MyInstancePostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class MyTest02 {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
//		Car car = (Car) applicationContext.getBean("car");
////		System.out.println(car);
		MyInstancePostProcessor myInstancePostProcessor = (MyInstancePostProcessor)ac.getBean("myInstancePostProcessor");
		System.out.println(myInstancePostProcessor);

	}
}
