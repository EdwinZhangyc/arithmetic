package com.std.arithemic.mihayou;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyc
 * @date 2021/7/28 17:40
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 */
public class LC448 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<Integer>();
            int[] temp = new int[nums.length];
            for (int i=0; i<nums.length; i++) {
                temp[nums[i]-1] = 1;
            }
            for (int i=0; i<nums.length; i++) {
                if(temp[i] == 0) {
                    result.add(i+1);
                }
            }
            return result;
        }
    }
}