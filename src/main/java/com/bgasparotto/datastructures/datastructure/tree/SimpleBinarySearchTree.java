package com.bgasparotto.datastructures.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

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

    public void remove(int value) {
        if (isEmpty()) {
            return;
        }
        root = removeOrReturn(root, value);
    }

    private BinaryTreeNode removeOrReturn(BinaryTreeNode node, int value) {
        if (node.getValue() == value) {
            return removeAndFindReplacement(node);
        }

        BinaryTreeNode leftChild = node.getLeftChild();
        if (value < node.getValue() && leftChild != null) {
            node.setLeftChild(removeOrReturn(leftChild, value));
        }

        BinaryTreeNode rightChild = node.getRightChild();
        if (value > node.getValue() && rightChild != null) {
            node.setRightChild(removeOrReturn(rightChild, value));
        }

        return node;
    }

    public BinaryTreeNode removeAndFindReplacement(BinaryTreeNode node) {
        size--;
        if (node.isLeaf()) {
            return null;
        }
        if (node.hasOneChild()) {
            return availableChild(node);
        }
        return maxFromLeftSubtree(node);
    }

    private BinaryTreeNode availableChild(BinaryTreeNode node) {
        return Optional
                .ofNullable(node.getLeftChild())
                .orElse(node.getRightChild());
    }

    private BinaryTreeNode maxFromLeftSubtree(BinaryTreeNode nodeBeingRemoved) {
        BinaryTreeNodePair replacementPair = findReplacementFor(nodeBeingRemoved);

        BinaryTreeNode parent = replacementPair.getParent();
        BinaryTreeNode replacementNode = replacementPair.getNode();

        linkLeftChild(nodeBeingRemoved, replacementNode, parent);
        linkRightChild(nodeBeingRemoved, replacementNode);

        return replacementNode;
    }

    private BinaryTreeNodePair findReplacementFor(BinaryTreeNode nodeBeingRemoved) {
        BinaryTreeNode leftChild = nodeBeingRemoved.getLeftChild();
        return leftChild.max(nodeBeingRemoved);
    }

    private void linkLeftChild(BinaryTreeNode nodeBeingRemoved, BinaryTreeNode replacementNode, BinaryTreeNode parent) {
        if (parent == nodeBeingRemoved) {
            return;
        }

        BinaryTreeNode leftChild = nodeBeingRemoved.getLeftChild();
        BinaryTreeNode leftOrphanFromReplacement = replacementNode.getLeftChild();

        replacementNode.setLeftChild(leftChild);
        parent.setRightChild(leftOrphanFromReplacement);
    }

    private void linkRightChild(BinaryTreeNode nodeBeingRemoved, BinaryTreeNode replacementNode) {
        BinaryTreeNode rightChild = nodeBeingRemoved.getRightChild();
        replacementNode.setRightChild(rightChild);
    }

    public Optional<Integer> min() {
        return Optional
                .ofNullable(root)
                .map(BinaryTreeNode::min)
                .map(BinaryTreeNode::getValue);
    }

    public Optional<Integer> max() {
        return Optional
                .ofNullable(root)
                .map(BinaryTreeNode::max)
                .map(BinaryTreeNode::getValue);
    }

    public int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    public String traverseInOrder() {
        return traverse(BinaryTreeNode::traverseInOrder);
    }

    private String traverse(BiConsumer<BinaryTreeNode, List<String>> traversalFunction) {
        if (isEmpty()) {
            return "[]";
        }

        List<String> collector = new ArrayList<>(size);
        traversalFunction.accept(root, collector);

        return asString(collector);
    }

    private String asString(List<String> collector) {
        return "[" + String.join(", ", collector) + "]";
    }

    public String traversePreOrder() {
        return traverse(BinaryTreeNode::traversePreOrder);
    }
}
