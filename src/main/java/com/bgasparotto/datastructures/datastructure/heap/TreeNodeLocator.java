package com.bgasparotto.datastructures.datastructure.heap;

/**
 * Finds the relative nods of a given node on index i, then returning:
 * <pre>
 * Parent at: floor((i - 1) / 2);
 * Left child at: 2i + 1;
 * Right child at: 2i + 2;
 * </pre>
 */
public final class TreeNodeLocator {
    private TreeNodeLocator() {
    }

    public static int parentOf(int nodeIndex) {
        return (nodeIndex - 1) / 2;
    }

    public static int leftChildOf(int nodeIndex) {
        return 2 * nodeIndex + 1;
    }

    public static int rightChildOf(int nodeIndex) {
        return 2 * nodeIndex + 2;
    }
}
