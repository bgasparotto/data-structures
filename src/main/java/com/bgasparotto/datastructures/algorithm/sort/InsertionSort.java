package com.bgasparotto.datastructures.algorithm.sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            int i;

            /*
             * The for loop keeps going until we hit the beginning of the partition and the element on the left of i is
             * still greater, meaning we haven't found the right position for i yet.
             */
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }

        for (int value : intArray) {
            System.out.println(value);
        }
    }
}
