package com.std.arithemic.geektime.drill;

/**
 * @author zyc
 * @date 2021/7/29 14:59
 */
public class Drill1 {
    /**
     * 数组
     * 实现一个支持动态扩容的数组
     *
     * 实现一个大小固定的有序数组，支持动态增删改操作
     *
     * 实现两个有序数组合并为一个有序数组  完成
     */
    static class DrillDynamicArray {
        int[] nums;
        int count;
        int tail;

        public DrillDynamicArray(int n) {
            nums = new int[n];
            count = 0;
            tail = 0;
        }

        public void insert (int obj) {
            // 需要扩容
            if (count == nums.length) {
                int[] temp = new int[count * 2];
                System.arraycopy(temp, 0, nums, 0, count);
                nums = temp;
            }
            nums[count++] = obj;
        }
    }
    /**
     * 链表
     * 实现单链表、循环链表、双向链表，支持增删操作
     *
     * 实现单链表反转  完成
     * 实现两个有序的链表合并为一个有序链表 完成
     * 实现求链表的中间结点 完成
     * 首次环检验  完成
     * k个链表 合并为一个有序链接  完成
     */
    //



}