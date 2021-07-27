package com.std.arithemic.leetcode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zyc
 * @date 2021/7/27 15:55
 *
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 */
public class DP120 {
    static class Solution {

        public static void main(String[] args) {
            List<List<Integer>> params =  Lists.newArrayList(
                    Lists.newArrayList(2),
                    Lists.newArrayList(3,4),
                    Lists.newArrayList(6,5,7),
                    Lists.newArrayList(4,1, 8, 3)
                    );
            System.out.println(minimumTotalMulti(params));

        }
        public static int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null) {
                return -1;
            }
            if (triangle.size() < 2) {
                return triangle.get(0).get(0);
            }
            int[][] dps = new int[triangle.size()][];
            for (int i = 0; i < triangle.size(); i++) {
                dps[i] = new int[triangle.get(i).size()];
            }
            dps[0][0] = triangle.get(0).get(0);
            int result = Integer.MAX_VALUE;
            for (int i = 1; i < triangle.size(); i++) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    if (j == 0) {
                        dps[i][j] = dps[i - 1][j] + triangle.get(i).get(j);
                    } else if (j == triangle.get(i).size() - 1) {
                        dps[i][j] = dps[i - 1][j - 1] + triangle.get(i).get(j);
                    } else {
                        dps[i][j] = Math.min(dps[i - 1][j], dps[i - 1][j - 1]) + triangle.get(i).get(j);
                    }
                    if (i == triangle.size() - 1){
                        result = Math.min(result, dps[i][j]);
                    }
                }
            }
            return result;
        }
        public static int minimumTotalMulti(List<List<Integer>> triangle) {
            if (triangle == null) {
                return -1;
            }
            if (triangle.size() < 2) {
                return triangle.get(0).get(0);
            }
            int result = Integer.MAX_VALUE;
            for (int i = 1; i < triangle.size(); i++) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    if (j == 0) {
                        triangle.get(i).set(j, triangle.get(i-1).get(j) + triangle.get(i).get(j));
                    } else if (j == triangle.get(i).size()-1) {
                        triangle.get(i).set(j, triangle.get(i-1).get(j-1) + triangle.get(i).get(j));
                    } else {
                        triangle.get(i).set(j, Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)) + triangle.get(i).get(j));
                    }
                    if (i == triangle.size() - 1){
                        result = Math.min(result, triangle.get(i).get(j));
                    }
                }
            }
            return result;
        }
    }
}