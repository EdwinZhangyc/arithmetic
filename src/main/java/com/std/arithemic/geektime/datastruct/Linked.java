package com.std.arithemic.geektime.datastruct;

import com.std.arithemic.domain.ListNode;

import java.util.Objects;

/**
 * @author zyc
 * @date 2021/7/13 20:44
 */
public class Linked {
    /**
     * 单链表反转 offer6 offer24
     *
     * 链表中环的检测 hash 快慢指针
     *
     * 首次入环节点
     *
     * 两个有序的链表合并 offer25
     *
     * 删除链表倒数第 n 个结点 drill19
     *
     * 求链表的中间结点 drill876
     *
     *
     */
    ListNode middleNodeV2 (ListNode node) {
        if (Objects.isNull(node)) {
            return node;
        }
        ListNode slow = node, fast = node.next;
        while (Objects.nonNull(fast)) {
            slow = slow.next;
            if (Objects.isNull(fast.next)) {
                break;
            }
            fast = fast.next.next;
        }
        return slow;
    }
    ListNode deleteNode (ListNode node, int k) {
        if (Objects.isNull(node)) {
            return node;
        }
        if (k == 1) {
            return node.next;
        }
        int index = 1;

        return node;
    }
    ListNode mergeNode (ListNode node1, ListNode node2) {
        ListNode result = new ListNode(0), cur = result;
        while (Objects.nonNull(node1) && Objects.nonNull(node2)) {
            if (node1.val > node2.val) {
                cur.next = node2;
                node2 = node2.next;
            } else {
                cur.next = node1;
                node1 = node1.next;
            }
            cur = cur.next;
        }
        cur.next = Objects.isNull(node1) ? node2 : node1;
        return result.next;
    }
    ListNode isFirstLoopNode (ListNode node) {
        ListNode fast = node.next, slow = node;
        while (!Objects.equals(fast, slow)) {
            if (Objects.isNull(fast) || Objects.isNull(fast.next)) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pos = node;
        while (!Objects.equals(pos, slow)) {
            pos = pos.next;
            slow = slow.next;
        }
        return pos;
    }
    boolean isLoop (ListNode node) {
        ListNode fast = node.next, slow = node;
        while (!Objects.equals(fast, slow)) {
            if (Objects.isNull(fast) || Objects.isNull(fast.next)) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
    ListNode one (ListNode node) {
        ListNode result = null;
        while (Objects.nonNull(node)) {
            ListNode temp = node.next;
            node.next = result;
            result = node;
            node = temp;
        }
        return result;
    }
}