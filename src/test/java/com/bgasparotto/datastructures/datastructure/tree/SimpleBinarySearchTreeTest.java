package com.bgasparotto.datastructures.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleBinarySearchTreeTest {
    private SimpleBinarySearchTree tree;

    @BeforeEach
    public void setUp() {
        tree = new SimpleBinarySearchTree();
    }

    @Test
    public void shouldAddDistinctElements() {
        assertThat(tree.add(7)).isTrue();
        assertThat(tree.add(9)).isTrue();
        assertThat(tree.size()).isEqualTo(2);
    }

    @Test
    public void shouldNotAddDuplicateElements() {
        assertThat(tree.add(7)).isTrue();
        assertThat(tree.add(7)).isFalse(); // duplicate
        assertThat(tree.size()).isEqualTo(1);
    }

    @Test
    public void shouldGetTreeNodeOfValue() {
        addAll(tree, 12, 9, 3, 21, 15);

        Optional<BinaryTreeNode> optionalNode = tree.get(21);
        assertThat(optionalNode).isPresent();

        BinaryTreeNode node = optionalNode.get();
        assertThat(node.getValue()).isEqualTo(21);
    }

    @Test
    public void shouldReturnEmptyOptionalWhenValueIsNotInTheTree() {
        addAll(tree, 12, 9, 3, 21, 15);

        assertThat(tree.get(99)).isEmpty();
    }

    @Test
    public void shouldReturnEmptyOptionalWhenTreeIsEmpty() {
        assertThat(tree.get(1)).isEmpty();
        assertThat(tree.isEmpty()).isTrue();
    }

    @Test
    public void shouldGetTheMinimumValue() {
        addAll(tree, 12, 9, 3, 21, 15);

        assertThat(tree.min()).contains(3);
    }

    @Test
    public void shouldRemoveLeafNodeAndReturnTrue() {
        addAll(tree, 12, 9, 3, 21, 15);

        tree.remove(3);

        assertThat(tree.size()).isEqualTo(4);
        assertThat(tree.traverseInOrder()).isEqualTo("[9, 12, 15, 21]");
    }

    @Test
    public void shouldRemoveNodeThatHasOneChild() {
        addAll(tree, 12, 9, 3, 21, 15);

        tree.remove(9);

        assertThat(tree.size()).isEqualTo(4);
        assertThat(tree.traverseInOrder()).isEqualTo("[3, 12, 15, 21]");
    }

    @Test
    public void shouldRemoveRootNodeWhenItHasOnlyOneChild() {
        addAll(tree, 3, 9, 15, 21, 55);

        tree.remove(3);

        assertThat(tree.size()).isEqualTo(4);
        assertThat(tree.traverseInOrder()).isEqualTo("[9, 15, 21, 55]");
    }

    @Test
    public void shouldRemoveNodeThatHasTwoChildren() {
        addAll(tree, 12, 9, 3, 21, 15, 55, 13);

        tree.remove(21);

        assertThat(tree.size()).isEqualTo(6);
        assertThat(tree.traverseInOrder()).isEqualTo("[3, 9, 12, 13, 15, 55]");
    }

    @Test
    public void shouldRemoveNodeThatHasTwoChildrenFromBigTree() {
        addAll(tree, 12, 8, 9, 3, 21, 15, 55, 13, 2, 5, 4, 1, 42, 33, 43, 19, 17, 11, 10);

        tree.remove(8);

        assertThat(tree.size()).isEqualTo(18);
        assertThat(tree.traverseInOrder()).isEqualTo("[1, 2, 3, 4, 5, 9, 10, 11, 12, 13, 15, 17, 19, 21, 33, 42, 43, 55]");
    }

    @Test
    public void shouldRemoveRootNodeThatHasTwoChildren() {
        addAll(tree, 12, 9, 3, 21, 15, 55, 13);

        tree.remove(12);

        assertThat(tree.size()).isEqualTo(6);
        assertThat(tree.traverseInOrder()).isEqualTo("[3, 9, 13, 15, 21, 55]");
    }

    @Test
    public void shouldRemoveRootNodeThatHasTwoChildrenFromBigTree() {
        addAll(tree, 12, 9, 3, 21, 15, 55, 13, 2, 4, 1, 42, 33, 43, 19, 17, 10, 11);

        tree.remove(12);

        assertThat(tree.size()).isEqualTo(16);
        assertThat(tree.traverseInOrder()).isEqualTo("[1, 2, 3, 4, 9, 10, 11, 13, 15, 17, 19, 21, 33, 42, 43, 55]");
    }


    @Test
    public void shouldNotChangeTheTreeWhenNodeDoesNotExistForRemoval() {
        addAll(tree, 12, 9, 3, 21, 15);

        tree.remove(99);

        assertThat(tree.size()).isEqualTo(5);
        assertThat(tree.traverseInOrder()).isEqualTo("[3, 9, 12, 15, 21]");
    }

    @Test
    public void shouldReturnEmptyMinValueWhenTreeIsEmpty() {
        assertThat(tree.min()).isEmpty();
    }

    @Test
    public void shouldGetTheMaximumValue() {
        addAll(tree, 12, 9, 3, 21, 15);

        assertThat(tree.max()).contains(21);
    }

    @Test
    public void shouldReturnZeroMaxValueWhenTreeIsEmpty() {
        assertThat(tree.max()).isEmpty();
    }

    @Test
    public void shouldTraverseInOrder() {
        addAll(tree, 12, 9, 33, 21, 15);

        assertThat(tree.traverseInOrder()).isEqualTo("[9, 12, 15, 21, 33]");
    }

    @Test
    public void shouldTraversePreOrder() {
        addAll(tree, 12, 9, 33, 21, 15);

        assertThat(tree.traversePreOrder()).isEqualTo("[12, 9, 33, 21, 15]");
    }

    @Test
    public void shouldReturnEmptyTraversalWhenTreeIsEmpty() {
        assertThat(tree.traverseInOrder()).isEqualTo("[]");
        assertThat(tree.traversePreOrder()).isEqualTo("[]");
    }

    private void addAll(SimpleBinarySearchTree tree, int... values) {
        for (int value : values) {
            tree.add(value);
        }
    }
}
