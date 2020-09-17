package com.bgasparotto.datastructures.datastructure.tree;

import java.util.List;
import java.util.Optional;

public class BinaryTreeNode {
    private final int value;

    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public boolean add(int value) {
        if (value < this.value) {
            return addLeft(value);
        }
        if (value > this.value) {
            return addRight(value);
        }

        return false;
    }

    private boolean addLeft(int value) {
        if (leftChild == null) {
            leftChild = new BinaryTreeNode(value);
            return true;
        }
        return leftChild.add(value);
    }

    private boolean addRight(int value) {
        if (rightChild == null) {
            rightChild = new BinaryTreeNode(value);
            return true;
        }
        return rightChild.add(value);
    }

    public int min() {
        if (leftChild != null) {
            return leftChild.min();
        }
        return value;
    }

    public int max() {
        if (rightChild != null) {
            return rightChild.max();
        }
        return value;
    }

    public void traverseInOrder(List<String> collector) {
        if (leftChild != null) {
            leftChild.traverseInOrder(collector);
        }

        collector.add(String.valueOf(value));

        if (rightChild != null) {
            rightChild.traverseInOrder(collector);
        }
    }

    public Optional<BinaryTreeNode> get(int value) {
        if (value == this.value) {
            return Optional.of(this);
        }

        if (value < this.value && leftChild != null) {
            return leftChild.get(value);
        }

        if (value > this.value && rightChild != null) {
            return rightChild.get(value);
        }

        return Optional.empty();
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasOneChild() {
        return !isLeaf() && !hasTwoChildren();
    }

    public boolean hasTwoChildren() {
        return leftChild != null && rightChild != null;
    }
}
