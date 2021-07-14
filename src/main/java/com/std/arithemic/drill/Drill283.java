package com.std.arithemic.drill;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2021/7/14 10:13
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Drill283 {

    static class Solution {

        public static void main(String[] args) {
            int[] nums = {0,1,0,3,12};
            moveZeroes(nums);
            System.out.println(Arrays.toString(nums));
        }

        public static void moveZeroes(int[] nums) {
            int n = nums.length, left=0, right=0;
            while (right < n) {
                if (nums[right] != 0) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left ++;
                }
                right ++;
            }
        }

        /**
         * 理解错误
         * @param nums
         */
        public static void moveZeroesError(int[] nums) {

            int n = nums.length - 1;
            int left=0, pos=n;
            while (left <= pos) {
                if (nums[pos] == 0) {
                    pos --;
                } else if (nums[left] == 0) {
                    nums[left++] = nums[pos];
                    nums[pos--] = 0;
                } else {
                    left ++;
                }
            }
            for (int i = 1; i <= pos; i++) {
                int temp = nums[i];
                int j = i - 1;
                while (j > -1 && nums[j] > temp) {
                    nums[j + 1] = nums[j];
                    j --;
                }
                nums[j + 1] = temp;
            }
        }
    }
}