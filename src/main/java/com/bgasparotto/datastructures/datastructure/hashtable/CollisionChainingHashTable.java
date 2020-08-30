package com.bgasparotto.datastructures.datastructure.hashtable;

import com.bgasparotto.datastructures.datastructure.list.SimpleLinkedList;
import com.bgasparotto.datastructures.datastructure.list.SimpleSinglyLinkedList;

import java.util.Objects;
import java.util.Optional;

public class CollisionChainingHashTable<K, V> implements CollisionSupportedHashTable<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private SimpleLinkedList<Entry<K, V>>[] hashTable;
    private int size;

    public CollisionChainingHashTable() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CollisionChainingHashTable(int initialCapacity) {
        hashTable = (SimpleLinkedList<Entry<K, V>>[]) new SimpleLinkedList[initialCapacity];
    }

    @Override
    public boolean put(K key, V value) {
        int hashedKey = hashKey(key);
        var chain = findChainAtIndex(hashedKey)
                .orElseGet(() -> assignChainAtIndex(hashedKey));

        removeIfPresent(chain, key);
        addToChain(chain, key, value);
        return true;
    }

    private int hashKey(K key) {
        return Math.abs(key.hashCode()) % hashTable.length;
    }

    private Optional<SimpleLinkedList<Entry<K, V>>> findChainAtIndex(int index) {
        return Optional.ofNullable(hashTable[index]);
    }

    private SimpleLinkedList<Entry<K, V>> assignChainAtIndex(int index) {
        SimpleLinkedList<Entry<K, V>> chain = new SimpleSinglyLinkedList<>();
        hashTable[index] = chain;

        return chain;
    }

    private void addToChain(SimpleLinkedList<Entry<K, V>> chain, K key, V value) {
        chain.add(new Entry<>(key, value));
        size++;
    }

    @Override
    public V get(K key) {
        int hashedKey = hashKey(key);
        return findChainAtIndex(hashedKey)
                .flatMap(chain -> findInChain(chain, key))
                .orElse(null);
    }

    private Optional<V> findInChain(SimpleLinkedList<Entry<K, V>> chain, K key) {
        for (int i = 0; i < chain.size(); i++) {
            var entry = chain.get(i);

            if (Objects.equals(entry.key, key)) {
                return Optional.of(entry.value);
            }
        }
        return Optional.empty();
    }

    @Override
    public V remove(K key) {
        int hashedKey = hashKey(key);
        return findChainAtIndex(hashedKey)
                .flatMap(chain -> removeIfPresent(chain, key))
                .orElse(null);
    }

    private Optional<V> removeIfPresent(SimpleLinkedList<Entry<K, V>> chain, K key) {
        for (int i = 0; i < chain.size(); i++) {
            var entry = chain.get(i);

            if (Objects.equals(entry.key, key)) {
                removeAtChainIndex(chain, i);
                return Optional.of(entry.value);
            }
        }

        return Optional.empty();
    }

    private void removeAtChainIndex(SimpleLinkedList<Entry<K, V>> chain, int index) {
        chain.delete(index);
        size--;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        hashTable = (SimpleLinkedList<Entry<K, V>>[]) new SimpleLinkedList[hashTable.length];
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
