package com.std.arithemic.drill;

/**
 * @author zyc
 * @date 2021/7/12 16:15
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Drill35 {
    static class Solution {

        public static void main(String[] args) {
            int[] nums = {1,3};
            System.out.println(searchInsert(nums, 2));
        }

        public static int searchInsert(int[] nums, int target) {
            int lowIndex = 0;
            int highIndex = nums.length - 1;
            while (lowIndex <= highIndex) {
                int middleIndex = lowIndex + ((highIndex - lowIndex) >> 1);
                if (nums[middleIndex] == target) {
                    return middleIndex;
                } else if (nums[middleIndex] > target) {
                    highIndex = middleIndex - 1;
                    if (middleIndex == 0 || nums[highIndex] < target) {
                        return middleIndex;
                    } else if (nums[highIndex] == target) {
                        return highIndex;
                    }

                } else {
                    lowIndex = middleIndex + 1;
                    if (middleIndex == nums.length - 1 || nums[lowIndex] >= target) {
                        return lowIndex;
                    }
                }
            }
            return -1;
        }
    }

}