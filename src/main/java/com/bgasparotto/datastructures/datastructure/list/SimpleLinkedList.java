package com.bgasparotto.datastructures.datastructure.list;

public interface SimpleLinkedList<E> {

    void add(E element);

    void addHead(E element);

    void addTail(E element);

    void add(E element, int position);

    void set(E element, int position);

    E head();

    E tail();

    E get(int position);

    void deleteHead();

    void deleteTail();

    void delete(int position);

    int size();

    boolean isEmpty();
}
