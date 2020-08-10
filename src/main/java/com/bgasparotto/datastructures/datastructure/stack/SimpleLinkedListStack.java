package com.bgasparotto.datastructures.datastructure.stack;

import java.util.EmptyStackException;

public class SimpleLinkedListStack<E> implements SimpleStack<E> {

    private Node<E> head;
    private int size;

    @Override
    public void push(E element) {
        addHead(element);
    }

    private void addHead(E element) {
        head = new Node<>(element, head);
        size++;
    }

    @Override
    public E pop() {
        throwExceptionIfEmpty();
        return popHead();
    }

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    private E popHead() {
        E headElement = peekHead();
        removeHead();
        return headElement;
    }

    private void removeHead() {
        head = head.next;
        size--;
    }

    @Override
    public E peek() {
        throwExceptionIfEmpty();
        return peekHead();
    }

    private E peekHead() {
        return head.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<E> {
        private final E element;
        private final Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
