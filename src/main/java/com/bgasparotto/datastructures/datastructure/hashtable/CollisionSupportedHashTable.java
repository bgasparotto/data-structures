package com.bgasparotto.datastructures.datastructure.hashtable;

public interface CollisionSupportedHashTable<K, V> {

    boolean put(K key, V value);

    V get(K key);

    V remove(K key);

    void clear();

    int size();

    boolean isEmpty();
}
