package com.example.project;

public class ListTester {

    public static <T> T mostFrequentElement(List<T> list) {
        T mfe = null;
        int max = 0;
        list.findFirst();
        while (!list.empty()) {
            T element = list.retrieve();
            int count = 0;
            List<T> tempList = new DLL<>();
            tempList.insert(element);
            while (!tempList.empty()) {
                if (tempList.retrieve().equals(element)) {
                    count++;
                }
                tempList.remove();
            }
            if (count > max) {
                max = count;
                mfe = element;
            }
            list.findNext();
        }
        return mfe;
    }

    public static <T> void circularLeftShift(List<T> list, int n) {
        for (int i = 0; i < n; i++) {
            list.findFirst();
            T elem = list.retrieve();
            list.remove();
            while (!list.last()) {
                list.findNext();
            }
            list.insert(elem);
        }
    }

    public static <T> void reverseCopy(DLL<T> l1, DLL<T> l2) {
        if (l1.empty()) return;
        l1.findFirst();
        while (!l1.last()) {
            l1.findNext();
        }
        while (!l1.first()) {
            l2.insert(l1.retrieve());
            l1.findPrevious();
        }
        l2.insert(l1.retrieve());
    }
}
