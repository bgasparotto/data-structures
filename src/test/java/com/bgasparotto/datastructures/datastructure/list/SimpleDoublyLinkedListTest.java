package com.bgasparotto.datastructures.datastructure.list;

import com.bgasparotto.datastructures.model.SampleType;

public class SimpleDoublyLinkedListTest extends AbstractSimpleLinkedListTest<SimpleDoublyLinkedList<SampleType>> {

    @Override
    protected SimpleDoublyLinkedList<SampleType> createInstance() {
        return new SimpleDoublyLinkedList<>();
    }
}
