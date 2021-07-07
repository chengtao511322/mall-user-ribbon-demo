package com.ct.juc;

import com.ct.util.ThreadUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class AtomicTest {

    public void testAtomicStampeReference(){
        CountDownLatch latch = new CountDownLatch(2);

        AtomicStampedReference<Integer> atomicStampedRef = new AtomicStampedReference<>(1, 0);
        ThreadUtil.getMixedTargetThreadPool().submit(new Runnable() {
            @Override
            public void run() {
                boolean success = false;
                int stamp = atomicStampedRef.getStamp();
            }
        });
    }
}
