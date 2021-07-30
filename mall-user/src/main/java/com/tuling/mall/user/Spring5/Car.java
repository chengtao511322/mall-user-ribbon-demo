package com.tuling.mall.user.Spring5;

import org.springframework.stereotype.Component;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
@Component
public class Car {

    private String brand;

    private String price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
