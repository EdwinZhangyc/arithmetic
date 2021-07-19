package com.std.arithemic.xiaogao.array;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2021/7/19 15:13
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class Six66 {
    static class Solution {
        public static void main(String[] args) {
            int[] nums = {4,9,9,8};
            System.out.println(Arrays.toString(plusOne(nums)));
        }
        public static int[] plusOne(int[] digits) {
            if (digits == null) {
                return null;
            }
            int pos = digits.length - 1;
            while (pos > -1 && digits[pos] == 9) {
                pos --;
            }
            if (pos == -1) {
                int[] ints = new int[digits.length + 1];
                ints[0] = 1;
                return ints;
            }
            digits[pos]++;
            for (int i = pos + 1; i < digits.length; i++) {
                digits[i] = 0;
            }
            return digits;
        }
    }
}