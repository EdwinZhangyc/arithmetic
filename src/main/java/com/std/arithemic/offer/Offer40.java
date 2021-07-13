package com.std.arithemic.offer;

/**
 * @author zyc
 * @date 2021/7/12 17:25
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Offer40 {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            quickSort(arr, 0, arr.length - 1);
            int[] result = new int[k];
            System.arraycopy(arr, 0, result, 0, k);
            return result;
        }

        private void quickSort (int[] arr, int startIndex, int endIndex) {
            if (startIndex < endIndex) {
                int standNum = arr[startIndex];
                int lowIndex = startIndex;
                int highIndex = endIndex;

                while (lowIndex < highIndex) {
                    while (lowIndex < highIndex && standNum <= arr[highIndex]) {
                        highIndex --;
                    }
                    arr[lowIndex] = arr[highIndex];
                    while (lowIndex < highIndex && standNum >= arr[lowIndex]) {
                        lowIndex ++;
                    }
                    arr[highIndex]  = arr[lowIndex];
                }
                arr[lowIndex] = standNum;
                quickSort(arr, startIndex, lowIndex - 1);
                quickSort(arr, lowIndex + 1, endIndex);
            }
        }
    }
}