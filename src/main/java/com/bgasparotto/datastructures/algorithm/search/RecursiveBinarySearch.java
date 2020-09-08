package com.bgasparotto.datastructures.algorithm.search;

import java.util.Optional;

public class RecursiveBinarySearch implements Search {
    private final int[] source;

    public RecursiveBinarySearch(int[] source) {
        this.source = source;
    }

    public Optional<Integer> find(int value) {
        return find(value, 0, source.length);
    }

    public Optional<Integer> find(int value, int start, int end) {
        if (start == end) {
            return Optional.empty();
        }

        int middle = (start + end) / 2;
        int candidate = source[middle];

        if (candidate > value) {
            return find(value, start, middle);
        }
        if (candidate < value) {
            return find(value, middle + 1, end);
        }
        return Optional.of(middle);
    }
}
