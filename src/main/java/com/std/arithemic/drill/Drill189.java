package com.std.arithemic.drill;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zyc
 * @date 2021/7/13 10:54
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */
public class Drill189 {

    static class Solution {

        public static void main(String[] args) {
            int[] nums = {-1,-100,3,99};
            rotateV3(nums, 3);
            System.out.println(Arrays.toString(nums));
        }
        // 额外数组
        public static void rotateV1(int[] nums, int k) {
            int n = nums.length;
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[(i + k)%n] = nums[i];
            }
            System.arraycopy(result, 0, nums, 0, n);
        }
        // 环形替换
        public static void rotateV2(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            int count = gcd(k, n);
            for (int start = 0; start < count; ++start) {
                int current = start;
                int prev = nums[start];
                do {
                    int next = (current + k) % n;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    current = next;
                } while (start != current);
            }
        }
        public static int gcd(int x, int y) {
            return y > 0 ? gcd(y, x % y) : x;
        }
        // 翻转数组
        public static void rotateV3(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
        private static void reverse (int[] nums, int startIndex, int endIndex) {
            while (startIndex < endIndex) {
                nums[startIndex] = nums[startIndex] + nums[endIndex];
                nums[endIndex] = nums[startIndex] - nums[endIndex];
                nums[startIndex] = nums[startIndex] - nums[endIndex];
                startIndex ++;
                endIndex --;
            }
            Set<Object> set = new HashSet<>(10);
        }
    }
}