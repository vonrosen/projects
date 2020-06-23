package org.hunter.threads;

import java.util.ArrayList;
import java.util.List;

public class Buffer<T> {
    private List<T> list = null;
    private int maxSize = 100;

    public Buffer(int maxSize) {
        this.list = new ArrayList<T>();
        this.maxSize = maxSize;
    }

    public synchronized void add(T item) {
        if (list.size() >= maxSize) {
            try {
                wait();
            }
            catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        list.add(item);
        notify();
    }

    public synchronized int size() {
        return list.size();
    }

    public synchronized T getAndRemove() {
        if (list.size() == 0) {
            try {
                wait();
            }
            catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        T item = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        notify();
        return item;
    }
}
