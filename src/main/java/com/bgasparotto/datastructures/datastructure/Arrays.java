package com.bgasparotto.datastructures.datastructure;

public class Arrays {
    public static void main(String[] args) {
        var intArray = new int[7]; // Once an array is created, its size won't change
        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;

        for (int value : intArray) {
            System.out.println(value);
        }

        var otherIntArray = new int[]{2, 6, -54, 36};
        for (int value : otherIntArray) {
            System.out.println(value);
        }

        int[] anotherIntArray = {5, 8, 32, -10, 12, 33};
        for (int value : anotherIntArray) {
            System.out.println(value);
        }
    }
}
