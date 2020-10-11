package com.bgasparotto.datastructures.algorithm.sort;

public class CountingSort {

    public void sort(int[] array, int min, int max) {
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
}
