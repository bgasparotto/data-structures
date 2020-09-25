package com.bgasparotto.datastructures.datastructure.heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeNodeLocatorTest {

    @Test
    public void shouldFindParent() {
        assertThat(TreeNodeLocator.parentOf(1)).isEqualTo(0);
        assertThat(TreeNodeLocator.parentOf(2)).isEqualTo(0);
        assertThat(TreeNodeLocator.parentOf(3)).isEqualTo(1);
        assertThat(TreeNodeLocator.parentOf(4)).isEqualTo(1);
        assertThat(TreeNodeLocator.parentOf(5)).isEqualTo(2);
        assertThat(TreeNodeLocator.parentOf(6)).isEqualTo(2);
        assertThat(TreeNodeLocator.parentOf(7)).isEqualTo(3);
    }

    @Test
    public void shouldFindLeftChild() {
        assertThat(TreeNodeLocator.leftChildOf(0)).isEqualTo(1);
        assertThat(TreeNodeLocator.leftChildOf(1)).isEqualTo(3);
        assertThat(TreeNodeLocator.leftChildOf(2)).isEqualTo(5);
        assertThat(TreeNodeLocator.leftChildOf(3)).isEqualTo(7);
    }

    @Test
    public void shouldFindRightChild() {
        assertThat(TreeNodeLocator.rightChildOf(0)).isEqualTo(2);
        assertThat(TreeNodeLocator.rightChildOf(1)).isEqualTo(4);
        assertThat(TreeNodeLocator.rightChildOf(2)).isEqualTo(6);
    }
}
