package com.bgasparotto.datastructures.algorithm.sort;

import static com.bgasparotto.datastructures.util.ArrayOperations.print;

public class CountingSort {

    public void countingSort(int[] array, int min, int max) {
        int[] countingArray = new int[max - min + 1];
        for (int element : array) {
            countingArray[element - min]++;
        }

        int inputIndex = min;
        int countingIndex = 0;
        while (inputIndex <= max) {
            if (countingArray[countingIndex] == 0) {
                countingIndex++;
                continue;
            }
            countingArray[countingIndex]--;
            array[inputIndex++ - min] = countingIndex + 1;
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

        CountingSort sorter = new CountingSort();
        sorter.countingSort(input, 1, 10);
        print(input);
    }
}
