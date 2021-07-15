package com.std.arithemic.geektime.datastruct;

/**
 * @author zyc
 * @date 2021/7/14 10:06
 */
public class Queue {

    // 数组实现队列
    class ArrayQueue {
        String[] queue;
        // 元素个数
        int caption;
        int tail;
        int head;

        ArrayQueue (int caption){
            queue = new String[caption];
            this.caption = caption;
            tail = 0;
            head = 0;
        }
        boolean offer (String obj) {
            if (tail == caption) {
                return false;
            }
            queue[tail++] = obj;
            return true;
        }
        String poll () {
            if (head == tail) {
                return null;
            }
            return queue[head++];
        }
    }
    // 数组队列扩容
    class DynamicArrayQueue {
        String[] queues;
        int caption;
        int tail;
        int head;

        DynamicArrayQueue(int caption) {
            queues = new String[caption];
            this.caption = caption;
            tail = 0;
            head = 0;
        }
        boolean offer (String obj) {
            if (caption == tail) {
                if (head == 0) {
                    return false;
                } else {
                    for (int i = head; i < queues.length; i++) {
                        queues[i-head] = queues[i];
                    }
                    head = 0;
                    tail -= head;
                }
            }
            queues[tail ++] = obj;
            return true;
        }
        String poll () {
            if (tail == head) {
                return null;
            }
            return queues[head++];
        }
    }
    // 环形数组队列
    class LoopArrayQueue {
        String[] queues;
        int caption;
        int tail;
        int head;

        LoopArrayQueue (int caption) {
            queues = new String[caption];
            this.caption = caption;
            tail = 0;
            head = 0;
        }
        boolean offer (String obj) {
            int tailIndex = (tail + 1) % caption;
            if (tailIndex == head) {
                return false;
            }
            queues[tail] = obj;
            tail = tailIndex;
            return true;
        }
        String poll () {
            if (head == tail) {
                return null;
            }
            String result = queues[head];
            head = (head + 1) % caption;
            return result;
        }
    }

}