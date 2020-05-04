package com.bgasparotto.datastructures.algorithm.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestIndex = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[largestIndex]) {
                    largestIndex = i;
                }
            }
            swap(intArray, largestIndex, lastUnsortedIndex);
        }

        for (int value : intArray) {
            System.out.println(value);
        }
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
