package com.std.source.jdk;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zyc
 * @date 2021/6/17 16:46
 */
public class BlockingQueue {

    public static void main(String[] args) {
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        queue.offer("");

    }
}