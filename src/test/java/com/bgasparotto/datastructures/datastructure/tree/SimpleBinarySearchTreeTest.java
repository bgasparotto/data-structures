package com.bgasparotto.datastructures.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
