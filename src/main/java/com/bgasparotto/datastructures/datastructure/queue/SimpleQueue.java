package com.bgasparotto.datastructures.datastructure.queue;

public interface SimpleQueue<E> {

    void enqueue(E element);

    E dequeue();

    E peek();

    int size();

    boolean isEmpty();
}
