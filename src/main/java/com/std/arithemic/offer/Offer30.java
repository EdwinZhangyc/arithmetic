package com.std.arithemic.offer;

import java.util.Objects;
import java.util.Stack;

/**
 * @author zyc
 * @date 2021/7/12 17:28
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 */
public class Offer30 {

    class MinStack {
        Stack<Integer> A, B;

        /** initialize your data structure here. */
        public MinStack() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) {
            A.add(x);
            if (B.isEmpty() || B.peek() >= x) {
                B.add(x);
            }
        }

        public void pop() {
            if (Objects.equals(A.pop(), B.peek())) {
                B.pop();
            }
        }

        public int top() {
            return A.peek();
        }

        public int min() {
            return B.peek();
        }
    }
}