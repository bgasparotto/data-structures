package com.bgasparotto.datastructures.datastructure.list;

import com.bgasparotto.datastructures.model.SampleType;

public class SimpleSinglyLinkedListTest extends AbstractSimpleLinkedListTest<SimpleSinglyLinkedList<SampleType>> {

    @Override
    protected SimpleSinglyLinkedList<SampleType> createInstance() {
        return new SimpleSinglyLinkedList<>();
    }
}
