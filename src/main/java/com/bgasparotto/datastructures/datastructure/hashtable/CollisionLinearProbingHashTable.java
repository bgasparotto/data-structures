package com.bgasparotto.datastructures.datastructure.hashtable;

import java.util.Objects;
import java.util.Optional;

public class CollisionLinearProbingHashTable<K, V> implements CollisionSupportedHashTable<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private Entry<K, V>[] hashTable;
    private int size;

    public CollisionLinearProbingHashTable() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CollisionLinearProbingHashTable(int initialCapacity) {
        hashTable = (Entry<K, V>[]) new Entry[initialCapacity];
    }

    @Override
    public boolean put(K key, V value) {
        findHashedKey(key)
            .map(this::removeAtIndex);

        return findAvailableHashedKey(key)
            .map(hashedKey -> putAtIndex(hashedKey, key, value))
            .orElse(false);
    }

    private Optional<Integer> findAvailableHashedKey(K key) {
        int hashedKey = hashKey(key);
        if (hasNotCollided(hashedKey)) {
            return Optional.of(hashedKey);
        }
        return findAvailableHashedKeyByProbing(key);
    }

    private int hashKey(K key) {
        return Math.abs(key.hashCode()) % hashTable.length;
    }

    private boolean hasNotCollided(int hashedKey) {
        return hashTable[hashedKey] == null;
    }

    private Optional<Integer> findAvailableHashedKeyByProbing(K key) {
        int hashedKey = hashKey(key);
        int probingHashedKey = wrapOrIncrement(hashedKey);

        while (probingHashedKey != hashedKey) {
            if (hasNotCollided(probingHashedKey)) {
                return Optional.of(probingHashedKey);
            }
            probingHashedKey = probeHashedKey(probingHashedKey);
        }

        return Optional.empty();
    }

    private int wrapOrIncrement(int hashedKey) {
        if (hashedKey == hashTable.length - 1) {
            return 0;
        }
        return hashedKey + 1;
    }

    private int probeHashedKey(int candidateHashedKey) {
        return (candidateHashedKey + 1) % hashTable.length;
    }

    private boolean putAtIndex(int index, K key, V value) {
        hashTable[index] = new Entry<>(key, value);
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        return findHashedKey(key)
            .map(indexKey -> hashTable[indexKey].value)
            .orElse(null);
    }

    private Optional<Integer> findHashedKey(K key) {
        int hashedKey = hashKey(key);
        if (indexHasMatchingKey(hashedKey, key)) {
            return Optional.of(hashedKey);
        }
        return findHashedKeyByLinearProbing(key);
    }

    private boolean indexHasMatchingKey(int hashedKey, K key) {
        return Optional.ofNullable(hashTable[hashedKey])
            .map(entry -> Objects.equals(entry.key, key))
            .orElse(false);
    }

    private Optional<Integer> findHashedKeyByLinearProbing(K key) {
        int hashedKey = hashKey(key);
        int probingHashedKey = wrapOrIncrement(hashedKey);

        while (probingHashedKey != hashedKey) {
            if (indexHasMatchingKey(probingHashedKey, key)) {
                return Optional.of(probingHashedKey);
            }
            if (outOfLinearProbingRange(probingHashedKey)) {
                break;
            }
            probingHashedKey = probeHashedKey(probingHashedKey);
        }

        return Optional.empty();
    }

    private boolean outOfLinearProbingRange(int probingHashedKey) {
        return hashTable[probingHashedKey] == null;
    }

    @Override
    public V remove(K key) {
        return findHashedKey(key)
            .map(this::removeAtIndex)
            .orElse(null);
    }

    private V removeAtIndex(int index) {
        V value = hashTable[index].value;
        hashTable[index] = null;
        rehash();

        return value;
    }

    private void rehash() {
        Entry<K, V>[] oldHashTable = hashTable;
        clear();
        for (Entry<K, V> entry : oldHashTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        hashTable = (Entry<K, V>[]) new Entry[hashTable.length];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
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
