package com.bgasparotto.datastructures.challenge;

import static com.bgasparotto.datastructures.util.ArrayOperations.print;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};

        RecursiveInsertionSort sorter = new RecursiveInsertionSort();
        sorter.sortFromUnsortedIndex(array, 1);
        print(array);
    }

    public void sortFromUnsortedIndex(int[] array, int unsortedIndex) {
        if (unsortedIndex >= array.length) {
            return;
        }

        int newElement = array[unsortedIndex];
        int j = unsortedIndex - 1;
        while (j >= 0 && array[j] >= newElement) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = newElement;

        sortFromUnsortedIndex(array, ++unsortedIndex);
    }
}
