package com.bgasparotto.datastructures.datastructure.list;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class SortedSinglyLinkedList<E> {

    private final Comparator<E> comparator;
    private Node<E> head;
    private int size;

    public SortedSinglyLinkedList(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void add(E element) {
        if (isEmpty() || elementLessThanHead(element)) {
            head = new Node<>(element, head);
            size++;
            return;
        }

        Node<E> current = head;
        Node<E> next = head.next;
        while (next != null && comparator.compare(element, next.element) > 0) {
            current = next;
            next = current.next;
        }

        current.next = new Node<>(element, next);
        size++;
    }

    private boolean elementLessThanHead(E element) {
        return comparator.compare(element, head.element) < 0;
    }

    public E head() {
        checkIfNotEmpty();

        return head.element;
    }

    private void checkIfNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
    }

    public E tail() {
        checkIfNotEmpty();

        Node<E> node = head;
        while (node.next != null) {
            node = node.next;
        }

        return node.element;
    }

    public E get(int position) {
        checkIfAccessible(position);

        Node<E> node = find(position);
        return node.element;
    }

    private void checkIfAccessible(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException(errorMessageFor(position));
        }
    }

    private String errorMessageFor(int position) {
        return "Invalid position: " + position;
    }

    private Node<E> find(int position) {
        Node<E> node = head;
        for (int i = 1; i <= position; i++) {
            node = node.next;
        }
        return node;
    }

    public void deleteHead() {
        checkIfNotEmpty();

        head = head.next;
        size--;
    }

    public void deleteTail() {
        checkIfNotEmpty();

        if (size == 1) {
            deleteHead();
            return;
        }

        Node<E> current = head;
        Node<E> next = current.next;
        while (next != null && next.next != null) {
            current = current.next;
            next = next.next;
        }

        current.next = null;
        size--;
    }

    public void delete(int position) {
        checkIfAccessible(position);

        if (size == 1 || position == 0) {
            deleteHead();
            return;
        }

        Node<E> previous = find(position - 1);
        Node<E> current = previous.next;

        previous.next = current.next;
        size--;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<E> {

        private final E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
