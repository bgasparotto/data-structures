package com.bgasparotto.datastructures.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RadixSortTest {
    private final RadixSort sorter = new RadixSort();

    private final int[] inputRadix10Width4 = {4725, 4586, 1330, 8792, 1594, 5729};

    @Test
    public void shouldSortInputArrayOfDiscreteNumbers() {
        int radix = 10;
        int width = 4;

        sorter.sort(inputRadix10Width4, radix, width);
        assertThat(inputRadix10Width4).containsExactly(1330, 1594, 4586, 4725, 5729, 8792);
    }
}
