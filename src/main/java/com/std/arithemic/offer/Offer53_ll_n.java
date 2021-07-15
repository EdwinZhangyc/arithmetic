package com.std.arithemic.offer;

/**
 * @author zyc
 * @date 2021/7/15 12:10
 */
public class Offer53_ll_n {

    static class Solution {
        public static void main(String[] args) {
            int[] nums = {0,1,2,3,4,5,6,7,9};
            System.out.println(missingNumber(nums));
        }
        public static int missingNumber(int[] nums) {
            if (nums == null) {
                return -1;
            }
            int left = 0,right = nums.length-1;
            while (left <= right) {
                int middle = left + ((right - left) >> 1);
                if (nums[middle] == middle) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            return left;
        }
    }
}