package com.tuling.mall.user.service.impl;

import com.tuling.mall.user.service.PayInterface;
import org.springframework.stereotype.Service;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
@Service
public class AliPay implements PayInterface {

    //支付宝的支付接口
    @Override
    public String pay(int money) {
        return "支付宝接口~~"+money;
    }
}
