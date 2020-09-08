package com.bgasparotto.datastructures.algorithm.search;

import java.util.Optional;

public class IterativeBinarySearch implements Search {
    private final int[] source;

    public IterativeBinarySearch(int[] source) {
        this.source = source;
    }

    public Optional<Integer> find(int value) {
        return find(value, 0, source.length);
    }

    public Optional<Integer> find(int value, int start, int end) {
        while (start < end) {
            int middle = (start + end) / 2;
            int candidate = source[middle];

            if (candidate == value) {
                return Optional.of(middle);
            }
            if (candidate > value) {
                end = middle;
            }
            if (candidate < value) {
                start = middle + 1;
            }
        }

        return Optional.empty();
    }
}
