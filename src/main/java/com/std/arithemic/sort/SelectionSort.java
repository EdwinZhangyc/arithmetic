package com.std.arithemic.sort;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2019/3/15
 * @description 用时 O(N^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arrs = {5, 2, 6, 9, 1, 8, 3, 7, 4};
        //bubbleSort(arrs);
        //quickSort(arrs, 0, arrs.length - 1);
        funSelectionSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }


    public static void funSelectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int mink = i;

            for (int j = 1 + i; j < array.length; j++) {

                if (array[j] < array[mink])
                    mink = j;
            }

            if (mink != i) {
                int temp = array[mink];
                array[mink] = array[i];
                array[i] = temp;
            }
        }

    }


}