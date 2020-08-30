package com.bgasparotto.datastructures.datastructure.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Since we know the hash key algorithm is = key.hashCode() % elementArray.length`, we will use Integer as keys so we
 * can infer the hash key for the default capacity of 10 of the internal element array.
 */
public class CollisionUnsupportedHashTableTest {

    private CollisionUnsupportedHashTable<Integer, String> hashTable;
    private final String rick = "Rick";
    private final String james = "James";
    private final String lucy = "Lucy";

    @BeforeEach
    public void setUp() {
        hashTable = new CollisionUnsupportedHashTable<>();
    }

    @Test
    public void shouldPutElementsWhenHashKeysWontCollided() {
        assertThat(hashTable.put(1, rick)).isTrue();
        assertThat(hashTable.put(22, james)).isTrue();
        assertThat(hashTable.put(1003, lucy)).isTrue();
    }

    @Test
    public void shouldNotPutElementWhenHashKeyWouldCollide() {
        assertThat(hashTable.put(1, rick)).isTrue(); // hash key = 1
        assertThat(hashTable.put(31, james)).isFalse(); // hash key = 1
    }

    @Test
    public void shouldGetElementByItsKey() {
        hashTable.put(1003, lucy);

        assertThat(hashTable.get(1003)).isEqualTo(lucy);
    }

    @Test
    public void shouldGetNullWhenKeyIsNotPresent() {
        assertThat(hashTable.get(1000)).isNull();
    }

    @Test
    public void shouldReturnSizeZeroWhenHashTableHasNoElements() {
        assertThat(hashTable.size()).isEqualTo(0);
    }

    @Test
    public void shouldReturnSizeAccordingToElementsSuccessfullyPut() {
        assertThat(hashTable.put(1, rick)).isTrue();
        assertThat(hashTable.put(22, james)).isTrue();
        assertThat(hashTable.put(31, lucy)).isFalse(); // hash key collision with rick

        assertThat(hashTable.size()).isEqualTo(2);
    }

    @Test
    public void shouldReturnIsEmptyTrueWhenHashTableHasNoElements() {
        assertThat(hashTable.isEmpty()).isTrue();
    }

    @Test
    public void shouldReturnIsEmptyFalseWhenHashTableHasAtLeastOneElement() {
        hashTable.put(1003, james);

        assertThat(hashTable.isEmpty()).isFalse();
    }
}
