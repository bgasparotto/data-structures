package com.bgasparotto.datastructures.datastructure.queue;

import java.util.NoSuchElementException;

public class SimpleLinearArrayQueue<E> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int CAPACITY_INCREMENT = 100;

    private E[] elements;
    private int frontIndex;
    private int backIndex;

    public SimpleLinearArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SimpleLinearArrayQueue(int initialCapacity) {
        this.elements = (E[]) new Object[initialCapacity];
    }

    public void enqueue(E element) {
        resizeIfFull();
        enqueueAtBack(element);
    }

    private void resizeIfFull() {
        if (hasEnoughCapacity()) {
            return;
        }
        resize();
    }

    private boolean hasEnoughCapacity() {
        return backIndex < elements.length;
    }

    private void enqueueAtBack(E element) {
        elements[backIndex++] = element;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = elements.length + CAPACITY_INCREMENT;
        E[] newStorageArray = (E[]) new Object[newCapacity];

        System.arraycopy(elements, 0, newStorageArray, 0, elements.length);
        elements = newStorageArray;
    }

    public E dequeue() {
        throwExceptionIfEmpty();
        return dequeueFromFront();
    }

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
    }

    private E dequeueFromFront() {
        E dequeuedElement = peekAtFront();
        updateIndexes();

        return dequeuedElement;
    }

    private void updateIndexes() {
        elements[frontIndex++] = null;
        if (isEmpty()) {
            resetIndexes();
        }
    }

    private void resetIndexes() {
        frontIndex = 0;
        backIndex = 0;
    }

    public E peek() {
        throwExceptionIfEmpty();
        return peekAtFront();
    }

    private E peekAtFront() {
        return elements[frontIndex];
    }

    public int size() {
        return backIndex - frontIndex;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
