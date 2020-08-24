package com.bgasparotto.datastructures.datastructure.hashtable;

import java.util.Objects;
import java.util.Optional;

public class CollisionLinearProbingHashTable<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private final Entry<K, V>[] hashTable;
    private int size;

    public CollisionLinearProbingHashTable() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CollisionLinearProbingHashTable(int initialCapacity) {
        hashTable = (Entry<K, V>[]) new Entry[initialCapacity];
    }

    public boolean put(K key, V value) {
        int hashedKey = hashKey(key);
        return putIfNotFull(hashedKey, key, value);
    }

    private int hashKey(K key) {
        return key.hashCode() % hashTable.length;
    }

    private boolean putIfNotFull(int hashedKey, K key, V value) {
        if (hasCollided(hashedKey)) {
            hashedKey = linearlyProbe(hashedKey);
        }
        return putIfNoCollision(hashedKey, key, value);
    }

    private int linearlyProbe(int hashedKey) {
        int candidateHashedKey = wrapOrIncrement(hashedKey);
        while (hasCollided(candidateHashedKey) && candidateHashedKey != hashedKey) {
            candidateHashedKey = probeHashedKey(candidateHashedKey);
        }

        return candidateHashedKey;
    }

    private int probeHashedKey(int candidateHashedKey) {
        return (candidateHashedKey + 1) % hashTable.length;
    }

    private int wrapOrIncrement(int hashedKey) {
        if (hashedKey == hashTable.length - 1) {
            return 0;
        }
        return hashedKey + 1;
    }

    private boolean putIfNoCollision(int hashedKey, K key, V value) {
        if (hasCollided(hashedKey)) {
            return false;
        }
        put(hashedKey, key, value);
        return true;
    }

    private boolean hasCollided(int hashedKey) {
        return hashTable[hashedKey] != null;
    }

    private void put(int hashedKey, K key, V value) {
        hashTable[hashedKey] = new Entry<>(key, value);
        size++;
    }

    public V get(K key) {
        int hashedKey = hashKey(key);
        if (hashedKeyIndexHasMatchingKey(hashedKey, key)) {
            return get(hashedKey);
        }

        hashedKey = findByLinearProbing(hashedKey, key);
        return get(hashedKey);
    }

    private boolean hashedKeyIndexHasMatchingKey(int hashedKey, K key) {
        Entry<K, V> entry = hashTable[hashedKey];
        if (entry == null) {
            return false;
        }
        return Objects.equals(key, entry.key);
    }

    private int findByLinearProbing(int hashedKey, K key) {
        int candidateHashedKey = wrapOrIncrement(hashedKey);
        while (!hashedKeyIndexHasMatchingKey(candidateHashedKey, key) && candidateHashedKey != hashedKey) {
            candidateHashedKey = probeHashedKey(candidateHashedKey);
        }

        return candidateHashedKey;
    }

    private V get(int hashedKey) {
        Entry<K, V> entry = hashTable[hashedKey];
        return Optional.ofNullable(entry)
            .map(e -> e.value)
            .orElse(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Entry<K, V> {

        private final K key;
        private final V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
