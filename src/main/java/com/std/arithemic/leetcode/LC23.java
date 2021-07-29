package com.std.arithemic.leetcode;

import com.std.arithemic.domain.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zyc
 * @date 2021/7/29 15:08
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 */
public class LC23 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            ListNode result = new ListNode(0);
            ListNode cur = result;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (ListNode list : lists) {
                if (list != null){
                    queue.offer(list);
                }
            }
            while(!queue.isEmpty()) {
                ListNode poll = queue.poll();
                cur.next = poll;
                cur = cur.next;
                if(poll.next != null) {
                    queue.offer(poll.next);
                }
            }
            return  result.next;
        }
    }
}