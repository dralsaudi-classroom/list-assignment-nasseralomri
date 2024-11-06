package com.example.project;

public class DLL<T> {
    private DLLNode<T> head;
    private DLLNode<T> current;
    private int size;

    public DLL() {
        head = current = null;
        size = 0;
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

    public int size() {
        return size;
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
        DLLNode<T> tmp = new DLLNode<>(val);
        if (empty()) {
            current = head = tmp;
        } else {
            tmp.next = current.next;
            tmp.previous = current;
            if (current.next != null) {
                current.next.previous = tmp;
            }
            current.next = tmp;
            current = tmp;
        }
        size++;
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
            size--;
        }
    }

    public void removeBetween(T e1, T e2) {
        DLLNode<T> start = head;
        while (start != null && !start.data.equals(e1)) {
            start = start.next;
        }
        if (start == null) {
            return;
        }

        DLLNode<T> end = start.next;
        while (end != null && !end.data.equals(e2)) {
            end = end.next;
        }
        if (end == null) {
            return;
        }

        DLLNode<T> temp = start.next;
        while (temp != end) {
            DLLNode<T> nextNode = temp.next;
            temp.previous.next = temp.next;
            if (temp.next != null) {
                temp.next.previous = temp.previous;
            }
            temp = nextNode;
            size--;
        }
        current = head;
    }
}
