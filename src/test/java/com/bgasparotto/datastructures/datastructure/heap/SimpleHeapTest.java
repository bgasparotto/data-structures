package com.bgasparotto.datastructures.datastructure.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleHeapTest {
    private SimpleHeap heap;

    @BeforeEach
    public void setUp() {
        heap = new SimpleHeap();
    }

    @Test
    public void shouldAddElementsWhenChildrenAreLessThanParents() {
        addAll(heap, 22, 19, 18, 15, 3, 14, 4, 12);

        int[] heapArray = extractBackingArray();
        assertThat(heapArray).containsSequence(22, 19, 18, 15, 3, 14, 4, 12);
    }

    @Test
    public void shouldAddElementsAndReOrderWhenChildrenWereGreaterThanParents() {
        addAll(heap, 22, 19, 18, 15, 3, 14, 4, 12);

        heap.add(20); // Should become left child of 22, replacing 19 positions.

        int[] heapArray = extractBackingArray();
        assertThat(heapArray).containsSequence(22, 20, 18, 19, 3, 14, 4, 12, 15);
    }

    private void addAll(SimpleHeap tree, int... values) {
        for (int value : values) {
            tree.add(value);
        }
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
