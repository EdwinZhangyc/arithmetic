package com.std.source.jdk;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zyc
 * @date 2021/6/10 11:08
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Integer> t = ThreadLocal.withInitial(() -> 1);
    private static final ThreadPoolExecutor threadPool =
        new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new SynchronousQueue());

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndDecrement();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadPool.execute(() -> {
                if (finalI % 3 == 0) {
                    ThreadLocalTest.t.set(finalI);
                }
                System.out.println(ThreadLocalTest.t.get());
            });
        }
    }
}