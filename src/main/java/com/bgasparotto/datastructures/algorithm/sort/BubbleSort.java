package com.bgasparotto.datastructures.algorithm.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = intArray.length - 1; // Everything starts unsorted
             lastUnsortedIndex > 0; // You don't have to sort a single value
             lastUnsortedIndex-- // The sorted partition grows from right to left
        ) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
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
