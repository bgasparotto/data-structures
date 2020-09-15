package com.bgasparotto.datastructures.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<BinaryTreeNode> get(int value) {
        return Optional
                .ofNullable(root)
                .flatMap(rootNode -> rootNode.get(value));
    }

    public Optional<Integer> min() {
        return Optional
                .ofNullable(root)
                .map(BinaryTreeNode::min);
    }

    public Optional<Integer> max() {
        return Optional
                .ofNullable(root)
                .map(BinaryTreeNode::max);
    }

    public int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    public String traverseInOrder() {
        if (isEmpty()) {
            return "[]";
        }
        List<String> collector = new ArrayList<>(size);
        root.traverseInOrder(collector);
        return "[" + String.join(", ", collector) + "]";
    }
}
