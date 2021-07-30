package com.tuling.mall.user.service;

/**
 * 支付枚举
 */
public enum PayEnum {

    //支付宝
    WECHAT_PAY(0,"weChatPay"),

    //支付宝
    ALI_PAY(1,"aliPay");

    private final int payInfo;

    private final String payClass;

    PayEnum(int payInfo, String payClass) {
        this.payInfo = payInfo;
        this.payClass = payClass;
    }

    public int getPayInfo() {
        return payInfo;
    }

    public String getPayClass() {
        return payClass;
    }

    public static String getValueByCode(int code){
        for (PayEnum value : PayEnum.values()) {
            if(value.getPayInfo()==code){
                return value.getPayClass();
            }
        }
        return null;
    }
}
