package com.ct.sychnorized;

import com.ct.jol.ObjectLock;
import org.openjdk.jol.vm.VM;

/**
 * 偏向锁
 */
public class InnerLockTest {

    public void showBiasedLock() throws InterruptedException {
        System.out.println(VM.current().details());
        //JVM延迟偏向锁
        Thread.sleep(5000);
        ObjectLock counter = new ObjectLock();

        //抢占锁前

    }
}
