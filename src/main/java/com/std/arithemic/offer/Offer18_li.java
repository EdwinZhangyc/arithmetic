package com.std.arithemic.offer;

import com.std.arithemic.domain.ListNode;

import java.util.Objects;

/**
 * @author qushuang
 * @date 2021/4/11 下午10:05
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class Offer18_li {

    static class Solution {
        public ListNode deleteNodeV1(ListNode head, int val) {
            if (Objects.isNull(head)) {
                return null;
            }
            if (head.val == val) {
                return head.next;
            }
            ListNode cur = head;
            while (Objects.nonNull(cur.next) && cur.next.val != val) {
                cur = cur.next;
            }
            if (Objects.nonNull(cur.next)) {
                cur.next = cur.next.next;
            }
            return head;
        }
        public ListNode deleteNodeV2(ListNode head, int val) {
            ListNode pre = head, cur = head.next;
            while (Objects.nonNull(cur) && cur.val != val) {
                pre = cur;
                cur = cur.next;
            }
            if (Objects.nonNull(cur)) {
                pre.next = cur.next;
            }
            return head;
        }
    }
}