package com.ct.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
@RestController
@RefreshScope
public class TestController {

    @Value("10")
    private String age;
    @Value("woaijingjing")
    private String name;

    @GetMapping("/common")
    public String hello(){
        return name+age;
    }
}
