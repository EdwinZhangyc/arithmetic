package com.std.arithemic.sort;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2019/3/19
 * @description 希尔排序，解决了插入排序的缺点，如23456 后面加一个0 如果是插入排序，
 * 则需要每个进行对比替换，希尔只需要一次
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arrs = {5, 2, 6, 9, 1, 8, 3, 7, 4};
        funShellSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    private static void funShellSort(int[] arrs) {

        // 遍历所有步长（需要经历多少次排序）
        for (int d = arrs.length / 2; d > 0; d /= 2) {
            // 遍历步长中所有的数组
            for (int i = d; i < arrs.length; i += d) {
                // 遍历本组中所有的元素
                for (int j = i - d; j >= 0; j -= d) {
                    //如果当前元素大于加上步长后的那个元素，则进行替换
                    if (arrs[j] > arrs[j + d]) {
                        int tmp = arrs[j];
                        arrs[j] = arrs[j + d];
                        arrs[j + d] = tmp;
                    }
                }
            }
        }
    }
}