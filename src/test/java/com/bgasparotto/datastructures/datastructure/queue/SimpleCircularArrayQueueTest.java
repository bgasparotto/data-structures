package com.bgasparotto.datastructures.datastructure.queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SimpleCircularArrayQueueTest extends AbstractSimpleQueueTest {

    @Override
    protected SimpleQueue<String> createInstance() {
        return new SimpleCircularArrayQueue<>();
    }

    @Test
    public void shouldKeepInternalIndexesConsistentUponWrapAndResizeOperations() {
        enqueueAndDequeueRepeatedly(jack, 5);
        enqueueAndDequeueRepeatedly(robin, 10);
        enqueueRepeatedly(jack, 1234);
        dequeueRepeatedly(1234);

        queue.enqueue(suzy);
        assertThat(queue.peek()).isEqualTo(suzy);
        assertThat(queue.size()).isEqualTo(1);

        assertThat(queue.dequeue()).isEqualTo(suzy);
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    public void shouldNotExplodeInternalArrayStorage() {
        queue.enqueue(jack); // Size will always be >= 1 so indexes won't reset but will wrap.
        enqueueAndDequeueRepeatedly(jack, 10000);

        assertThat(queue.dequeue()).isEqualTo(jack);

        queue.enqueue(suzy);
        assertThat(queue.peek()).isEqualTo(suzy);
        assertThat(queue.size()).isEqualTo(1);
    }
}
