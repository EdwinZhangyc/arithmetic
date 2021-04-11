package com.std.arithemic.offer;

/**
 * @author qushuang
 * @date 2021/4/11 下午10:41
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Offer21 {

    static class Solution {
        public static int[] exchange(int[] nums) {
            int lowIndex = 0;
            int lastIndex = nums.length - 1;
            while (lowIndex < lastIndex) {
                if ((nums[lowIndex] & 1) != 0) {
                    lowIndex ++;
                } else if ((nums[lastIndex] & 1) == 0) {
                    lastIndex --;
                } else {
                    nums[lowIndex] = nums[lowIndex] + nums[lastIndex];
                    nums[lastIndex] = nums[lowIndex] - nums[lastIndex];
                    nums[lowIndex] = nums[lowIndex] - nums[lastIndex];
                }
            }
            return nums;
        }
    }
}