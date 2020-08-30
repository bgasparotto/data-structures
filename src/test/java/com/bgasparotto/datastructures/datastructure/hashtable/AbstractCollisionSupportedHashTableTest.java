package com.bgasparotto.datastructures.datastructure.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Since we know the hash key algorithm is = key.hashCode() % elementArray.length`, we will use Integer as keys so we
 * can infer the hash key for the default capacity of 10 of the internal element array.
 */
public abstract class AbstractCollisionSupportedHashTableTest {

    protected CollisionSupportedHashTable<Integer, String> hashTable;
    protected final String rick = "Rick";
    protected final String james = "James";
    protected final String lucy = "Lucy";

    protected abstract CollisionSupportedHashTable<Integer, String> createInstance();

    @BeforeEach
    public void setUp() {
        hashTable = createInstance();
    }

    @Test
    public void shouldPutElementsWhenHashKeysWontCollided() {
        assertThat(hashTable.put(1, rick)).isTrue();
        assertThat(hashTable.put(22, james)).isTrue();
        assertThat(hashTable.put(1003, lucy)).isTrue();
    }

    @Test
    public void shouldPutElementWhenHashKeyWouldCollide() {
        assertThat(hashTable.put(1, rick)).isTrue(); // hash key = 1
        assertThat(hashTable.put(31, james)).isTrue(); // hash key = 1
    }

    @Test
    public void shouldReplaceOldElementByNewerElementWhenPutInvokedWithSameKey() {
        assertThat(hashTable.put(1, rick)).isTrue();
        assertThat(hashTable.put(1, james)).isTrue();

        assertThat(hashTable.get(1)).isEqualTo(james);
        assertThat(hashTable.size()).isEqualTo(1);
    }

    @Test
    public void shouldGetElementByItsKey() {
        hashTable.put(1003, lucy);

        assertThat(hashTable.get(1003)).isEqualTo(lucy);
    }

    @Test
    public void shouldGetElementByKeyWhenCollisionHappens() {
        assertThat(hashTable.put(1, rick)).isTrue();
        assertThat(hashTable.put(11, james)).isTrue();
        assertThat(hashTable.put(111, lucy)).isTrue();

        assertThat(hashTable.get(1)).isEqualTo(rick);
        assertThat(hashTable.get(11)).isEqualTo(james);
        assertThat(hashTable.get(111)).isEqualTo(lucy);
    }

    @Test
    public void shouldGetNullWhenKeyIsNotPresent() {
        assertThat(hashTable.get(1000)).isNull();
    }

    @Test
    public void shouldRemoveElementByKey() {
        hashTable.put(1, rick);
        hashTable.put(31, james);

        assertThat(hashTable.remove(31)).isEqualTo(james);

        assertThat(hashTable.get(31)).isNull();
        assertThat(hashTable.size()).isEqualTo(1);
    }

    @Test
    public void shouldBeAbleToGetCollidingKeysAfterRemoval() {
        hashTable.put(1, rick);
        hashTable.put(31, james);
        hashTable.put(51, lucy);

        assertThat(hashTable.remove(31)).isEqualTo(james);

        assertThat(hashTable.get(31)).isNull();
        assertThat(hashTable.get(51)).isEqualTo(lucy);
    }

    @Test
    public void shouldReturnNullWhenRemovingNotExistentKey() {
        assertThat(hashTable.remove(1)).isNull();
    }

    @Test
    public void shouldReturnSizeZeroWhenHashTableHasNoElements() {
        assertThat(hashTable.size()).isEqualTo(0);
    }

    @Test
    public void shouldClearTheHashTable() {
        hashTable.put(1, rick);
        hashTable.put(5, james);

        hashTable.clear();

        assertThat(hashTable.get(1)).isNull();
        assertThat(hashTable.get(5)).isNull();
        assertThat(hashTable.isEmpty()).isTrue();
        assertThat(hashTable.size()).isEqualTo(0);
    }

    @Test
    public void shouldReturnSizeAccordingToElementsSuccessfullyPut() {
        assertThat(hashTable.put(1, rick)).isTrue();
        assertThat(hashTable.put(22, james)).isTrue();
        assertThat(hashTable.put(31, lucy)).isTrue();

        assertThat(hashTable.size()).isEqualTo(3);
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
