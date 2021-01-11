package com.bgasparotto.datastructures.algorithm.sort;

import static com.bgasparotto.datastructures.util.ArrayOperations.swap;

/**
 * Bubble sort implementation just for reference purposes. It is strongly recommended not to use this algorithm in real
 * projects.
 */
public class BubbleSort {
    public void sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = (i + 1); j < input.length; j++) {

                if (input[i] > input[j]) {
                    swap(input, i, j);
                }
            }
        }
    }
}
