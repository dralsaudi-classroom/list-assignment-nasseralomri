package com.example.project;

public class ListTester {
    public static <T> void circularLeftShift(List<T> list, int n) {
        int length = 0;
        list.findFirst();
        while (!list.last()) {
            list.findNext();
            length++;
        }
        length++;
        
        n = n % length;
        for (int i = 0; i < n; i++) {
            list.findFirst();
            T firstElement = list.retrieve();
            list.remove();
            list.findFirst();
            while (!list.last()) {
                list.findNext();
            }
            list.insert(firstElement);
        }
    }

    public static <T> void reverseCopy(DLL<T> l1, DLL<T> l2) {
        l1.findFirst();
        while (!l1.last()) {
            l1.findNext();
        }
        while (true) {
            l2.insert(l1.retrieve());
            if (l1.first()) break;
            l1.findPrevious();
        }
    }
}
