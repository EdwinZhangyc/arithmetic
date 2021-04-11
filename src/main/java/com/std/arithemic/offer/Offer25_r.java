package com.std.arithemic.offer;

import com.std.arithemic.offer.domain.ListNode;

import java.util.Objects;

/**
 * @author qushuang
 * @date 2021/4/11 下午10:31
 *
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Offer25_r {

    static class Solution {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0), cur = result;
            while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
                if (l1.val > l2.val) {
                    cur.next = l2;
                    l2 = l2.next;
                } else {
                    cur.next = l1;
                    l1 = l1.next;
                }
                cur = cur.next;
            }
            cur.next = Objects.isNull(l1) ? l2 : l1;
            return result.next;
        }
    }
}