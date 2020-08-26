package com.bgasparotto.datastructures.datastructure.hashtable;

public class CollisionChainingHashTableTest extends AbstractCollisionSupportedHashTableTest {

    @Override
    protected CollisionSupportedHashTable<Integer, String> createInstance() {
        return new CollisionChainingHashTable<>();
    }
}
