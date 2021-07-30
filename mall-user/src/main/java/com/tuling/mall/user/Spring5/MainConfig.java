package com.tuling.mall.user.Spring5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
@Configuration
@ComponentScan(value = "com.tuling.mall.user.Spring5")
public class MainConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);

    }
}
