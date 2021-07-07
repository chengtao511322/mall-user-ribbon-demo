package com.ct.线程安全;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class NotSafePlus {
    private Integer amount = 0;

    public  void selfPlus(){
        amount++;
    }

    public Integer getAmount(){
        return amount;
    }
}
