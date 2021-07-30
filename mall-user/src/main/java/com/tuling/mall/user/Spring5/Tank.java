package com.tuling.mall.user.Spring5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
@Component
public class Tank {

    private String age;

    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String s = new String("312");
        s.intern();
        this.name = name;
    }
}
