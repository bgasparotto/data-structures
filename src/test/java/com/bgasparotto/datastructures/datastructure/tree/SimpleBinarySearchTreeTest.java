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
    public void shouldReturnEmptyTraversalWhenTreeIsEmpty() {
        assertThat(tree.traverseInOrder()).isEqualTo("[]");
    }

    private void addAll(SimpleBinarySearchTree tree, int... values) {
        for (int value : values) {
            tree.add(value);
        }
    }
}
