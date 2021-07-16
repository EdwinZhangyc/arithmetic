package com.std.arithemic.sort;

/**
 * @author zyc
 * @date 2021/6/18 16:51
 */
public class TestSort {

    public static void main(String[] args) {

    }

    private static void dubbleSort () {

    }

    private static void mergeSort (int[] nums, int start, int end) {
        if (end > start) {
            int middle = start+(end-start)>>1;
            mergeSort(nums, start, middle);
            mergeSort(nums, middle+1, end);
            merge (nums, start, middle, end);
        }
    }
    private static void merge(int[] nums, int start, int middle, int end) {
        int[] tempArr = new int[end-start+1];
        int left = start;
        int right = middle + 1;
        int index = 0;
        while (left <= middle && right <= end) {
            if (nums[left] > nums[right]) {
                tempArr[index++] = nums[right];
                right++;
            } else {
                tempArr[index++] = nums[left];
                left++;
            }
        }
        while (right <= end) {
            tempArr[index++] = nums[right];
            right++;
        }
        while (left <= middle) {
            tempArr[index++] = nums[left];
            left++;
        }
        for (int i = 0; i < tempArr.length; i++) {
            nums[i + start] = tempArr[i];
        }
    }
}