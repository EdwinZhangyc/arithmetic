package com.std.arithemic.offer;

import java.util.Stack;

/**
 * @author qushuang
 * @date 2021/4/11 下午7:59
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class Offer09 {

    static class Solution {
        Stack<Integer> head;
        Stack<Integer> tail;

        public Solution () {
            head = new Stack<>();
            tail = new Stack<>();
        }

        public void appendTail (int value) {
            tail.push(value);
        }

        public int deleteHead () {
            if (head.empty()) {
                while (!tail.isEmpty()) {
                    head.push(tail.pop());
                }
            }
            if (head.empty()) {
                return -1;
            }
            return head.pop();
        }
    }
}