package com.bgasparotto.datastructures.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeapSortTest {
    private final HeapSort heapSorter = new HeapSort();
    private final int[] inputHeapArray = {80, 75, 60, 68, 55, 40, 52, 67};

    @Test
    public void shouldSortInputHeapArray() {
        heapSorter.sort(inputHeapArray);
        assertThat(inputHeapArray).containsExactly(40, 52, 55, 60, 67, 68, 75, 80);
    }
}
