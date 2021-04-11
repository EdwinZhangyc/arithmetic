package com.std.arithemic.offer;

/**
 * @author qushuang
 * @date 2021/4/11 下午9:53
 */
public class Offer17 {

    static class Solution {
        public static int[] printNumbers(int n) {
            if (n == 0) {
                return null;
            }
            int num = 1;
            while (n != 0) {
                num *= 10;
                n--;
            }
            int[] rest = new int[--num];
            for (int i = 0; i < num; i++) {
                rest[i] = i+1;
            }
            return rest;
        }
    }
}