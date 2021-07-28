package com.std.arithemic.mihayou;

/**
 * @author zyc
 * @date 2021/7/28 15:49
 */
public class Offer03 {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            if (nums == null) {
                return -1;
            }
            for (int i = 0; i < nums.length; i++) {
                while (i != nums[i]) {
                    if(nums[i] == nums[nums[i]]) {
                        return nums[i];
                    }
                    int temp = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[nums[i]] = temp;
                }
            }
            return -1;
        }
    }
}