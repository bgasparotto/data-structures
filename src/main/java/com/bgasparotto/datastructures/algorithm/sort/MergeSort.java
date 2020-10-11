package com.bgasparotto.datastructures.algorithm.sort;

public class MergeSort {
    public void sort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    private void mergeSort(int[] array, int start, int end) {
        if (isSingleElementPartition(start, end)) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    private boolean isSingleElementPartition(int start, int end) {
        return (end - start) <= 1;
    }

    private void merge(int[] array, int start, int mid, int end) {
        if (isLeftPartitionLessThanRightPartition(array, mid)) {
            return;
        }

        int i = start;
        int j = mid;
        int[] sorted = new int[end - start];
        int sortedIndex = 0;

        // Sorts into sorted array until either of the two partitions are completely copied
        while (i < mid && j < end) {
            if (array[i] <= array[j]) {
                sorted[sortedIndex++] = array[i++];
            } else {
                sorted[sortedIndex++] = array[j++];
            }
        }

        // Copies the remaining sorted items, if any, from the left partition. Anything on the right is already sorted.
        while (i < mid) {
            sorted[sortedIndex++] = array[i++];
        }

        /*
         * Copies the sorted array into the original array. This skips anything on the right that wasn't iterated over
         * if the left partition finished first, meaning the remaining values on the right are already on their place.
         */
        int sortedCopyIndex = 0;
        while (sortedCopyIndex < sortedIndex) {
            array[start++] = sorted[sortedCopyIndex++];
        }
    }

    /*
     * Optimisation: if the last element from left partition is less than the first element of the right partition,
     * considering both array partitions are individually sorted, then the pair of partitions is also already sorted
     */
    private boolean isLeftPartitionLessThanRightPartition(int[] array, int mid) {
        return array[mid - 1] <= array[mid];
    }
}
