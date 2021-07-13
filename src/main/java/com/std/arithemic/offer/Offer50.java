package com.std.arithemic.offer;

import java.util.Objects;

/**
 * @author zyc
 * @date 2021/7/13 15:31
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 */
public class Offer50 {

    static class Solution {
        public static void main(String[] args) {
            System.out.println(firstUniqChar("abaccdeff"));
        }
        public static char firstUniqChar(String s) {
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (Objects.equals(s.indexOf(cur), s.lastIndexOf(cur))) {
                    return cur;
                }
            }
            return ' ';
        }
    }
}