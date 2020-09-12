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
}
