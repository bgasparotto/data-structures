package com.bgasparotto.datastructures.datastructure.tree;

public class SimpleBinarySearchTree {
    private BinaryTreeNode root;
    private int size;

    public boolean add(int value) {
        if (isEmpty()) {
            return addRootNode(value);
        }
        return addLeaf(value);
    }

    private boolean addRootNode(int value) {
        root = new BinaryTreeNode(value);
        size++;

        return true;
    }

    private boolean addLeaf(int value) {
        boolean added = root.add(value);
        size = added ? size + 1 : size;

        return added;
    }

    public int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }
}
