package com.std.arithemic.xiaogao.link;

import com.std.arithemic.domain.ListNode;

/**
 * @author zyc
 * @date 2021/7/19 16:13
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class One19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
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
    }
}