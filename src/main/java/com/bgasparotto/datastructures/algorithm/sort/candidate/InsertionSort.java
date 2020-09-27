package com.bgasparotto.datastructures.algorithm.sort.candidate;

import static com.bgasparotto.datastructures.algorithm.sort.common.ArrayOperations.print;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};

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

        print(array);
    }
}
