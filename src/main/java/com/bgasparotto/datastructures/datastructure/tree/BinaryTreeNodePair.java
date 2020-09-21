package com.bgasparotto.datastructures.datastructure.tree;

public class BinaryTreeNodePair {
    private final BinaryTreeNode parent;
    private final BinaryTreeNode node;

    public BinaryTreeNodePair(BinaryTreeNode parent, BinaryTreeNode node) {
        this.parent = parent;
        this.node = node;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public BinaryTreeNode getNode() {
        return node;
    }

    @Override
    public String toString() {
        return "BinaryTreeNodePair{" +
                "parent=" + parent +
                ", node=" + node +
                '}';
    }
}
