package com.bgasparotto.datastructures.util;

import java.util.Arrays;

public final class ArrayOperations {
    private ArrayOperations() {
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print(String[] array) {
        System.out.println(Arrays.toString(array));
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
