package com.std.arithemic.search;

/**
 * @author zyc
 * @date 2021/4/12 17:40
 */
public class BinarySearch {

    public static int binarySearchByWhile (int[] sourceArray, int targetValue) {
        int lowIndex = 0;
        int highIndex = sourceArray.length - 1;
        while (lowIndex <= highIndex) {
            int middleIndex = lowIndex + (highIndex - lowIndex) >> 1;
            if (targetValue == sourceArray[middleIndex]) {
                return middleIndex;
            } else if (targetValue < sourceArray[middleIndex]) {
                highIndex = middleIndex - 1;
            } else {
                lowIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    public static int binarySearchByRecursion (int[] sourceArray, int targetValue, int lowIndex, int highIndex) {
        if (lowIndex > highIndex) { return -1; }
        int middleIndex = lowIndex + ((highIndex - lowIndex) >> 1);
        if (targetValue < sourceArray[middleIndex]) {
            return binarySearchByRecursion (sourceArray, targetValue, lowIndex, middleIndex - 1);
        }
        return binarySearchByRecursion (sourceArray, targetValue, middleIndex + 1, highIndex);
    }
}