package com.std.arithemic.sort;

/**
 * @author zyc
 * @date 2021/4/12 18:12
 */
public class DubbleSort {

    public static void funcBubbleSort (int[] sourceArray) {
        boolean flag = true;
        for (int i = 1; i < sourceArray.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < sourceArray.length - 1 - i; j++) {
                if (sourceArray[j] > sourceArray[j + 1]) {
                    int temp = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }
}