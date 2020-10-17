package com.bgasparotto.datastructures.challenge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringRadixSortTest {
    private final StringRadixSort sorter = new StringRadixSort();
    private final String[] inputRadix26Width5 = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

    @Test
    public void shouldSortInputOfSpecifiedMatchingRadixAndWidth() {
        int radix = 26;
        int width = 5;

        sorter.sort(inputRadix26Width5, radix, width);
        assertThat(inputRadix26Width5).containsExactly("abcde", "bbbbb", "bcdef", "dbaqc", "omadd");
    }
}
