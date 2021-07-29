package com.std.arithemic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyc
 * @date 2021/7/29 17:15
 */
public class LC15 {

    static class Solution1 {

        public static void main(String[] args) {
            System.out.println(hammingDistance(4, 1));
        }

        public static int hammingDistance(int x, int y) {
            int xor = x ^ y;
            int res = 0;
            while (xor != 0) {
                res += xor & 1;
                xor = xor >>> 1;
            }
            return res;
        }
    }

    static class Solution {
        public static void main(String[] args) {
            System.out.println(generate(6));
        }

        public static List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            if(numRows<=0) {
                return result;
            }
            for (int i=1;i<=numRows;i++) {
                List<Integer> o = new ArrayList<>();
                result.add(o);
            }
            result.get(0).add(1);
            if(numRows == 1) {
                return result;
            }
            for (int j=2;j<=numRows;j++) {
                int i = j-1;
                while (result.get(i).size()<j){
                    if(result.get(i).isEmpty()) {
                        result.get(i).add(1);
                    } else if(result.get(i).size() == i) {
                        result.get(i).add(1);
                    } else{
                        result.get(i).add(result.get(i-1).get(result.get(i).size()) +
                                result.get(i-1).get(result.get(i).size()-1));
                    }
                }
            }
            return result;

        }
    }
}