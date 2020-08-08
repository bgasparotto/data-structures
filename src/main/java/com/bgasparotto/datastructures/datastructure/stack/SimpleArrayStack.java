package com.bgasparotto.datastructures.datastructure.stack;

import java.util.EmptyStackException;

public class SimpleArrayStack<E> implements SimpleStack<E> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int CAPACITY_INCREMENT = 100;

    private E[] elements;
    private int topIndex;

    public SimpleArrayStack() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SimpleArrayStack(int initialCapacity) {
        elements = (E[]) new Object[initialCapacity];
    }

    @Override
    public void push(E element) {
        resizeIfNeeded();
        pushElement(element);
    }

    private void resizeIfNeeded() {
        if (hasEnoughCapacity()) {
            return;
        }
        resize();
    }

    private boolean hasEnoughCapacity() {
        return topIndex < elements.length;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = computeNewCapacity();
        E[] newStorageArray = (E[]) new Object[newCapacity];

        System.arraycopy(elements, 0, newStorageArray, 0, elements.length);
        elements = newStorageArray;
    }

    private void pushElement(E element) {
        elements[topIndex++] = element;
    }

    private int computeNewCapacity() {
        int currentCapacity = elements.length;

        if (currentCapacity == INITIAL_CAPACITY) {
            return CAPACITY_INCREMENT;
        }
        return currentCapacity + CAPACITY_INCREMENT;
    }

    @Override
    public E pop() {
        throwExceptionIfEmpty();
        return popElement();
    }

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    private E popElement() {
        return elements[--topIndex];
    }

    @Override
    public E peek() {
        throwExceptionIfEmpty();
        return peekElement();
    }

    private E peekElement() {
        return elements[topIndex - 1];
    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == 0;
    }
}
