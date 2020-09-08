package com.bgasparotto.datastructures.algorithm.search;

public class IterativeBinarySearchTest extends AbstractBinarySearchTest {

    @Override
    protected Search createInstance(int[] input) {
        return new IterativeBinarySearch(input);
    }
}
