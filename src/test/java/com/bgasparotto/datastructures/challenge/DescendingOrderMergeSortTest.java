package com.bgasparotto.datastructures.challenge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DescendingOrderMergeSortTest {
    private final DescendingOrderMergeSort sorter = new DescendingOrderMergeSort();
    private final int[] inputArray = {20, 35, -15, 7, 55, 1, -22};

    @Test
    public void shouldSortInputArrayDescending() {
        sorter.sort(inputArray);
        assertThat(inputArray).containsExactly(55, 35, 20, 7, 1, -15, -22);
    }
}
