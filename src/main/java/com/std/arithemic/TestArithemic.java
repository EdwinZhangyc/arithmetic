package com.std.arithemic;

import com.std.arithemic.domain.ListNode;

/**
 * @author zyc
 * @date 2021/7/13 20:13
 */
public class TestArithemic {

    public static void main(String[] args) {

    }
    ListNode hashNode (ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode fast = node, slow = node;
        while (true) {
            if (fast == null || slow == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast != slow) {
            return null;
        }
        ListNode result = node;
        while (slow != result) {
            slow = slow.next;
            result = result.next;
        }
        return result;
    }

    private static ListNode revert (ListNode node) {
        ListNode result = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = result;
            result = node;
            node = temp;
        }
        return result;
    }

    private static boolean loop (ListNode node) {
        if (node == null) {
            return false;
        }
        ListNode quickNode = node.next, slowNode = node;
        while (quickNode != slowNode) {
            if (quickNode == null && quickNode.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            quickNode = quickNode.next.next;
        }
        return true;
    }
}