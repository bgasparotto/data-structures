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
        return putIfNoCollision(value, hashedKey);
    }

    private int hashKey(K key) {
        return key.hashCode() % hashTable.length;
    }

    private boolean putIfNoCollision(V value, int hashedKey) {
        if (hasHasCollided(hashedKey)) {
            return false;
        }
        put(value, hashedKey);
        return true;
    }

    private void put(V value, int hashedKey) {
        hashTable[hashedKey] = value;
        size++;
    }

    private boolean hasHasCollided(int hashedKey) {
        return hashTable[hashedKey] != null;
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
