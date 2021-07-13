package com.std.arithemic.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zyc
 * @date 2021/7/13 14:41
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 */
public class Offer39 {

    static class Solution {
        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
            System.out.println(majorityElement(nums));
        }
        public static int majorityElement(int[] nums) {
            int middle = nums.length >> 1;
            Map<Integer,Integer> map = new HashMap<>();
            for (int num : nums) {
                if (Objects.nonNull(map.get(num))) {
                    int integer = map.get(num) + 1;
                    if (integer > middle) {
                        return num;
                    }
                    map.put(num, integer);
                } else {
                    map.put(num, 1);
                }
            }
            return -1;
        }

        public static int majorityElementV2(int[] nums) {
            int x=0, vote=0;
            for (int num : nums) {
                if (vote==0) {
                    x = num;
                }
                vote += num == x ? 1 : -1;
            }
            return x;
        }
    }
}