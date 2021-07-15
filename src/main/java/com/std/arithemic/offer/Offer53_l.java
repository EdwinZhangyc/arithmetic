package com.std.arithemic.offer;

/**
 * @author zyc
 * @date 2021/7/15 11:49
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 */
public class Offer53_l {
    static class Solution {

        public static void main(String[] args) {
            int[] nums = {5,7,7,8,8,10};
            System.out.println(searchV2(nums, 8));
        }
        public static int searchV2(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int count = 0;
            while (low <= high) {
                int middle = low + ((high - low) >> 1);
                if (nums[middle] == target) {
                    count++;
                    int highIndex = middle + 1;
                    while (highIndex <= high && nums[highIndex] == target) {
                        highIndex++;
                        count ++;
                    }
                    int lowIndex = middle - 1;
                    while (lowIndex >= low && nums[lowIndex] == target) {
                        lowIndex--;
                        count ++;
                    }
                    break;
                } else if (nums[middle] > target) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
            return count;
        }
        public static int search(int[] nums, int target) {
            int count = 0;
            if (nums == null) {
                return count;
            }
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num > target) {
                    break;
                } else if (num == target) {
                    count ++;
                }
            }
            return count;
        }
    }
}