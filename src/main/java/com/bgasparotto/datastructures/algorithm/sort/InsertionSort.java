package com.bgasparotto.datastructures.algorithm.sort;

public class InsertionSort {
    public void sort(int[] array) {
        int firstUnsortedIndex = 1;
        for (int i = firstUnsortedIndex; i < array.length; i++) {
            int newElement = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] >= newElement) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = newElement;
        }
    }
}
