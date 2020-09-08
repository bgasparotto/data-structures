package com.bgasparotto.datastructures.algorithm.search;

public class RecursiveBinarySearchTest extends AbstractBinarySearchTest {

    @Override
    protected Search createInstance(int[] input) {
        return new RecursiveBinarySearch(input);
    }
}
