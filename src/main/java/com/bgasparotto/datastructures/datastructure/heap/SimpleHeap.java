package com.bgasparotto.datastructures.datastructure.heap;

import java.util.NoSuchElementException;
import java.util.Optional;

import static com.bgasparotto.datastructures.datastructure.heap.TreeNodeLocator.leftChildOf;
import static com.bgasparotto.datastructures.datastructure.heap.TreeNodeLocator.parentOf;
import static com.bgasparotto.datastructures.datastructure.heap.TreeNodeLocator.rightChildOf;
import static com.bgasparotto.datastructures.util.ArrayOperations.swap;

public class SimpleHeap {
    private static final int INITIAL_CAPACITY = 10;

    private int[] elements;
    private int nextIndex;

    public SimpleHeap() {
        this(INITIAL_CAPACITY);
    }

    public SimpleHeap(int initialCapacity) {
        elements = new int[initialCapacity];
    }

    public void add(int value) {
        elements[nextIndex] = value;
        heapifyUpwards(nextIndex);

        nextIndex++;
    }

    private void heapifyUpwards(int nodeIndex) {
        while (hasParent(nodeIndex) && nodeValueIsGreaterThanParent(nodeIndex)) {
            int parentIndex = parentOf(nodeIndex);
            swap(elements, nodeIndex, parentIndex);

            nodeIndex = parentIndex;
        }
    }

    private boolean hasParent(int nodeIndex) {
        int parentIndex = parentOf(nodeIndex);
        return parentIndex >= 0;
    }

    private boolean nodeValueIsGreaterThanParent(int nodeIndex) {
        int nodeValue = elements[nodeIndex];

        int parentIndex = parentOf(nodeIndex);
        int parentValue = elements[parentIndex];

        return nodeValue > parentValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return elements[0];
    }

    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty heap has no root");
        }
        return deleteAtIndex(0);
    }

    public int delete(int value) {
        return indexOf(value)
                .map(this::deleteAtIndex)
                .orElseThrow(() -> new NoSuchElementException("Heap does not have the value " + value));
    }

    private int deleteAtIndex(int index) {
        int deletedValue = elements[index];
        replaceDeletedValueAt(index);

        return deletedValue;
    }

    private void replaceDeletedValueAt(int index) {
        elements[index] = getAndClearRightmostLeafValue();
        nextIndex--;

        heapify(index);
    }

    private int getAndClearRightmostLeafValue() {
        int rightmostLeafValueIndex = nextIndex - 1;

        int rightmostLeafValue = elements[rightmostLeafValueIndex];
        clearAtIndex(rightmostLeafValueIndex);

        return rightmostLeafValue;
    }

    private void clearAtIndex(int index) {
        elements[index] = 0;
    }

    private void heapify(int nodeIndex) {
        heapifyUpwards(nodeIndex);
        heapifyDownwards(nodeIndex);
    }

    private void heapifyDownwards(int nodeIndex) {
        while (hasAtLeastLeftChild(nodeIndex) && nodeValueIsLessThanBiggestChild(nodeIndex)) {
            int biggestChildIndex = biggestChildOf(nodeIndex);
            swap(elements, nodeIndex, biggestChildIndex);

            nodeIndex = biggestChildIndex;
        }
    }

    private boolean hasAtLeastLeftChild(int nodeIndex) {
        int leftChildIndex = leftChildOf(nodeIndex);
        return leftChildIndex < nextIndex;
    }

    private boolean nodeValueIsLessThanBiggestChild(int nodeIndex) {
        int nodeValue = elements[nodeIndex];

        int biggestChildIndex = biggestChildOf(nodeIndex);
        int biggestChildValue = elements[biggestChildIndex];

        return nodeValue < biggestChildValue;
    }

    private int biggestChildOf(int nodeIndex) {
        int leftChildIndex = leftChildOf(nodeIndex);
        int rightChildIndex = rightChildOf(nodeIndex);

        if (rightChildIndex >= nextIndex) {
            return leftChildIndex;
        }

        int leftChildValue = elements[leftChildIndex];
        int rightChildValue = elements[rightChildIndex];

        return (leftChildValue > rightChildValue) ? leftChildIndex : rightChildIndex;
    }

    public Optional<Integer> indexOf(int value) {
        for (int i = 0; i < nextIndex; i++) {
            if (elements[i] == value) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }

    public boolean isEmpty() {
        return nextIndex == 0;
    }
}
