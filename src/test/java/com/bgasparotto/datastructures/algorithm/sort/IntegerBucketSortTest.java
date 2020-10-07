package com.bgasparotto.datastructures.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerBucketSortTest {
    private final IntegerBucketSort sorter = new IntegerBucketSort();

    @Test
    public void shouldSortOneDigitPositiveIntegerInputArray() {
        int[] inputOneDigit = {5, 4, 8, 6, 9, 9, 4};

        sorter.sort(inputOneDigit);

        assertThat(inputOneDigit).isEqualTo(new int[]{4, 4, 5, 6, 8, 9, 9});
    }

    @Test
    public void shouldSortTwoDigitPositiveIntegerInputArray() {
        int[] input = {54, 46, 83, 66, 95, 92, 43};

        sorter.sort(input);

        assertThat(input).isEqualTo(new int[]{43, 46, 54, 66, 83, 92, 95});
    }

    @Test
    public void shouldSortThreeDigitPositiveIntegerInputArray() {
        int[] inputThreeDigits = {354, 346, 283, 966, 895, 992, 143};

        sorter.sort(inputThreeDigits);

        assertThat(inputThreeDigits).isEqualTo(new int[]{143, 283, 346, 354, 895, 966, 992});
    }
}
