package com.example.project;

public class DLL<T> implements List<T> {
    private DLLNode<T> head;
    private DLLNode<T> current;

    public DLL() {
        head = current = null;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current != null && current.next == null;
    }

    public boolean first() {
        return current != null && current.previous == null;
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

    public void findPrevious() {
        if (current != null) {
            current = current.previous;
        }
    }

    public T retrieve() {
        return current != null ? current.data : null;
    }

    public void update(T val) {
        if (current != null) {
            current.data = val;
        }
    }

    public void insert(T val) {
        DLLNode<T> newNode = new DLLNode<>(val);
        if (empty()) {
            head = current = newNode;
        } else {
            newNode.next = current.next;
            if (current.next != null) {
                current.next.previous = newNode;
            }
            current.next = newNode;
            newNode.previous = current;
            current = newNode;
        }
    }

    public void remove() {
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        } else if (current != null) {
            current.previous.next = current.next;
            if (current.next != null) {
                current.next.previous = current.previous;
            }
        }
        if (current != null) {
            current = current.next != null ? current.next : head;
        }
    }

    public void removeBetween(T e1, T e2) {
        DLLNode<T> start = head;

        // Find node with data equal to e1
        while (start != null && !start.data.equals(e1)) {
            start = start.next;
        }
        if (start == null) return;  // e1 not found

        DLLNode<T> end = start.next;

        // Find node with data equal to e2
        while (end != null && !end.data.equals(e2)) {
            end = end.next;
        }
        if (end == null) return;  // e2 not found

        // Remove nodes between start and end
        start.next = end;
        end.previous = start;
    }
}
