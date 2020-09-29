package com.bgasparotto.datastructures.algorithm.sort;

import static com.bgasparotto.datastructures.util.ArrayOperations.print;
import static com.bgasparotto.datastructures.util.ArrayOperations.swap;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};

        int lastUnsortedIndex = array.length - 1; // At the beginning, no indexes are sorted yet.
        for (int i = 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestIndex = 0;
            for (int j = i; j <= lastUnsortedIndex; j++) {
                if (array[j] > array[largestIndex]) {
                    largestIndex = j;
                }
            }
            swap(array, lastUnsortedIndex, largestIndex);
        }

        print(array);
    }
}
