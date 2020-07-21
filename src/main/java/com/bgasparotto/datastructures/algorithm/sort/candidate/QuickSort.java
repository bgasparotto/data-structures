package com.bgasparotto.datastructures.algorithm.sort.candidate;

import static com.bgasparotto.datastructures.algorithm.sort.common.ArrayOperations.print;
import static com.bgasparotto.datastructures.algorithm.sort.common.ArrayOperations.swap;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};
        quickSort(array, 0, array.length);
        print(array);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (end - start < 2) { // if one-element partition
            return;
        }

        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int leftBorder = start + 1;

        /*
         * This algorithm moves all elements less than the pivot to the left, and assigns the pivot value at where the
         * last smaller value was moved. As a consequence, the pivot will be at the correct place with all elements to
         * the right being greater than it.
         */
        for (int i = leftBorder; i < end; i++) {
            if (array[i] < pivot) {
                swap(array, i, leftBorder++);
            }
        }

        swap(array, start, leftBorder - 1);
        return leftBorder - 1;
    }
}
