package com.bgasparotto.datastructures.datastructure.stack;

public class SimpleArrayStackTest extends AbstractSimpleStackTest<SimpleArrayStack<String>> {

    @Override
    protected SimpleArrayStack<String> createInstance() {
        return new SimpleArrayStack<>();
    }
}
