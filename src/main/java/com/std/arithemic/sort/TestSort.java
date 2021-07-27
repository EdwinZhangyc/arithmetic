package com.std.arithemic.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyc
 * @date 2021/7/23 10:28
 */
public class TestSort {

    public static void main(String[] args) {
        int[] nums = {63,129,30,2,24,88,99,17,290};
//        bubbleSort (nums);
//        insertSort (nums);
//        selectSort (nums);
//        mergeSort (nums);
//        bucketSort (nums);
//        quickSort(nums);
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void heapSort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swapNum(nums, i, 0);
            theHeap(nums, i, 0);
        }
    }
    private static void buildHeap(int[] nums) {
        int endNodeIndex = (nums.length-2) >> 1;
        for (int i = endNodeIndex; i >= 0; i--) {
            theHeap(nums, nums.length, i);
        }
    }
    private static void theHeap(int[] nums, int numsSize, int nodeIndex) {
        int leftChildInx = (nodeIndex << 1) + 1,
            rightChildInx = (nodeIndex << 1) + 2,
            maxIndex = nodeIndex;
        if (leftChildInx < numsSize && nums[leftChildInx] > nums[maxIndex]) {
            maxIndex = leftChildInx;
        }
        if (rightChildInx < numsSize && nums[rightChildInx] > nums[maxIndex]) {
            maxIndex = rightChildInx;
        }
        if (maxIndex != nodeIndex) {
            swapNum(nums, maxIndex, nodeIndex);
            theHeap(nums, numsSize, maxIndex);
        }
    }

    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }
    private static void quickSort(int[] nums, int startIndex, int endIndex) {
        if (endIndex > startIndex){
            int standNum = nums[startIndex], lowIndex = startIndex, highIndex = endIndex;
            while (highIndex > lowIndex) {
                while (highIndex > lowIndex && nums[highIndex] >= standNum) {
                    highIndex --;
                }
                nums[lowIndex] = nums[highIndex];
                while (highIndex > lowIndex && nums[lowIndex] <= standNum) {
                    lowIndex ++;
                }
                nums[highIndex] = nums[lowIndex];
            }
            nums[lowIndex] = standNum;
            quickSort(nums, startIndex, lowIndex - 1);
            quickSort(nums, lowIndex + 1, endIndex);
        }
    }

    private static void bucketSort(int[] nums) {
        Queue<Integer>[] queues = new LinkedList[10];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<>();
        }
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        int valLength = String.valueOf(maxValue).length();
        for (int i = 0; i < valLength; i++) {
            for (int num : nums) {
                int queueIndex = (num/(int)Math.pow(10, i))%10;
                queues[queueIndex].offer(num);
            }
            int numIndex = 0;
            for (Queue<Integer> queue : queues) {
                while (!queue.isEmpty()) {
                    nums[numIndex ++] = queue.poll();
                }
            }
        }
    }

    private static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }
    private static void mergeSort(int[] nums, int startIndex, int endIndex) {
        if (endIndex > startIndex) {
            int middleIndex = startIndex + ((endIndex - startIndex) >> 1);
            mergeSort(nums, startIndex, middleIndex);
            mergeSort(nums, middleIndex + 1, endIndex);
            mergeSort(nums, startIndex, middleIndex, endIndex);
        }
    }
    private static void mergeSort(int[] nums, int startIndex, int middleIndex, int endIndex) {
        int[] temp = new int[endIndex - startIndex + 1];
        int lowIndex = startIndex, highIndex = middleIndex + 1, tempIndex = 0;
        while (lowIndex <= middleIndex && highIndex <= endIndex) {
            if (nums[lowIndex] < nums[highIndex]) {
                temp[tempIndex++] = nums[lowIndex++];
            } else {
                temp[tempIndex++] = nums[highIndex++];
            }
        }
        while (lowIndex <= middleIndex) {
            temp[tempIndex++] = nums[lowIndex++];
        }
        while (highIndex <= endIndex) {
            temp[tempIndex++] = nums[highIndex++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i + startIndex] = temp[i];
        }
    }

    private static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swapNum(nums, minIndex, i);
            }
        }
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >=0 && nums[j] > temp) {
                nums[j + 1] = nums[j--];
            }
            nums[j + 1] = temp;
        }
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isSwap = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swapNum(nums, j, j + 1);
                    isSwap = false;
                }
            }
            if (isSwap) {
                break;
            }
        }
    }

    private static void swapNum (int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}