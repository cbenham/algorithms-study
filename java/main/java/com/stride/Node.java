package com.stride;

public class Node<T> {
    private Node<T> previous;
    private Node<T> next;

    private T data;

    public Node(Node<T> predecessor, Node<T> successor, T data) {
        this.previous = predecessor;
        this.next = successor;
        this.data = data;
    }

    public Node<T> previous() {
        return this.previous;
    }

    public void previous(Node<T> predecessor) {
        this.previous = predecessor;
    }

    public Node<T> next() {
        return this.next;
    }

    public void next(Node<T> successor) {
        this.next = successor;
    }

    public T data() {
        return this.data;
    }

    public void data(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return data == null ? "null" : data.toString();
    }
}
