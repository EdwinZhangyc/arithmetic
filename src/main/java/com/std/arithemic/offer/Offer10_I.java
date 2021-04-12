package com.std.arithemic.offer;

/**
 * @author qushuang
 * @date 2021/4/11 下午8:12
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 */
public class Offer10_I {
    static class Solution {
        public static int fibV1 (int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            int a = 0, b = 1;
            for (int i = 1; i < n; i++) {
                b += a ;
                a = b - a;
                b %= 1000000007;
            }
            return b;
        }
        static int fibV2 (int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            int a = 0, b = 1, sum;
            for (int i = 1; i < n; i++) {
                sum = (a + b) % 1000000007;
                a = b;
                b = sum;
            }
            return b;
        }
    }
}