package com.std.arithemic.drill;

import com.std.arithemic.domain.ListNode;

/**
 * @author zyc
 * @date 2021/7/16 10:36
 */
public class Drill19 {

    class Solution {
        public ListNode removeNthFromEndV2(ListNode head, int n) {
            if (head == null || n < 0) {
                return head;
            }
            ListNode result = new ListNode(0);
            result.next = head;
            ListNode first = head;
            ListNode cur = result;
            for (int i = 0; i < n; i++) {
                first = first.next;
            }
            while (first != null) {
                cur = cur.next;
                first = first.next;
            }
            cur.next = cur.next.next;
            return result.next;
        }
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || n < 0) {
                return head;
            }
            ListNode result = new ListNode(0);
            result.next = head;
            ListNode cur = result;
            int count = 0;
            while (head != null) {
                count ++;
                head = head.next;
            }
            for (int i=0; i < count - n; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return result.next;
        }
    }
}