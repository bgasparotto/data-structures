package com.bgasparotto.datastructures.datastructure.list;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.bgasparotto.datastructures.model.SampleType;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractSimpleLinkedListTest<T extends SimpleLinkedList<SampleType>> {

    private T list;
    private SampleType john;
    private SampleType mary;
    private SampleType sam;

    protected abstract T createInstance();

    @BeforeEach
    public void setUp() {
        list = createInstance();
        john = new SampleType(1, "John");
        mary = new SampleType(2, "Mary");
        sam = new SampleType(3, "Sam");
    }

    @Test
    public void shouldAddElementAtTheTail() {
        list.add(john);
        list.add(mary);
        list.add(sam);

        assertThat(list.head()).isEqualTo(john);
        assertThat(list.tail()).isEqualTo(sam);
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void shouldAddElementAtHead() {
        list.add(john);
        list.add(mary);

        list.addHead(sam);

        assertThat(list.head()).isEqualTo(sam);
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void shouldAddElementAtTail() {
        list.add(john);

        list.addTail(mary);

        assertThat(list.tail()).isEqualTo(mary);
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void shouldAddElementAtPositionZeroAsHead() {
        list.add(john, 0);

        assertThat(list.head()).isEqualTo(john);
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void shouldAddElementAtPositionGreaterThanZero() {
        list.add(john);
        list.add(mary);
        list.add(sam, 1);

        assertThat(list.get(1)).isEqualTo(sam);
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void shouldAddElementBeforeTheOtherElementSpecified() {
        list.add(john);
        list.add(mary);

        list.addBefore(sam, mary);

        assertThat(list.head()).isEqualTo(john);
        assertThat(list.get(1)).isEqualTo(sam);
        assertThat(list.tail()).isEqualTo(mary);
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void shouldSetElementAtPositionByReplacingTheOldElement() {
        list.add(john, 0);
        list.add(mary, 1);

        list.set(sam, 1);

        assertThat(list.get(1)).isEqualTo(sam);
    }

    @Test
    public void shouldReturnTheFirstAddedElementWhenHeadIsCalled() {
        list.add(john);
        list.add(mary);

        assertThat(list.head()).isEqualTo(john);
    }

    @Test
    public void shouldReturnTheLastAddedElementWhenTailIsCalled() {
        list.add(john);
        list.add(mary);

        assertThat(list.tail()).isEqualTo(mary);
    }

    @Test
    public void shouldDeleteHeadElement() {
        list.add(john);
        list.add(mary);

        list.deleteHead();

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.head()).isEqualTo(mary);
    }

    @Test
    public void shouldDeleteTailElement() {
        list.add(john);
        list.add(mary);

        list.deleteTail();

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.tail()).isEqualTo(john);
    }

    @Test
    public void shouldDeleteAtPosition() {
        list.add(john);
        list.add(mary);
        list.add(sam);

        list.delete(1);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.head()).isEqualTo(john);
        assertThat(list.tail()).isEqualTo(sam);
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
