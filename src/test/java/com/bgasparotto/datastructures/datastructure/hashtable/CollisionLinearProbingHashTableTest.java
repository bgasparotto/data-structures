package com.bgasparotto.datastructures.datastructure.hashtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CollisionLinearProbingHashTableTest extends AbstractCollisionSupportedHashTableTest {

    @Override
    protected CollisionSupportedHashTable<Integer, String> createInstance() {
        return new CollisionLinearProbingHashTable<>();
    }

    @Test
    public void shouldNotPutElementWhenHashTableIsFull() {
        for (int i = 0; i < 10; i++) {
            hashTable.put(i, rick);
        }
        assertThat(hashTable.put(100, james)).isFalse();
    }
}
