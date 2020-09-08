package com.bgasparotto.datastructures.algorithm.search;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractBinarySearchTest {

    protected abstract Search createInstance(int[] input);

    @Test
    public void shouldFindAllElementsInOddLengthArray() {
        int[] input = new int[]{-22, -15, 1, 7, 20, 35, 55};
        Search binarySearch = createInstance(input);

        for (int i = 0; i < input.length; i++) {
            int searchValue = input[i];
            assertThat(binarySearch.find(searchValue)).contains(i);
        }
    }

    @Test
    public void shouldReturnEmptyOptionalIfIntegerElementNotPresentInOddLengthArray() {
        int[] input = new int[]{-22, -15, 1, 7, 20, 35, 55};
        Search binarySearch = createInstance(input);

        Optional<Integer> result = binarySearch.find(99);

        assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindAllElementsInEvenLengthArray() {
        int[] input = new int[]{-22, -15, 1, 5, 7, 20, 35, 55};
        Search binarySearch = createInstance(input);

        for (int i = 0; i < input.length; i++) {
            int searchValue = input[i];
            assertThat(binarySearch.find(searchValue)).contains(i);
        }
    }

    @Test
    public void shouldReturnEmptyOptionalIfIntegerElementNotPresentInEvenLengthArray() {
        int[] input = new int[]{-22, -15, 1, 5, 7, 20, 35, 55};
        Search binarySearch = createInstance(input);

        Optional<Integer> result = binarySearch.find(99);

        assertThat(result).isEmpty();
    }
}
