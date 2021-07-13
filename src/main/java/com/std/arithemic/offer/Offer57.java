package com.std.arithemic.offer;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2021/7/13 15:57
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
public class Offer57 {

    static class Solution {
        public static void main(String[] args) {
            int[] nums = {14,15,16,22,53,60};
            System.out.println(Arrays.toString(twoSum(nums, 76)));
        }
        public int[] twoSumMulti(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int cur = nums[left] + nums[right];
                if (cur == target) return new int[]{nums[left], nums[right]};
                else if (cur > target) right--;
                else left++;
            }
            return new int[]{};
        }
        public static int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                int num = nums[i];
                if (num >= target) {
                    break;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    int num1 = nums[j];
                    if (num1 >= target) {
                        break;
                    }
                    if (num + num1 == target) {
                        result[0] = num;
                        result[1] = num1;
                        return result;
                    }
                }
            }
            return result;
        }
    }
}