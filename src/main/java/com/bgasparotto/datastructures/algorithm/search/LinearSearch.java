package com.bgasparotto.datastructures.algorithm.search;

import java.util.Objects;
import java.util.Optional;

public class LinearSearch {
    private final Object[] source;

    public LinearSearch(Object[] source) {
        this.source = source;
    }

    public LinearSearch(int[] source) {
        this.source = new Object[source.length];
        for (int i = 0; i < source.length; i++) {
            this.source[i] = source[i];
        }
    }

    public Optional<Integer> find(Object value) {
        for (int index = 0; index < source.length; index++) {
            if (Objects.equals(source[index], value)) {
                return Optional.of(index);
            }
        }

        return Optional.empty();
    }
}
