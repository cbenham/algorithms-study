package com.stride;

import static java.lang.String.format;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private int size;

    public void append(T data) {
        if (isEmpty()) {
            head = new Node<>(null, null, data);
            tail = head;
        } else {
            Node<T> newNode = new Node<>(tail, null, data);
            tail.next(newNode);
            tail = newNode;
        }
        size++;
    }

    public void prepend(T data) {
        if (isEmpty()) {
            head = new Node<>(null, null, data);
            tail = head;
        } else {
            Node<T> newNode = new Node<>(null, head, data);
            head.previous(newNode);
            head = newNode;
        }
        size++;
    }

    public int indexOf(T data) {
        Node pointer = head;
        int result = 0;
        boolean found = false;

        while (pointer.next() != null && !found) {
            if (data == null && pointer.data() == null || data != null && data.equals(pointer.data())) {
                found = true;
            } else {
                pointer = pointer.next();
                result++;
            }
        }
        return result;
    }

    public T remove(int index) {
        Node<T> pointer = nodeAt(index);

        if (pointer == head) {
            head = head.next();
            if (head != null) {
                head.previous(null);
            }
        } else if(pointer == tail) {
            tail = tail.previous();
            tail.next(null);
        } else {
            Node<T> previous = pointer.previous();
            Node<T> next = pointer.next();

            if (previous != null) {
                previous.next(next);
            }
            if (next != null) {
                next.previous(previous);
            }
        }

        size--;
        return pointer.data();
    }

    public T get(int index) {
        return nodeAt(index).data();
    }

    public void set(int index, T data) {
        nodeAt(index).data(data);
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T first() {
        return head.data();
    }

    public T last() {
        return tail.data();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        Node<T> pointer = head;
        while (pointer != null) {
            builder.append(pointer.toString());
            if (pointer.next() != null) {
                builder.append(", ");
            }
            pointer = pointer.next();
        }
        return builder.append("]").toString();
    }

    private void validateRange(int index) {
        if (isEmpty() || index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException(format("Index %d, Size %d", index, size));
        }
    }

    private Node<T> nodeAt(int index) {
        validateRange(index);
        Node<T> pointer;
        if (index < size / 2) {
            pointer = head;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next();
            }
        } else {
            pointer = tail;
            for(int i = size - 1; i > index; i--) {
                pointer = pointer.previous();
            }
        }
        return pointer;
    }
}
