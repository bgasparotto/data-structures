package com.bgasparotto.datastructures.algorithm.sort;

public class ShellSort {

    public void sort(int[] array) {
        for (int gap = array.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < array.length; i++) { // i = right index
                int newElement = array[i];
                int j = i - gap; // j = left index
                while (j >= 0 && array[j] >= newElement) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = newElement;
            }
        }
    }
}
