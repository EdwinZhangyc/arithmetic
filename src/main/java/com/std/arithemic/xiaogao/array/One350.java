package com.std.arithemic.xiaogao.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyc
 * @date 2021/7/19 11:53
 * 我们先来看一道题目：
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * 如果给定的数组已经排好序呢？将如何优化你的算法呢？
 */
public class One350 {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5,4,4};
        int[] nums2 = {9,4,4,4,8,4,6};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    static int[] intersectSort (int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }
        int[] result = new int[nums1.length];
        int index1 = 0, index2 = 0, resulytIndex=0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                result[resulytIndex++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(result, 0, resulytIndex);
    }

    static int[] intersect (int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);

    }



}