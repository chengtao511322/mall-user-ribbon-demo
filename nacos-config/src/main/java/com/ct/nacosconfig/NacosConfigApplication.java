package com.ct.nacosconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ac = SpringApplication.run(NacosConfigApplication.class, args);
        while (true){
            String userName = ac.getEnvironment().getProperty("common.name");
            String userAge = ac.getEnvironment().getProperty("common.age");
            System.err.println("common.name:"+userName+";age:"+userAge);
            TimeUnit.SECONDS.sleep(3);
        }
    }
}
