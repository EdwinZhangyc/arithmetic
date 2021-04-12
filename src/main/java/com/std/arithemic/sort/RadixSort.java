package com.std.arithemic.sort;

import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zyc
 * @date 2021/3/29 15:28
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arrs = {5, 2, 61, 9, 1222, 812, 0, 3, 72, 4};
        //funRadixArraySort (arrs);
        funRadixQueueSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    private static void funRadixArraySort(int[] arrs) {

        // 声明一个二维数组
        int[][] channelArr = new int[10][arrs.length];
        // 声明一个记录数组
        int[] recordArr = new int[10];
        // 得到数组中最大的值
        int maxNum = Integer.MIN_VALUE;
        for (int value : arrs) {
            if (value > maxNum) {
                maxNum = value;
            }
        }
        // 很据最大值得到位数
        int data = String.valueOf(maxNum).length();
        // 很据位数进行循环遍历
        for (int i = 0; i <= data; i++) {
            // 遍历目标数组
            for (int arr : arrs) {
                // 得到位数每一次循环后个位数的值
                int unitData = (arr / (int) Math.pow(10, i)) % 10;
                // 将个位数进行入值
                channelArr[unitData][recordArr[unitData]] = arr;
                // 记录该位置已经有值
                recordArr[unitData]++;
            }
            // 目标数组索引
            int indexGoal = 0;
            // 取数
            for (int j = 0; j < recordArr.length; j++) {
                if (recordArr[j] != 0) {
                    for (int k = 0; k < recordArr[j]; k++) {
                        // 取出数据,将二维数组中的数据放入到目标数组中
                        arrs[indexGoal++] = channelArr[j][k];
                    }
                    // 将记录数组置0
                    recordArr[j] = 0;
                }
            }
        }
    }

    private static void funRadixQueueSort(int[] arrs) {

        ConcurrentLinkedQueue<Integer>[] channelQueue = new ConcurrentLinkedQueue[10];
        for (int i = 0; i < channelQueue.length; i++) {
            channelQueue[i] = new ConcurrentLinkedQueue<>();
        }
        int maxVal = Integer.MIN_VALUE;
        for (int value : arrs) {
            if (value > maxVal) {
                maxVal = value;
            }
        }
        int nuitNum = String.valueOf(maxVal).length();
        for (int i = 0; i < nuitNum; i++) {
            for (int arr : arrs) {
                int nuitData = (arr / (int) Math.pow(10, i)) % 10;
                channelQueue[nuitData].offer(arr);
            }
            int index = 0;
            for (java.util.Queue<Integer> integers : channelQueue) {
                while (!integers.isEmpty()) {
                    arrs[index++] = integers.poll();
                }
            }
        }
    }

}