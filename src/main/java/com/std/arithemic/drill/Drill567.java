package com.std.arithemic.drill;

/**
 * @author zyc
 * @date 2021/7/19 10:40
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 */
public class Drill567 {
    static class Solution {

        public static void main(String[] args) {
            System.out.println(checkInclusion("abc", "bbbca"));
        }
        public static boolean checkInclusion(String s1, String s2) {
            if (s1 == null || s2 == null) {
                return false;
            } else if (s1.length() > s2.length()) {
                return false;
            }
            if (s2.contains(s1)) {
                return true;
            }
            char[] chars = s2.toCharArray();
            reverte (chars, 0 , chars.length - 1);
            return String.valueOf(chars).contains(s1);
        }

        private static void reverte(char[] chars, int start, int end) {
            while (end > start) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
    }
}