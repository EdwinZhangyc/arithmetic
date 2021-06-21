package com.std.operate;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zyc
 * @date 2021/6/17 10:37
 * 动态配置
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        BasicThreadFactory basicThreadFactory = new BasicThreadFactory.Builder().namingPattern("-pool-%d").daemon(true).build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                0, 10, 10,
                        TimeUnit.MILLISECONDS, new SynchronousQueue<>(),
                basicThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        configExecutor(threadPoolExecutor);

    }

    private static void configExecutor (ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.getActiveCount();
        BasicThreadFactory threadFactory = (BasicThreadFactory) threadPoolExecutor.getThreadFactory();
        String namingPattern = threadFactory.getNamingPattern();
        System.out.println(namingPattern);
    }
}