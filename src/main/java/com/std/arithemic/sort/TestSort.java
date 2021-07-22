package com.std.arithemic.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyc
 * @date 2021/6/18 16:51
 */
public class TestSort {

    public static void main(String[] args) {
        int[] nums = {123,4,34,7,12,45,22};
//        bubbleSort(nums);
//        selectSort(nums);
//        insertSort(nums);
//        bucketSort(nums);
//        quickSort(nums);
//        heapSort(nums);
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort (int[] nums) {
        mergeSort(nums, 0, nums.length-1);
    }
    private static void mergeSort (int[] nums, int start, int end) {
        if (end > start) {
            int middleIndex = start + (end - start) / 2;
            mergeSort(nums, start, middleIndex);
            mergeSort(nums, middleIndex + 1, end);
            mergeSort(nums, start, middleIndex, end);
        }
    }
    private static void mergeSort(int[] arr, int low, int middle, int high) {
        int[] temp = new int[high - low + 1];
        int start = low, middleIndex = middle + 1, tempIndex = 0;
        while (start <= middleIndex && middleIndex <= high) {
            if (arr[start] > arr[middleIndex]) {
                temp[tempIndex++] = arr[middleIndex++];
            } else {
                temp[tempIndex++] = arr[start++];
            }
        }
        while (start <= middleIndex) {
            temp[tempIndex++] = arr[start++];
        }
        while (middleIndex <= high) {
            temp[tempIndex++] = arr[middleIndex++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i+low] = temp[i];
        }
    }

    private static void heapSort (int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            theHeap(nums, i, 0);
        }
    }
    private static void buildHeap(int[] nums) {
        int index = (nums.length-2)/2;
        for (int i = index ; i >= 0 ; i--) {
            theHeap(nums, nums.length, i);
        }
    }
    private static void theHeap(int[] nums,int size, int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int maxIndex = index;
        if (leftChild < size &&  nums[leftChild] > nums[maxIndex]){
            maxIndex = leftChild;
        }
        if (rightChild < size && nums[rightChild] > nums[maxIndex]) {
            maxIndex = rightChild;
        }
        if (maxIndex != index) {
            swap(nums, maxIndex, index);
            theHeap(nums, size, maxIndex);
        }
    }

    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }
    private static void quickSort(int[] nums, int start, int end) {
        int standNum = nums[start];
        int low = start;
        int high = end;
        while (high>low) {
            while (high>low && nums[high] > standNum) {
                high--;
            }
            nums[low] = nums[high];
            while (high>low && nums[low] < standNum) {
                low ++;
            }
            nums[high] = nums[low];
        }
        nums[low] = standNum;
        quickSort(nums, start, low - 1);
        quickSort(nums, low + 1, end);
    }

    private static void bucketSort (int[] nums) {
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
        int maxValueLength = String.valueOf(maxValue).length();
        for (int i = 0; i < maxValueLength; i++) {
            for(int num : nums) {
                int queueIndex = (num/(int)Math.pow(10, i))%10;
                queues[queueIndex].offer(num);
            }
            int arrIndex = 0;
            for (Queue<Integer> queue : queues) {
                while (!queue.isEmpty()) {
                    nums[arrIndex++] = queue.poll();
                }
            }
        }
    }

    private static void insertSort (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int j = i -1;
            while (j >=0 && nums[j] > temp) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
        }
    }

    private static void selectSort (int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int minIndex = i;
            for (int j = 1+i; j < nums.length; j++) {
                if (nums[minIndex]> nums[j]){
                    minIndex = j;
                }
            }
            if (minIndex!=i) {
                swap(nums, minIndex,i);
            }

        }
    }

    private static void bubbleSort (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length-i -1; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
                flag = false;
            }
            if (flag) {
                break;
            }
        }

    }
    private static void swap (int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}