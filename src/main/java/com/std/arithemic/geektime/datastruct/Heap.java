package com.std.arithemic.geektime.datastruct;


/**
 * @author zyc
 * @date 2021/7/22 10:13
 */
public class Heap {
    // 数组，从下标 1 开始存储数据
    private int[] a;
    // 堆可以存储的最大数据个数
    private int n;
    // 堆中已经存储的数据个数
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n){
            return;
        }
        a[++count] = data;
        int i = count;
        // 自下往上堆化
        while (i/2 > 0 && a[i] > a[i/2]) {
            // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
            swap(a, i, i/2);
            i = i/2;
        }
    }
    private void swap(int[] arr, int source, int target) {
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }
    public void removeMax() {
        if (count == 0){
            return; // 堆中没有数据
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]){
                maxPos = i*2;
            }
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]){
                maxPos = i*2+1;
            }
            if (maxPos == i){
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }
}