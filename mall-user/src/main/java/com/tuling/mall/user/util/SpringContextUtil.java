package com.tuling.mall.user.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    //上下文对象
    private static ApplicationContext applicationContext;

    @Override
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    //通过name获得指定的bean对象
    public static  <T> T getBean(String name,Class<T> beanClass){
        return SpringContextUtil.getApplicationContext().getBean(name,beanClass);
    }
}
