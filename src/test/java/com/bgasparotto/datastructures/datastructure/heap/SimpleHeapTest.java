package com.bgasparotto.datastructures.datastructure.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SimpleHeapTest {
    private SimpleHeap heap;

    @BeforeEach
    public void setUp() {
        heap = new SimpleHeap();
    }

    @Test
    public void shouldAddElementsWhenChildrenAreLessThanParents() {
        addAll(heap, 22, 19, 18, 15, 3, 14, 4, 12);

        assertHeapContainsSequence(22, 19, 18, 15, 3, 14, 4, 12);
    }

    @Test
    public void shouldAddElementsAndReOrderWhenChildrenWereGreaterThanParents() {
        addAll(heap, 22, 19, 18, 15, 3, 14, 4, 12);

        heap.add(20); // Should become left child of 22, replacing 19 positions.

        assertHeapContainsSequence(22, 20, 18, 19, 3, 14, 4, 12, 15);
    }

    @Test
    public void shouldReturnTheRootValueWhenPeekIsCalled() {
        addAll(heap, 22, 19, 18, 15);

        assertThat(heap.peek()).isEqualTo(22);
    }

    @Test
    public void shouldThrowExceptionWhenTryingToPeekAnEmptyTree() {
        assertThatThrownBy(() -> heap.peek())
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Heap is empty");
    }

    @Test
    public void shouldThrowExceptionWhenTryingToPollWhenTreeIsEmpty() {
        assertThatThrownBy(() -> heap.poll())
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Empty heap has no root");
    }

    @Test
    public void shouldPollAndReturnRootElementReorderingTheHeapAccordingly() {
        addAll(heap, 80, 75, 60, 68, 55, 40, 52, 67);

        int rootValue = heap.poll();

        assertThat(rootValue).isEqualTo(80);
        assertHeapContainsSequence(75, 68, 60, 67, 55, 40, 52);
    }

    @Test
    public void shouldThrowExceptionWhenTryingToRemoveValueNotInTheTree() {
        addAll(heap, 80, 75, 60, 68, 55, 40, 52, 67);

        assertThatThrownBy(() -> heap.delete(99))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Heap does not have the value 99");
        assertHeapContainsSequence(80, 75, 60, 68, 55, 40, 52, 67);
    }

    @Test
    public void shouldRemoveElementAndReorderWhenReplacementValueIsLessThanParents() {
        addAll(heap, 80, 75, 60, 68, 55, 40, 52, 67);

        heap.delete(75);

        assertHeapContainsSequence(80, 68, 60, 67, 55, 40, 52);
    }

    @Test
    public void shouldRemoveElementAndReorderWhenReplacementValueIsGreaterThanParents() {
        addAll(heap, 80, 75, 60, 68, 55, 40, 52, 67);

        heap.delete(40);

        assertHeapContainsSequence(80, 75, 67, 68, 55, 60, 52);
    }

    @Test
    public void indexOfShouldReturnEmptyOptionalWhenValueDoesNotExist() {
        addAll(heap, 80, 75, 60);

        Optional<Integer> optionalIndex = heap.indexOf(99);
        assertThat(optionalIndex).isEmpty();
    }

    @Test
    public void indexOfShouldReturnOptionalOfIntegerWhenValueExists() {
        addAll(heap, 80, 75, 60);

        Optional<Integer> optionalIndex = heap.indexOf(75);
        assertThat(optionalIndex).isPresent();
        assertThat(optionalIndex).contains(1);
    }

    @Test
    public void isEmptyShouldReturnTrueWhenHeapHasNoElements() {
        assertThat(heap.isEmpty()).isTrue();
    }

    @Test
    public void isEmptyShouldReturnFalseWhenHeapHasAtLeastOneElement() {
        heap.add(20);
        assertThat(heap.isEmpty()).isFalse();
    }

    private void addAll(SimpleHeap tree, int... values) {
        for (int value : values) {
            tree.add(value);
        }
    }

    private void assertHeapContainsSequence(int... expected) {
        int[] heapArray = extractBackingArray();
        assertThat(heapArray).containsSequence(expected);
    }

    private int[] extractBackingArray() {
        try {
            Field field = heap.getClass().getDeclaredField("elements");
            field.setAccessible(true);

            return (int[]) field.get(heap);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
