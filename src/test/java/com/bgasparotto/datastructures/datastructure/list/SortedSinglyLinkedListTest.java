package com.bgasparotto.datastructures.datastructure.list;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.bgasparotto.datastructures.model.SampleType;
import java.util.Comparator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortedSinglyLinkedListTest {

    private SortedSinglyLinkedList<SampleType> list;
    private SampleType john;
    private SampleType mary;
    private SampleType sam;

    @BeforeEach
    public void setUp() {
        list = new SortedSinglyLinkedList<>(Comparator.comparing(SampleType::getId));
        john = new SampleType(1, "John");
        mary = new SampleType(2, "Mary");
        sam = new SampleType(3, "Sam");
    }

    @Test
    public void shouldAddElementsSortedWhenAddedInMixedOrder() {
        list.add(sam);
        list.add(john);
        list.add(mary);

        assertHasThreeSortedElements();
    }

    private void assertHasThreeSortedElements() {
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(john);
        assertThat(list.get(1)).isEqualTo(mary);
        assertThat(list.get(2)).isEqualTo(sam);
    }

    @Test
    public void shouldAddElementsSortedWhenAddedInInvertedOrder() {
        list.add(sam);
        list.add(mary);
        list.add(john);

        assertHasThreeSortedElements();
    }

    @Test
    public void shouldAddElementsSortedWhenAlreadySortedOrder() {
        list.add(john);
        list.add(mary);
        list.add(sam);

        assertHasThreeSortedElements();
    }

    @Test
    public void shouldReturnSortedElementWhenHeadIsCalled() {
        list.add(mary);
        list.add(john); // sorted first

        assertThat(list.head()).isEqualTo(john);
    }

    @Test
    public void shouldReturnTheLastAddedElementWhenTailIsCalled() {
        list.add(mary); // sorted last
        list.add(john);

        assertThat(list.tail()).isEqualTo(mary);
    }

    @Test
    public void shouldReturnSameElementForHeadAndTailWhenListHasSizeOne() {
        list.add(john);

        assertThat(list.head())
            .isEqualTo(list.tail())
            .isEqualTo(john);
    }

    @Test
    public void shouldDeleteHeadElement() {
        list.add(mary);
        list.add(john); // sorted first

        list.deleteHead();

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.head()).isEqualTo(mary);
    }

    @Test
    public void shouldDeleteOnlyElementWhenDeleteHeadIsCalled() {
        list.add(john);

        list.deleteHead();

        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    public void shouldDeleteTailElement() {
        list.add(mary); // sorted last
        list.add(john);

        list.deleteTail();

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.tail()).isEqualTo(john);
    }

    @Test
    public void shouldDeleteOnlyElementWhenDeleteTailIsCalled() {
        list.add(john);

        list.deleteTail();

        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    public void shouldDeleteAtPositionFromMiddle() {
        list.add(john);
        list.add(mary);
        list.add(sam);

        list.delete(1);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.head()).isEqualTo(john);
        assertThat(list.tail()).isEqualTo(sam);
    }

    @Test
    public void shouldDeleteAtPositionFromStart() {
        list.add(john);
        list.add(mary);
        list.add(sam);

        list.delete(0);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.head()).isEqualTo(mary);
        assertThat(list.tail()).isEqualTo(sam);
    }

    @Test
    public void shouldDeleteAtPositionFromEnd() {
        list.add(john);
        list.add(mary);
        list.add(sam);

        list.delete(2);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.head()).isEqualTo(john);
        assertThat(list.tail()).isEqualTo(mary);
    }

    @Test
    public void shouldDeleteTheOnlyElement() {
        list.add(john);

        list.delete(0);

        assertThat(list.isEmpty()).isEqualTo(true);
    }

    @Test
    public void shouldClearTheList() {
        list.add(john);
        list.add(mary);
        list.add(sam);

        list.clear();

        assertThat(list.size()).isEqualTo(0);
        assertThatThrownBy(() -> list.head()).isInstanceOf(NoSuchElementException.class);
        assertThatThrownBy(() -> list.tail()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void sizeShouldUpdateUponAdditionAndDeletionOfElements() {
        assertThat(list.size()).isEqualTo(0);

        list.add(john);
        assertThat(list.size()).isEqualTo(1);

        list.add(mary);
        assertThat(list.size()).isEqualTo(2);

        list.deleteHead();
        assertThat(list.size()).isEqualTo(1);

        list.deleteHead();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void isEmptyShouldReturnTrueWhenListHasNoNodes() {
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    public void isEmptyShouldReturnFalseWhenListHasAtLeastOneNode() {
        list.add(john);
        assertThat(list.isEmpty()).isFalse();
    }
}
