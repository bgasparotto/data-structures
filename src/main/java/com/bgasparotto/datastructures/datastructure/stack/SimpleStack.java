package com.bgasparotto.datastructures.datastructure.stack;

public interface SimpleStack<E> {

    void push(E element);

    E pop();

    E peek();

    int size();

    boolean isEmpty();
}
