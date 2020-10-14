package com.bgasparotto.datastructures.algorithm.sort;

import static com.bgasparotto.datastructures.util.ArrayOperations.swap;

public class SelectionSort {
    public void sort(int[] array) {
        int lastUnsortedIndex = array.length - 1; // At the beginning, no indexes have been sorted yet.
        for (int i = 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestIndex = 0;
            for (int j = i; j <= lastUnsortedIndex; j++) {
                if (array[j] > array[largestIndex]) {
                    largestIndex = j;
                }
            }
            swap(array, lastUnsortedIndex, largestIndex);
        }
    }
}
