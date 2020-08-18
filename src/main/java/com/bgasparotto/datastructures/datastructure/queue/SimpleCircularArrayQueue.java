package com.bgasparotto.datastructures.datastructure.queue;

import java.util.NoSuchElementException;

public class SimpleCircularArrayQueue<E> implements SimpleQueue<E> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int CAPACITY_INCREMENT = 100;

    private E[] elements;
    private int frontIndex;
    private int backIndex;

    public SimpleCircularArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SimpleCircularArrayQueue(int initialCapacity) {
        this.elements = (E[]) new Object[initialCapacity];
    }

    @Override
    public void enqueue(E element) {
        if (needsResizing()) {
            resize();
        }
        enqueueAtBack(element);
    }

    private boolean needsResizing() {
        return size() == elements.length - 1;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = elements.length + CAPACITY_INCREMENT;
        E[] newStorageArray = (E[]) new Object[newCapacity];

        if (queueHasBeenWrapped()) {
            unwrapAndCopyInto(newStorageArray);
        } else {
            copyInto(newStorageArray);
        }

        frontIndex = 0;
        backIndex = elements.length - 1;
        elements = newStorageArray;
    }

    private boolean queueHasBeenWrapped() {
        return frontIndex > backIndex;
    }

    private void unwrapAndCopyInto(E[] newStorageArray) {
        int numberOfElementsToCopy = elements.length - frontIndex;
        System.arraycopy(elements, frontIndex, newStorageArray, 0, numberOfElementsToCopy);
        System.arraycopy(elements, 0, newStorageArray, numberOfElementsToCopy, backIndex);
    }

    private void copyInto(E[] newStorageArray) {
        int numberOfElementsToCopy = backIndex - frontIndex;
        System.arraycopy(elements, frontIndex, newStorageArray, 0, numberOfElementsToCopy);
    }

    private void enqueueAtBack(E element) {
        elements[backIndex] = element;
        backIndex = shouldWrapBackIndex() ? 0 : backIndex + 1;
    }

    private boolean shouldWrapBackIndex() {
        return backIndex == elements.length - 1;
    }

    @Override
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
        cleanAndUpdateIndexes();

        return dequeuedElement;
    }

    private void cleanAndUpdateIndexes() {
        elements[frontIndex] = null;
        if (isEmpty()) {
            frontIndex = 0;
            backIndex = 0;
            return;
        }
        if (shouldWrapFrontIndex()) {
            frontIndex = 0;
            return;
        }
        frontIndex++;
    }

    private boolean shouldWrapFrontIndex() {
        return frontIndex + 1 == elements.length;
    }

    @Override
    public E peek() {
        throwExceptionIfEmpty();
        return peekAtFront();
    }

    private E peekAtFront() {
        return elements[frontIndex];
    }

    @Override
    public int size() {
        if (queueHasBeenWrapped()) {
            return backIndex - frontIndex + elements.length;
        }
        return backIndex - frontIndex;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
