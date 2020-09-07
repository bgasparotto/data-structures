package com.bgasparotto.datastructures.algorithm.search;

import com.bgasparotto.datastructures.model.SampleType;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class LinearSearchTest {

    @Test
    public void shouldFindIndexOfElementInIntegerArray() {
        int[] input = new int[]{20, 35, -15, 7, 55, 1, -22};
        LinearSearch linearSearch = new LinearSearch(input);

        Optional<Integer> result = linearSearch.find(35);

        assertThat(result).contains(1);
    }

    @Test
    public void shouldReturnEmptyOptionalIfIntegerElementNotPresent() {
        int[] input = new int[]{20, 35, -15, 7, 55, 1, -22};
        LinearSearch linearSearch = new LinearSearch(input);

        Optional<Integer> result = linearSearch.find(99);

        assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindIndexOfElementInStringArray() {
        String[] input = new String[]{"John", "Jack", "Jane"};
        LinearSearch linearSearch = new LinearSearch(input);

        Optional<Integer> result = linearSearch.find("Jane");

        assertThat(result).contains(2);
    }

    @Test
    public void shouldReturnEmptyOptionalIfStringElementNotPresent() {
        String[] input = new String[]{"John", "Jack", "Jane"};
        LinearSearch linearSearch = new LinearSearch(input);

        Optional<Integer> result = linearSearch.find("Robin");

        assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindIndexOfObjectElementInArray() {
        SampleType john = new SampleType(1, "John");
        SampleType mary = new SampleType(2, "Mary");
        SampleType[] input = new SampleType[]{john, mary};
        LinearSearch linearSearch = new LinearSearch(input);

        Optional<Integer> result = linearSearch.find(mary);

        assertThat(result).contains(1);
    }

    @Test
    public void shouldFindIndexOfDifferentInstanceObjectElementInArray() {
        SampleType john = new SampleType(1, "John");
        SampleType mary = new SampleType(2, "Mary");
        SampleType[] input = new SampleType[]{john, mary};
        LinearSearch linearSearch = new LinearSearch(input);

        Optional<Integer> result = linearSearch.find(new SampleType(2, "Mary"));

        assertThat(result).contains(1);
    }
}
