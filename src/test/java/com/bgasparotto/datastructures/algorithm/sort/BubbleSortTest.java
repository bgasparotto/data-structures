package com.bgasparotto.datastructures.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BubbleSortTest {
    private final BubbleSort sorter = new BubbleSort();

    @Test
    public void shouldSortSingleElementArray() {
        int[] input = {20};

        sorter.sort(input);

        assertThat(input).containsExactly(20);
    }

    @Test
    public void shouldSortAlreadySortedArray() {
        int[] input = {20, 35};

        sorter.sort(input);

        assertThat(input).containsExactly(20, 35);
    }

    @Test
    public void shouldSortUnsortedArray() {
        int[] input = {20, 35, -15, 7, 55, 1, -22};

        sorter.sort(input);

        assertThat(input).containsExactly(-22, -15, 1, 7, 20, 35, 55);
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldThrowNPEWhenInputArrayIsNull() {
        assertThatThrownBy(() -> sorter.sort(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldNotThrowErrorsWhenSortingEmptyArray() {
        int[] input = {};

        sorter.sort(input);

        assertThat(input).isEmpty();
    }
}
