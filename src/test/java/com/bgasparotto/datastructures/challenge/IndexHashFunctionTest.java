package com.bgasparotto.datastructures.challenge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IndexHashFunctionTest {

    @Test
    public void shouldHashValueIntoIndexForArraysOfLength10() {
        IndexHashFunction hashFunction = new IndexHashFunction(10);

        assertThat(hashFunction.hash(59382)).isEqualTo(2);
        assertThat(hashFunction.hash(43)).isEqualTo(3);
        assertThat(hashFunction.hash(6894)).isEqualTo(4);
        assertThat(hashFunction.hash(500)).isEqualTo(0);
        assertThat(hashFunction.hash(99)).isEqualTo(9);
        assertThat(hashFunction.hash(-58)).isEqualTo(8);
    }
}
