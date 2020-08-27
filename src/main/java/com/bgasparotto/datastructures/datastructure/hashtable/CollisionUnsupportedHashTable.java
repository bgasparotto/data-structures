package com.bgasparotto.datastructures.datastructure.hashtable;

public class CollisionUnsupportedHashTable<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private V[] hashTable;
    private int size;

    public CollisionUnsupportedHashTable() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CollisionUnsupportedHashTable(int initialCapacity) {
        hashTable = (V[]) new Object[initialCapacity];
    }

    public boolean put(K key, V value) {
        int hashedKey = hashKey(key);
        return putIfNoCollision(hashedKey, value);
    }

    private int hashKey(K key) {
        return Math.abs(key.hashCode()) % hashTable.length;
    }

    private boolean putIfNoCollision(int hashedKey, V value) {
        if (hasCollided(hashedKey)) {
            return false;
        }
        put(hashedKey, value);
        return true;
    }

    private boolean hasCollided(int hashedKey) {
        return hashTable[hashedKey] != null;
    }

    private void put(int hashedKey, V value) {
        hashTable[hashedKey] = value;
        size++;
    }

    public V get(K key) {
        int hashedKey = hashKey(key);
        return hashTable[hashedKey];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
