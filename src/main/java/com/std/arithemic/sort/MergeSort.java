package com.std.arithemic.sort;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2019/3/15
 * @description 归并排序: (Arrays.sort 就是使用归并排序的变体来实现的)
 * 是分治法的一个典型应用，它的主要思想是：将待排序序列分为两部分，对每部分递归地应用归并排序，在两部分都排好序后进行合并。
 * <p>
 * <p>
 * 例如，排序序列(3,2,8,6,7,9,1,5)的过程是，先将序列分为两部分，(3,2,8,6)和(7,9,1,5)，
 * 然后对两部分分别应用归并排序，第1部分(3,2,8,6)，第2部分(7,9,1,5)，对两个部分分别进行归
 * 并排序，第1部分继续分为(3,2)和(8,6)，(3,2)继续分为(3)和(2)，(8,6)继续分为(8)和(6)，
 * 之后进行合并得到(2,3)，(6,8)，再合并得到(2,3,6,8)，第2部分进行归并排序得到(1,5,7,9)，
 * 最后合并两部分得到(1,2,3,5,6,7,8,9)。
 * <p>
 * 用时 O(logN)
 */
public class MergeSort {

    /**
     * 归并排序   首先将数组进行差分，分成一个数组中只有一个值得情况   在进行合并比较。
     */
    public static void main(String[] args) {
        int[] arrs = {5, 2, 6, 9, 1, 8, 3, 7, 4};
        mergeSort(arrs, 0, arrs.length - 1);
        System.out.println(Arrays.toString(arrs));
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (high > low) {
            int middle = low + ((high - low) >> 1);
            // 处理左边
            mergeSort(arr, low, middle);
            // 处理右边
            mergeSort(arr, middle + 1, high);
            // 归并
            merge(arr, low, middle, high);
        }
    }

    static void merge(int[] arr, int low, int middle, int high) {
        // 用于存储并后的临时数组
        int[] temp = new int[high - low + 1];
        // 记录第一个数组中需要遍历的下标
        int i = low;
        // 记录第二个数组中需要遍历的下标
        int j = middle + 1;
        // 记录在临时数组中存放的下标
        int index = 0;
        // 遍历两个数组取出小的数字，放入到临时数组中
        while (i <= middle && j <= high) {
            // 第一个数组的数据更小
            if (arr[i] <= arr[j]) {
                //将小的数据放入到临时数组中
                temp[index++] = arr[i];
                i++;
            } else {
                temp[index++] = arr[j];
                j++;
            }
        }
        // 处理多余数据
        while (j <= high) {
            temp[index++] = arr[j];
            j++;
        }
        while (i <= middle) {
            temp[index++] = arr[i];
            i++;
        }
        // 把临时数据添加到原数组中
        for (int k = 0; k < temp.length; k++)
            arr[k + low] = temp[k];
    }
}