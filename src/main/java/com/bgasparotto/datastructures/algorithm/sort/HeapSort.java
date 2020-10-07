package com.bgasparotto.datastructures.algorithm.sort;

import static com.bgasparotto.datastructures.datastructure.heap.TreeNodeLocator.leftChildOf;
import static com.bgasparotto.datastructures.datastructure.heap.TreeNodeLocator.rightChildOf;
import static com.bgasparotto.datastructures.util.ArrayOperations.swap;

public class HeapSort {

    public void sort(int[] heapArray) {
        for (int i = heapArray.length - 1; i > 0; i--) {
            swap(heapArray, 0, i);
            heapifyRoot(heapArray, i);
        }
    }

    private void heapifyRoot(int[] heapArray, int lastIndex) {
        int nodeIndex = 0;
        while (hasAtLeastLeftChild(nodeIndex, lastIndex) && nodeValueIsLessThanBiggestChild(heapArray, nodeIndex, lastIndex)) {
            int biggestChildIndex = biggestChildOf(heapArray, nodeIndex, lastIndex);
            swap(heapArray, nodeIndex, biggestChildIndex);

            nodeIndex = biggestChildIndex;
        }
    }

    private boolean hasAtLeastLeftChild(int nodeIndex, int lastIndex) {
        int leftChildIndex = leftChildOf(nodeIndex);
        return leftChildIndex < lastIndex;
    }

    private boolean nodeValueIsLessThanBiggestChild(int[] heapArray, int nodeIndex, int lastIndex) {
        int nodeValue = heapArray[nodeIndex];

        int biggestChildIndex = biggestChildOf(heapArray, nodeIndex, lastIndex);
        int biggestChildValue = heapArray[biggestChildIndex];

        return nodeValue < biggestChildValue;
    }

    private int biggestChildOf(int[] heapArray, int nodeIndex, int lastIndex) {
        int leftChildIndex = leftChildOf(nodeIndex);
        int rightChildIndex = rightChildOf(nodeIndex);

        if (rightChildIndex >= lastIndex) {
            return leftChildIndex;
        }

        int leftChildValue = heapArray[leftChildIndex];
        int rightChildValue = heapArray[rightChildIndex];

        return (leftChildValue > rightChildValue) ? leftChildIndex : rightChildIndex;
    }
}
