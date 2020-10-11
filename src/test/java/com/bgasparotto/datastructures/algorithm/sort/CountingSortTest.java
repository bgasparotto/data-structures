package com.bgasparotto.datastructures.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountingSortTest {
    private final CountingSort sorter = new CountingSort();

    private final int[] inputDiscreteArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

    @Test
    public void shouldSortInputArrayOfDiscreteNumbers() {
        int minNumber = 1;
        int maxNumber = 10;

        sorter.sort(inputDiscreteArray, minNumber, maxNumber);
        assertThat(inputDiscreteArray).containsExactly(2, 2, 3, 4, 5, 7, 8, 8, 9, 10);
    }
}
