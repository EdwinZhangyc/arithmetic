package com.std.arithemic.offer;

/**
 * @author zyc
 * @date 2021/7/15 11:30剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 *
 */
public class Offer58 {

    static class Solution {
        public static void main(String[] args) {
            System.out.println(reverseLeftWords("lrloseumgh", 6));
        }
        public static String reverseLeftWords(String s, int n) {
            if (s == null || "".equals(s)) {
                return s;
            }
            char[] chars = s.toCharArray();
            n %= s.length();
            n = s.length() - n;
            revert (chars, 0, s.length()-1);
            revert (chars, 0, n - 1);
            revert (chars, n, s.length()-1);
            return String.valueOf(chars);
        }

        private static void revert(char[] chars, int left, int right) {
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left ++;
                right --;
            }
        }
    }
}