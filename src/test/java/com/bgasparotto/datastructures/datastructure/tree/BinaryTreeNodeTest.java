package com.bgasparotto.datastructures.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeNodeTest {
    private BinaryTreeNode node;

    @BeforeEach
    public void setUp() {
        node = new BinaryTreeNode(0);
    }

    @Test
    public void shouldNotAddDuplicateValue() {
        assertThat(node.add(0)).isFalse();
    }

    @Test
    public void shouldAddSmallerValue() {
        assertThat(node.add(-1)).isTrue();
    }

    @Test
    public void shouldAddLargerValue() {
        assertThat(node.add(1)).isTrue();
    }

    @Test
    public void shouldNotAddDuplicateValueInDepth() {
        assertThat(node.add(-1)).isTrue();
        assertThat(node.add(-1)).isFalse();
    }

    @Test
    public void shouldAddSmallerValuesInDepth() {
        assertThat(node.add(-1)).isTrue();
        assertThat(node.add(-2)).isTrue();
    }

    @Test
    public void shouldAddLargerValuesInDepth() {
        assertThat(node.add(1)).isTrue();
        assertThat(node.add(2)).isTrue();
    }

    @Test
    public void shouldAddMixedValuesInDepth() {
        assertThat(node.add(-10)).isTrue();
        assertThat(node.add(-5)).isTrue();
        assertThat(node.add(10)).isTrue();
        assertThat(node.add(15)).isTrue();
        assertThat(node.add(5)).isTrue();
    }
}
