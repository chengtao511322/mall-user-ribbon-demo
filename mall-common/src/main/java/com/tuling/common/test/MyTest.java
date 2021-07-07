package com.tuling.common.test;

import com.tuling.anno.SpringConfig;
import com.tuling.common.entity.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class MyTest {

	private static int i = 0;
	//新建一个配置类
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
//		Car car = (Car) ac.getBean("car");
//		car.initMethod();
//		System.out.println("获得的bean的名称为"+car.getName());
		for (int i1 = 0; i1 < 100000; i1++) {
			i++;
		}
		System.out.println(i);
	}
	
}
