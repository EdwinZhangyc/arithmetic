package com.std.arithemic.sort;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2021/4/12 18:13
 *  * 给定一个待排序序列，首先经过一次调整，将序列构建成一个大顶堆，此时第一个元素是最大的元素，
 *  * 将其和序列的最后一个元素交换，然后对前n-1个元素调整为大顶堆，
 *  * 再将其第一个元素和末尾元素交换，这样最后即可得到有序序列。
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {5, 6, 1, 0, 2, 9};
        heapsort(nums, 6);
        System.out.println(Arrays.toString(nums));
    }
    static void heapsort(int[] nums, int n) {
        // 先建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapAdjust(nums, i, n);
        }
        for (int i = 0; i < n - 1; i++) {
            swap(nums, 0, n - i - 1);
            heapAdjust(nums, 0, n - i - 1);
        }
    }
    static void swap(int[] nums, int low, int high) {
        nums[low] = nums[low] + nums[high];
        nums[high] = nums[low] - nums[high];
        nums[low] = nums[low] - nums[high];
    }
    // 调整堆
    static void heapAdjust(int arr[], int index, int n) {
        int temp = arr[index];
        int child = 0;
        while (index * 2 + 1 < n) {
            child = index * 2 + 1;
            // child为左右孩子中较大的那个
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++;
            }
            // 如果指定节点大于较大的孩子 不需要调整
            if (temp > arr[child]) {
                break;
            } else {
                // 否则继续往下判断孩子的孩子 直到找到合适的位置
                arr[index] = arr[child];
                index = child;
            }
        }
        arr[index] = temp;
    }
}

class HeapSortV2 {

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 9, 1, 8, 3, 7, 4, 0};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void heapSort(int[] arr) {
        // 初始给定的是最后叶节点的父节点的索引位置
        int start = (arr.length - 2) / 2;
        // 先将数组调整为大顶堆
        for (int i = start; i >= 0; i--){
            maxHeap(arr, arr.length, i);
        }
        // 先把数组中的第0个数与最后一位进行交换，然后在将前面的处理为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i, 0);
        }
    }
    /**
     * 将数组转大顶堆
     *
     * @param arr   数组
     * @param size  数组长度
     * @param index 开始的位置，在数组转大顶堆的时候给定，初始给定的是最后叶节点的父节点
     */
    public static void maxHeap(int[] arr, int size, int index) {
        // 左子节点
        int leftNode = 2 * index + 1;
        // 右子节点
        int rightNode = 2 * index + 2;
        int max = index;
        // 和两个 子节点分别对比，找出最大的节点
        if (leftNode < size && arr[leftNode] > arr[max]) {
            max = leftNode;
        }
        if (rightNode < size && arr[rightNode] > arr[max]) {
            max = rightNode;
        }
        // 找到最大节点后进行互换
        if (max != index) {
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp;
            // 交换位置后可能将之前堆的排序打乱，因此进行递归排序
            maxHeap(arr, size, max);
        }

    }
}
