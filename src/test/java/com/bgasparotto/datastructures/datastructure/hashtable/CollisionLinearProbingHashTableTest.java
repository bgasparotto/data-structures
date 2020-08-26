package com.bgasparotto.datastructures.datastructure.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

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
