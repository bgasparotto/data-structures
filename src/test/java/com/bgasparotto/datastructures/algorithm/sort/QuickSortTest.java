package com.bgasparotto.datastructures.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {
    private final QuickSort sorter = new QuickSort();
    private final int[] inputArray = {20, 35, -15, 7, 55, 1, -22};

    @Test
    public void shouldSortInputArray() {
        sorter.sort(inputArray);
        assertThat(inputArray).containsExactly(-22, -15, 1, 7, 20, 35, 55);
    }
}
