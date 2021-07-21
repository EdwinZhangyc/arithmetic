package com.std.arithemic.offer;

/**
 * @author zyc
 * @date 2021/7/15 12:10
 * 278. 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 *
 * 示例 1：
 *
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 示例 2：
 *
 * 输入：n = 1, bad = 1
 * 输出：1
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