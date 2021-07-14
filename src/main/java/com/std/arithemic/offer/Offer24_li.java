package com.std.arithemic.offer;

import com.std.arithemic.domain.ListNode;

import java.util.Objects;

/**
 * @author qushuang
 * @date 2021/4/11 下午10:26
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Offer24_li {
    static class Solution {
        public static ListNode reverseList(ListNode head) {
            ListNode cur = null;
            while (Objects.nonNull(head)) {
                ListNode t = head.next;
                head.next = cur;
                cur = head;
                head = t;
            }
            return cur;
        }
    }
}