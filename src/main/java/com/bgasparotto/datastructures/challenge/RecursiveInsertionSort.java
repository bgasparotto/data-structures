package com.bgasparotto.datastructures.challenge;

public class RecursiveInsertionSort {
    public void sort(int[] array) {
        sortFromUnsortedIndex(array, 1);
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
