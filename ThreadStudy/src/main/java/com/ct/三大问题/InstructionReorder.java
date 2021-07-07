package com.ct.三大问题;

/**
 * 线程有序性问题
 */
public class InstructionReorder {
    //定义两个安全变量
    private volatile static int x = 0 ,y=0;

    //定义两个静态变量
    private static int a=0,b=0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (;;) {
            i++;
            x=0;
            y=0;
            a=0;
            b=0;
            //模拟两个线程轮流给a,b赋值
            Thread one = new Thread(new Runnable(){
                @Override
                public void run() {
                    a=1;//1
                    x=b;//2
                }
            });

            Thread other = new Thread(new Runnable(){
                @Override
                public void run() {
                    b=1;
                    y=a;
                }
            });

            one.start();
            other.start();
            one.join();
            other.join();
            String result = "第"+i+"次赋值:x="+x+"y="+y;
            if((x==0 && y==0)){
                System.err.println(result);
            }
        }


    }
}
