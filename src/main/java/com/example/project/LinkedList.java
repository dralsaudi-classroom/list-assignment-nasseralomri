package com.example.project;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> current;

    public LinkedList() {
        head = current = null;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current != null && current.next == null;
    }

    public boolean full() {
        return false;
    }

    public void findFirst() {
        current = head;
    }

    public void findNext() {
        if (current != null) {
            current = current.next;
        }
    }

    public T retrieve() {
        return current != null ? current.data : null;
    }

    public void update(T e) {
        if (current != null) {
            current.data = e;
        }
    }

    public void insert(T e) {
        Node<T> newNode = new Node<>(e);
        if (empty()) {
            head = current = newNode;
        } else {
            newNode.next = current.next;
            current.next = newNode;
            current = newNode;
        }
    }

    public void remove() {
        if (current == head) {
            head = head.next;
        } else {
            Node<T> tmp = head;
            while (tmp.next != current) {
                tmp = tmp.next;
            }
            tmp.next = current.next;
        }
        if (current.next == null) {
            current = head;
        } else {
            current = current.next;
        }
    }

    public T mostFrequentElement() {
        if (head == null) return null;

        T mfe = null;
        int maxCount = 0;
        Node<T> outer = head;

        while (outer != null) {
            int count = 0;
            Node<T> inner = head;
            while (inner != null) {
                if (inner.data.equals(outer.data)) {
                    count++;
                }
                inner = inner.next;
            }

            if (count > maxCount) {
                maxCount = count;
                mfe = outer.data;
            }

            outer = outer.next;
        }

        return mfe;
    }
}
