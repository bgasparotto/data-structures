package com.bgasparotto.datastructures.datastructure.list;

import java.util.NoSuchElementException;

public class SimpleSinglyLinkedList<E> implements SimpleLinkedList<E> {

    private Node<E> head;
    private int size;

    @Override
    public void add(E element) {
        addTail(element);
    }

    @Override
    public void addHead(E element) {
        head = new Node<>(element, head);
        size++;
    }

    @Override
    public void addTail(E element) {
        if (isEmpty()) {
            addHead(element);
            return;
        }
        Node<E> node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node<>(element);
        size++;
    }

    @Override
    public void add(E element, int position) {
        checkIfValidInsertion(position);

        if (position == 0) {
            addHead(element);
            return;
        }

        Node<E> previous = find(position - 1);
        previous.next = new Node<>(element, previous.next);
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

        Node<E> node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node.element;
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
        size--;
    }

    @Override
    public void deleteTail() {
        checkIfNotEmpty();

        Node<E> current = head;
        Node<E> next = head.next;
        while (next.next != null) {
            current = next;
            next = next.next;
        }
        current.next = null;
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

        Node<E> previous = find(position - 1);
        Node<E> current = previous.next;
        previous.next = current.next;
        size--;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private Node<E> find(int position) {
        Node<E> node = head;
        for (int i = 1; i <= position; i++) {
            node = node.next;
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

        private E element;
        private Node<E> next;

        Node(E element) {
            this(element, null);
        }

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
