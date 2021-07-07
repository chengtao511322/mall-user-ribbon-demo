package com.tuling.mall.user.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
@Configuration
public class FeginConfig {
    //日志级别配置
    @Bean
    public Logger.Level feginLoggerLeverl(){
        return Logger.Level.FULL;
    }
}
