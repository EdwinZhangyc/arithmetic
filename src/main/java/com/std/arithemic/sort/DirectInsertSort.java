package com.std.arithemic.sort;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2021/4/12 17:51
 */
public class DirectInsertSort {

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 9, 1, 8, 3, 7, 4};
        directInsertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void directInsertSort(int[] nums) {
        for (int i = 1; i < nums.length; i ++) {
            int temp = nums[i];
            int j = i - 1;
            while (j > 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j --;
            }
            nums[j + 1] = temp;
        }
    }
}