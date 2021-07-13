package com.std.arithemic.sort;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2021/4/12 18:13
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[4];
        int[] arrs = {5, 2, 6, 9, 1, 8, 3, 7, 4};
        quickSort(arrs, 0, arrs.length - 1);
        System.out.println(Arrays.toString(arrs));
    }

    public static void quickSort (int[] arr, int start, int end) {
        if (start < end) {
            int standNum = arr[start];
            int low = start;
            int height = end;

            while (low < height) {
                while (low < height && standNum <= arr[height]) {
                    height --;
                }
                arr[low] = arr[height];
                while (low < height && standNum >= arr[low]) {
                    low ++;
                }
                arr[height] = arr[low];
            }
            arr[low] = standNum;
            quickSort(arr, start, low - 1);
            quickSort(arr, low + 1, end);
        }
    }
}