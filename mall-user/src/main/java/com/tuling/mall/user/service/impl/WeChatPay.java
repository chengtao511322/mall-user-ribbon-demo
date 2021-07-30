package com.tuling.mall.user.service.impl;

import com.tuling.mall.user.service.PayInterface;
import org.springframework.stereotype.Service;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
@Service
public class WeChatPay implements PayInterface {
    @Override
    public String pay(int money) {
        return "微信支付接口支付了"+money;
    }
}
