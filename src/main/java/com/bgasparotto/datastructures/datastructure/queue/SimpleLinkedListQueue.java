package com.bgasparotto.datastructures.datastructure.queue;

import java.util.NoSuchElementException;

public class SimpleLinkedListQueue<E> implements SimpleQueue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public void enqueue(E element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        addTail(element);
    }

    private void addFirst(E element) {
        Node<E> node = new Node<>(element);
        head = node;
        tail = node;
        size++;
    }

    private void addTail(E element) {
        Node<E> node = new Node<>(tail, element);
        tail.next = node;
        tail = node;

        size++;
    }

    @Override
    public E dequeue() {
        checkIfNotEmpty();
        return dequeueHead();
    }

    private void checkIfNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    private E dequeueHead() {
        E element = head.element;
        if (size == 1) {
            clear();
            return element;
        }

        head = head.next;
        head.previous = null;
        size--;
        return element;
    }

    private void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E peek() {
        checkIfNotEmpty();
        return head.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<E> {

        private Node<E> previous;
        private final E element;
        private Node<E> next;

        Node(E element) {
            this(null, element, null);
        }

        Node(Node<E> previous, E element) {
            this(previous, element, null);
        }

        Node(Node<E> previous, E element, Node<E> next) {
            this.previous = previous;
            this.element = element;
            this.next = next;
        }
    }
}
