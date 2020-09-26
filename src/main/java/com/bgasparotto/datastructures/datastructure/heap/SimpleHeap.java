package com.bgasparotto.datastructures.datastructure.heap;

import static com.bgasparotto.datastructures.algorithm.sort.common.ArrayOperations.swap;
import static com.bgasparotto.datastructures.datastructure.heap.TreeNodeLocator.parentOf;

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
        heapify(nextIndex);

        nextIndex++;
    }

    private void heapify(int nodeIndex) {
        int parentIndex = parentOf(nodeIndex);

        while (parentIsAccessible(parentIndex) && nodeValueIsGreaterThanParent(nodeIndex, parentIndex)) {
            swap(elements, nodeIndex, parentIndex);

            nodeIndex = parentIndex;
            parentIndex = parentOf(nodeIndex);
        }
    }

    private boolean parentIsAccessible(int parentIndex) {
        return parentIndex >= 0;
    }

    private boolean nodeValueIsGreaterThanParent(int nodeIndex, int parentIndex) {
        int nodeValue = elements[nodeIndex];
        int parentValue = elements[parentIndex];

        return nodeValue > parentValue;
    }
}
