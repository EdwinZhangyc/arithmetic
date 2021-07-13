package com.std.arithemic.drill;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2021/7/13 9:48
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 *
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class Drill977 {

    static class Solution {

        public static void main(String[] args) {
            int[] nums = {-4,-1,0,3,10};
            System.out.println(Arrays.toString(sortedSquaresMultiV2(nums)));
        }

        public static int[] sortedSquares(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                result[i] = (int) Math.pow(nums[i], 2);
            }
            return result;
        }

        private static void quickSort (int[] nums, int startIndex, int endIndex) {
            if (startIndex < endIndex) {
                int standNum = Math.abs(nums[startIndex]);
                int lowIndex = startIndex;
                int highIndex = endIndex;

                while (lowIndex < highIndex) {
                    while (lowIndex < highIndex && Math.abs(nums[highIndex]) >= standNum ) {
                        highIndex --;
                    }
                    nums[lowIndex] = nums[highIndex];
                    while (lowIndex < highIndex && Math.abs(nums[lowIndex]) <= standNum) {
                        lowIndex ++;
                    }
                    nums[highIndex] = nums[lowIndex];
                }
                nums[lowIndex] = standNum;
                quickSort(nums, startIndex, lowIndex - 1);
                quickSort(nums, lowIndex + 1, endIndex);
            }
        }

        public static int[] sortedSquaresMultiV1(int[] nums) {
           if (nums[0] >= 0) {
               int[] result = new int[nums.length];
               for (int i = 0; i < nums.length; i++) {
                   result[i] = (int) Math.pow(nums[i], 2);
               }
               return result;
           } else if (nums[nums.length - 1] < 0) {
               int index = 0;
               int[] result = new int[nums.length];
               for (int i = nums.length - 1; i >= 0; i --) {
                   result[index ++] = (int) Math.pow(nums[i], 2);
               }
               return result;
           } else {
               return sortedSquares(nums);
           }
        }

        /**
         * 时间复杂度O(n)
         */
        public static int[] sortedSquaresMultiV2(int[] nums) {
            int n = nums.length - 1;
            int[] result = new int[nums.length];
            for (int i = 0, j = n, pos = n; i <= j;) {
                int left = (int)Math.pow(nums[i], 2);
                int right = (int)Math.pow(nums[j], 2);
                if (left > right) {
                    result[pos] = left;
                    i ++;
                } else {
                    result[pos] = right;
                    j --;
                }
                pos --;
            }
            return result;
        }
    }
}