package com.std.arithemic.mihayou;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2021/7/28 14:45
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
public class LC215 {

    static class Solution {
        public static void main(String[] args) {
            int[] nums = {2,1};
            quickSort(nums, 0, nums.length - 1);
            System.out.println(Arrays.toString(nums));
            System.out.println(findKthLargest(nums, 2));
        }

        public static int findKthLargestMulti(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
        public static int findKthLargest(int[] nums, int k) {
            if (nums == null) {
                return -1;
            } else if( nums.length == 1) {
                return nums[0];
            }
            quickSort(nums, 0, nums.length-1);
            for(int i=0;i<nums.length;i++) {
                if(--k == 0) {
                    return nums[i];
                }
            }
            return -1;
        }
        static void quickSort(int[] nums, int start, int stop) {
            if (stop > start) {
                int stand = nums[start], low = start, high = stop;
                while(high > low) {
                    while(high>low && nums[high] <= stand) {
                        high --;
                    }
                    nums[low] = nums[high];
                    while(high>low && nums[low] >= stand) {
                        low ++;
                    }
                    nums[high] = nums[low];
                }
                nums[low]=stand;
                quickSort(nums, start, low -1);
                quickSort(nums,low + 1, stop);
            }
        }
    }
}