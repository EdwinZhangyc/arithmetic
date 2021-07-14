package com.std.arithemic;

import com.std.arithemic.domain.ListNode;

/**
 * @author zyc
 * @date 2021/7/13 20:13
 */
public class TestArithemic {

    public static void main(String[] args) {

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