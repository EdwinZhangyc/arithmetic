package com.std.arithemic.offer;

import com.std.arithemic.domain.ListNode;

import java.util.Objects;
import java.util.Stack;

/**
 * @author qushuang
 * @date 2021/4/11 下午3:10
 */
public class Offer06 {

    public static void main(String[] args) {

    }

    static class Solution {
        /**
         * 最优解
         */
        public static int[] reversePrintV1(ListNode head) {
            int index = 0;
            ListNode cur = head;
            while (Objects.nonNull(cur)) {
                index ++;
                cur = cur.next;
            }
            int[] nums = new int[index];
            for (int i = index - 1; i >=0 ; i--) {
                nums[i] = head.val;
                head = head.next;
            }
            return nums;
        }
        /**
         * 第二优
         */
        public static int[] reversePrintV2(ListNode head) {
            ListNode rest = null;
            int index = 0;
            while (Objects.nonNull(head)) {
                ListNode t = head.next;
                head.next = rest;
                rest = head;
                head = t;
                index++;
            }
            int[] nums = new int[index];
            index = 0;
            while (Objects.nonNull(rest)) {
                nums[index++] = rest.val;
                rest = rest.next;
            }
            return nums;
        }
        /**
         * 第三优
         */
        public static int[] reversePrintV3(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            while(Objects.nonNull(head)) {
                stack.push(head.val);
                head = head.next;
            }
            int[] nums = new int[stack.size()];
            int i = 0;
            while(!stack.empty()){
                nums[i] = stack.pop();
                i++;
            }
            return nums;
        }
    }
}