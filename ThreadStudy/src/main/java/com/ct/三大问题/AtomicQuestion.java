package com.ct.三大问题;

import org.junit.Test;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class AtomicQuestion {

    int sum = 0;


    public void increase(){
        sum++;
    }

    public static void main(String[] args) {
        AtomicQuestion atomicQuestion = new AtomicQuestion();
        atomicQuestion.increase();
    }
}
