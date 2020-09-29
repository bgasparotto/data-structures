package com.bgasparotto.datastructures.course.algorithm.sort;

public class ShellSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // This outside for runs for as many times as a valid gap is calculated.
        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {

            // The algorithm from now on is similar to Insertion Sort, and works the same when gap = 1
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];
                int j = i;

                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = newElement;
            }
        }

        for (int value : intArray) {
            System.out.println(value);
        }
    }
}
