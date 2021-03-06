package com.bgasparotto.datastructures.datastructure.queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public abstract class AbstractSimpleQueueTest {
    protected SimpleQueue<String> queue;
    protected final String jack = "Jack";
    protected final String robin = "Robin";
    protected final String suzy = "Suzy";

    protected abstract SimpleQueue<String> createInstance();

    @BeforeEach
    public void setUp() {
        queue = createInstance();
    }

    @Test
    public void shouldEnqueueAndPeekFirstAddedItem() {
        queue.enqueue(jack);
        queue.enqueue(robin);

        assertThat(queue.size()).isEqualTo(2);
        assertThat(queue.peek()).isEqualTo(jack);
    }

    @Test
    public void shouldDequeueFirstElement() {
        queue.enqueue(jack);
        queue.enqueue(robin);

        assertThat(queue.dequeue()).isEqualTo(jack);
        assertThat(queue.size()).isEqualTo(1);

        assertThat(queue.dequeue()).isEqualTo(robin);
        assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    public void shouldThrowExceptionIfDequeueAnEmptyQueue() {
        assertThatThrownBy(() -> queue.dequeue()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void shouldThrowExceptionIfPeekAnEmptyQueue() {
        assertThatThrownBy(() -> queue.peek()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void sizeShouldReturnZeroWhenQueueIsEmpty() {
        Assertions.assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    public void sizeShouldReturnTheAppropriateValueAsTheQueueGrows() {
        queue.enqueue(jack);
        Assertions.assertThat(queue.size()).isEqualTo(1);

        queue.enqueue(robin);
        Assertions.assertThat(queue.size()).isEqualTo(2);

        queue.enqueue(suzy);
        Assertions.assertThat(queue.size()).isEqualTo(3);
    }

    @Test
    public void sizeShouldReturnTheAppropriateValueAsTheQueueShrinks() {
        queue.enqueue(robin);
        queue.enqueue(suzy);

        Assertions.assertThat(queue.size()).isEqualTo(2);

        queue.dequeue();
        Assertions.assertThat(queue.size()).isEqualTo(1);

        queue.dequeue();
        Assertions.assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    public void isEmptyShouldReturnTrueWhenQueueHasNoElements() {
        Assertions.assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    public void isEmptyShouldReturnFalseWhenQueueHasAtLeastOneElement() {
        queue.enqueue(jack);
        Assertions.assertThat(queue.isEmpty()).isFalse();
    }

    @Test
    public void shouldAccommodateLargeNumberOfElements() {
        enqueueRepeatedly(jack, 3000);

        Assertions.assertThat(queue.size()).isEqualTo(3000);
    }

    protected void enqueueRepeatedly(String element, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            queue.enqueue(element);
        }
    }

    protected void dequeueRepeatedly(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            queue.dequeue();
        }
    }

    protected void enqueueAndDequeueRepeatedly(String element, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            queue.enqueue(element);
            queue.dequeue();
        }
    }
}
