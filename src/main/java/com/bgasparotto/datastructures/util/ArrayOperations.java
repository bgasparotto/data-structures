package com.bgasparotto.datastructures.util;

public final class ArrayOperations {
    private ArrayOperations() {
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
