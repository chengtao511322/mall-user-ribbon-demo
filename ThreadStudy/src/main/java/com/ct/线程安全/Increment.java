package com.ct.线程安全;

/**
 * 自增同步实验
 */
public class Increment {

    public static int a = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //对一个变量自增1000次
                    for (int i = 0; i < 1000; i++) {
                        a++;
                    }
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("应该是10000");
        System.out.println(a);
    }
}
