package com.bgasparotto.datastructures.datastructure.list;

import java.util.NoSuchElementException;

public class SimpleDoublyLinkedList<E> implements SimpleLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public void add(E element) {
        addTail(element);
    }

    @Override
    public void addHead(E element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }

        Node<E> node = new Node<>(element, head);
        head.previous = node;
        head = node;
        if (tail.previous == null) {
            tail.previous = node;
        }

        size++;
    }

    @Override
    public void addTail(E element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }

        Node<E> node = new Node<>(tail, element);
        tail.next = node;
        tail = node;
        if (head.next == null) {
            head.next = node;
        }

        size++;
    }

    @Override
    public void add(E element, int position) {
        checkIfValidInsertion(position);

        if (isEmpty()) {
            addFirst(element);
            return;
        }
        if (position == 0) {
            addHead(element);
            return;
        }
        if (position == size) {
            addTail(element);
            return;
        }

        Node<E> current = find(position);
        Node<E> previous = current.previous;
        Node<E> newNode = new Node<>(previous, element, current);

        current.previous = newNode;
        previous.next = newNode;

        size++;
    }

    @Override
    public void set(E element, int position) {
        checkIfAccessible(position);

        Node<E> node = find(position);
        node.element = element;
    }

    @Override
    public E head() {
        checkIfNotEmpty();
        return head.element;
    }

    @Override
    public E tail() {
        checkIfNotEmpty();
        return tail.element;
    }

    @Override
    public E get(int position) {
        checkIfAccessible(position);

        Node<E> node = find(position);
        return node.element;
    }

    @Override
    public void deleteHead() {
        checkIfNotEmpty();

        head = head.next;
        if (head != null) {
            head.previous = null;
        }
        size--;
    }

    @Override
    public void deleteTail() {
        checkIfNotEmpty();

        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        }
        size--;
    }

    @Override
    public void delete(int position) {
        checkIfAccessible(position);
        if (position == 0) {
            deleteHead();
            return;
        }
        if (position == size - 1) {
            deleteTail();
            return;
        }

        Node<E> current = find(position);
        Node<E> previous = current.previous;
        Node<E> next = current.next;

        previous.next = next;
        next.previous = previous;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private void addFirst(E element) {
        Node<E> node = new Node<>(element);
        head = node;
        tail = node;
        size++;
    }

    private Node<E> find(int position) {
        if (position < size / 2) {
            return findFromHead(position);
        }
        return findFromTail(position);
    }

    private Node<E> findFromHead(int position) {
        Node<E> node = head;
        for (int i = 1; i <= position; i++) {
            node = node.next;
        }
        return node;
    }

    private Node<E> findFromTail(int position) {
        Node<E> node = tail;
        for (int i = size - 1; i > position; i--) {
            node = node.previous;
        }
        return node;
    }

    private void checkIfNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
    }

    private void checkIfValidInsertion(int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException(errorMessageFor(position));
        }
    }

    private void checkIfAccessible(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException(errorMessageFor(position));
        }
    }

    private String errorMessageFor(int position) {
        return "Invalid position: " + position;
    }

    private static class Node<E> {

        private Node<E> previous;
        private E element;
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

        Node(E element, Node<E> next) {
            this(null, element, next);
        }
    }
}
