package com.ct.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class ThreadLocalTest {

    static class Foo{
        //实例总数
        static final AtomicInteger AMOUNT = new AtomicInteger(0);
        //对象的编号
        int index = 0;
        //对象的内容
        int bar = 10;
        //构造器
        public Foo(){
            System.out.println("调用构造函数");
            index = AMOUNT.incrementAndGet();//总数增加
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "index=" + index +
                    ", bar=" + bar +
                    '}';
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getBar() {
            return bar;
        }

        public void setBar(int bar) {
            this.bar = bar;
        }
    }

    //定义线程本地变量
    private static final ThreadLocal<Foo> LOCAL_FOO = new ThreadLocal<Foo>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //提交5个任务
        for (int i = 0; i < 5; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    //获取线程本地变量
                    if(LOCAL_FOO.get() == null){
                        //设置当前线程绑定的本地变量
                        LOCAL_FOO.set(new Foo());
                    }
                    System.out.println("初始的本底值"+LOCAL_FOO.get());
                    //每个线程执行10次
                    for (int j = 0; j < 10; j++) {
                        Foo foo = LOCAL_FOO.get();
                        foo.setBar(foo.getBar()+1);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("10次累加之后的本底值"+LOCAL_FOO.get());
                    //删除”线程本地变量“
                    LOCAL_FOO.remove();
                }
            });
        }
        Thread.sleep(1000);

        System.out.println(Foo.AMOUNT);
    }
}
