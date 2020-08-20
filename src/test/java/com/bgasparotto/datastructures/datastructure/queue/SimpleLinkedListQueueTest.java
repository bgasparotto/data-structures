package com.bgasparotto.datastructures.datastructure.queue;

public class SimpleLinkedListQueueTest extends AbstractSimpleQueueTest {

    @Override
    protected SimpleQueue<String> createInstance() {
        return new SimpleLinkedListQueue<>();
    }
}
