package com.std.arithemic.drill;

/**
 * @author zyc
 * @date 2021/7/15 10:33
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Drill557 {
    static class Solution {
        public static void main(String[] args) {
            System.out.println(reverseWords("Let's take LeetCode contest"));
        }
        public static String reverseWords(String s) {
            if (s == null || "".equals(s)) {
                return s;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String[] split = s.split(" ");
            for (int i = 0; i < split.length; i++) {
                String str = split[i];
                char[] chars = str.toCharArray();
                int left = 0, right=str.length() - 1;
                while (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                }
                stringBuilder.append(chars);
                if (i < split.length - 1) {
                    stringBuilder.append(' ');
                }
            }
            return stringBuilder.toString();
        }
    }
}