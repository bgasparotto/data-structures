package com.bgasparotto.datastructures.challenge;

public class StringRadixSort {

    public void sort(String[] array, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            sortAt(array, radix, i);
        }
    }

    private void sortAt(String[] array, int radix, int index) {
        int[] countingSortArray = createCountingSortArray(array, radix, index);
        accumulateCountForStableSort(countingSortArray);

        String[] tempArray = sortOnCount(array, index, countingSortArray);
        System.arraycopy(tempArray, 0, array, 0, array.length);
    }

    private int[] createCountingSortArray(String[] array, int radix, int index) {
        int[] countingSort = new int[radix];
        for (String element : array) {
            int elementDigit = getAtIndex(element, index);
            countingSort[elementDigit]++;
        }

        return countingSort;
    }

    private void accumulateCountForStableSort(int[] countingSort) {
        for (int i = 1; i < countingSort.length; i++) {
            countingSort[i] += countingSort[i - 1];
        }
    }

    private String[] sortOnCount(String[] array, int index, int[] countingSortArray) {
        int inputLength = array.length;
        String[] tempArray = new String[inputLength];
        for (int i = inputLength - 1; i >= 0; i--) {
            String inputElement = array[i];
            int elementDigit = getAtIndex(inputElement, index);
            int elementSortedPosition = --countingSortArray[elementDigit];
            tempArray[elementSortedPosition] = array[i];
        }
        return tempArray;
    }

    public int getAtIndex(String value, int index) {
        return value.charAt(index) - 'a';
    }
}
