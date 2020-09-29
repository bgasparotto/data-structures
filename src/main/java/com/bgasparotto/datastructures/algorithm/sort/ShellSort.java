package com.bgasparotto.datastructures.algorithm.sort;

import static com.bgasparotto.datastructures.util.ArrayOperations.print;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};

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

        print(array);
    }
}
