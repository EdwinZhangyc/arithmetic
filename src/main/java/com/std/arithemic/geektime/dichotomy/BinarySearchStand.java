package com.std.arithemic.geektime.dichotomy;

/**
 * @author zyc
 * @date 2021/7/15 11:27
 * 查找第一个值等于给定值的元素
 * 查找最后一个等于给定值的元素
 * 查找第一个大于等于给定值的元素
 * 查找最后一个小于等于给定值的元素
 */
public class BinarySearchStand {

    int binarySearchV4 (int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) >> 1;
            if (nums[middle] <= target) {
                if (middle == high || nums[middle + 1] > target) {
                    return middle;
                } else {
                    low = middle + 1;
                }
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    int binarySearchV3 (int[] nums, int target) {
        int low = 0,high = nums.length;
        while (low <= high) {
            int middle = low + (high - low) >> 1;
            if (nums[middle] >= target) {
                if (middle == 0 || nums[middle - 1] < target) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
    int binarySearchV2 (int[] nums, int target) {
        int low = 0,high = nums.length;
        while (low <= high) {
            int middle = low + (high - low) >> 1;
            if (nums[middle] == target) {
                while (middle <= high && nums[middle] == target) {
                    middle ++;
                }
                return middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
    int binarySearchV1 (int[] nums, int target) {
        int low = 0,high = nums.length;
        while (low <= high) {
            int middle = low + (high - low) >> 1;
            if (nums[middle] == target) {
                while (middle >= low && nums[middle] == target) {
                    middle --;
                }
                return middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    int binarySearch (int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int middle = low + (high - low)>>1;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}