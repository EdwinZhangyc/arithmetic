package com.std.arithemic.offer;

/**
 * @author qushuang
 * @date 2021/4/11 下午8:18
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 */
public class Offer10_II {
    static class Solution {
        public static int numWaysV1(int n) {
            int a = 1, b = 1;
            for (int i = 1; i < n; i++) {
                b += a;
                a = b - a;
                b %= 1000000007;
            }
            return b;
        }
        public static int numWaysV2(int n) {
            int a = 1, b = 1, sum;
            for (int i = 1; i < n; i++) {
                sum = (a + b) % 1000000007;
                a = b;
                b = sum;
            }
            return b;
        }
    }
}