package com.bgasparotto.datastructures.datastructure.stack;

public class SimpleLinkedListStackTest extends AbstractSimpleStackTest<SimpleLinkedListStack<String>> {

    @Override
    protected SimpleLinkedListStack<String> createInstance() {
        return new SimpleLinkedListStack<>();
    }
}
