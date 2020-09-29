package com.bgasparotto.datastructures.algorithm.sort;

import static com.bgasparotto.datastructures.util.ArrayOperations.print;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = {4725, 4586, 1330, 8792, 1594, 5729};

        RadixSort sorter = new RadixSort();
        sorter.sort(array, 10, 4);
        print(array);
    }

    public void sort(int[] array, int radix, int width) {
        for (int i = width; i > 0; i--) {
            sortAt(array, radix, i);
        }
    }

    public void sortAt(int[] array, int radix, int index) {
        int[] countingSortArray = createCountingSortArray(array, radix, index);
        accumulateCountForStableSort(countingSortArray);

        int[] tempArray = sortOnCount(array, radix, index, countingSortArray);
        System.arraycopy(tempArray, 0, array, 0, array.length);
    }

    private int[] createCountingSortArray(int[] array, int radix, int index) {
        int[] countingSort = new int[radix];
        for (int element : array) {
            int elementDigit = getAtIndex(element, radix, index);
            countingSort[elementDigit]++;
        }

        return countingSort;
    }

    private void accumulateCountForStableSort(int[] countingSort) {
        for (int i = 1; i < countingSort.length; i++) {
            countingSort[i] += countingSort[i - 1];
        }
    }

    private int[] sortOnCount(int[] array, int radix, int index, int[] countingSortArray) {
        int inputLength = array.length;
        int[] tempArray = new int[inputLength];
        for (int i = inputLength - 1; i >= 0; i--) {
            int inputElement = array[i];
            int elementDigit = getAtIndex(inputElement, radix, index);
            int elementSortedPosition = --countingSortArray[elementDigit];
            tempArray[elementSortedPosition] = array[i];
        }
        return tempArray;
    }

    public int getAtIndex(int value, int radix, int index) {
        int width = String.valueOf(value).length();
        return getAtIndex(value, radix, width, index);
    }

    public int getAtIndex(int value, int radix, int width, int index) {
        return (int) ((value / Math.pow(radix, width - index)) % radix);
    }
}
