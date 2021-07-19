package com.std.arithemic.xiaogao.array;

/**
 * @author zyc
 * @date 2021/7/19 14:09
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class Two14 {

    static class Solution {
        public static void main(String[] args) {
            String[] strings = {"c","acc","ccc"};
            System.out.println(longestCommonPrefix(strings));
        }
        public static String longestCommonPrefix(String[] strs) {
            if (strs == null) {
                return "";
            }
            String result = strs[0];
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                while (str.indexOf(result) != 0) {
                    if (result.length() == 0) {
                        return "";
                    }
                    result = result.substring(0, result.length() - 1);
                }
            }
            return result;
        }
    }
}