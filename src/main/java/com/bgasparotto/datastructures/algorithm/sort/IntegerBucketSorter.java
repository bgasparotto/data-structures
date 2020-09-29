package com.bgasparotto.datastructures.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class IntegerBucketSorter {
    public static final int NUMBER_OF_BUCKETS = 10;

    public void sort(int[] input) {
        var buckets = createSortingBuckets();

        scatterInputIntoBuckets(input, buckets);
        sortBuckets(buckets);
        gatherFromBucketsIntoInput(buckets, input);
    }

    @SuppressWarnings("unchecked")
    private List<Integer>[] createSortingBuckets() {
        List<Integer>[] buckets = (List<Integer>[]) new List[NUMBER_OF_BUCKETS];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        return buckets;
    }

    private void scatterInputIntoBuckets(int[] input, List<Integer>[] buckets) {
        for (int value : input) {
            int hashedValue = hashValue(value);
            buckets[hashedValue].add(value);
        }
    }

    private int hashValue(int value) {
        int width = String.valueOf(value).length();
        return value / (int) Math.pow(10, width - 1);
    }

    private void sortBuckets(List<Integer>[] buckets) {
        for (List<Integer> bucket : buckets) {
            bucket.sort(Integer::compareTo);
        }
    }

    private void gatherFromBucketsIntoInput(List<Integer>[] buckets, int[] input) {
        int inputIndex = 0;
        int bucketIndex = 0;

        while (inputIndex < input.length) {
            List<Integer> currentBucket = buckets[bucketIndex++];
            for (int value : currentBucket) {
                input[inputIndex++] = value;
            }
        }
    }
}
