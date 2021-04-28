package com.std.arithemic.geektime;

import com.std.arithemic.domain.ListNode;

import java.util.Objects;

/**
 * @author zyc
 * @date 2021/4/28 11:02
 * 删除链表倒数第 n 个结点
 */
public class Geek07_4 {

    static class Solution {
        public static ListNode deleteNodeV1 (ListNode l1, int n) {
            if (Objects.isNull(l1)) {
                return l1;
            }
            int count = nodeTotal (l1);
            if (n < 0 && count < n) {
                return null;
            }
            ListNode cur = l1;
            int index = 0;
            while (Objects.nonNull(cur)) {
                if (index == (count - n)) {
                    if (Objects.isNull(cur.next)) {
                        cur = null;
                        break;
                    }
                    cur = cur.next;
                }
                cur = cur.next;
                index ++;
            }
            return l1;
        }

        private static int nodeTotal(ListNode l1) {
            int count = 0;
            while (Objects.nonNull(l1)) {
                count ++;
                l1 = l1.next;
            }
            return count;
        }


    }
}