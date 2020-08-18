package com.bgasparotto.datastructures.datastructure.queue;

public class SimpleLinearArrayQueueTest extends AbstractSimpleQueueTest {

    @Override
    protected SimpleQueue<String> createInstance() {
        return new SimpleLinearArrayQueue<>();
    }
}
