package org.hunter;

public class LinkedList<T> {

    private int size = 0;
    private LinkedListNode<T> head = null;

    private static class LinkedListNode<T> {
        T object = null;
        LinkedListNode<T> next = null;
        LinkedListNode<T> previous = null;

        LinkedListNode(T object) {
            this.object = object;
        }
    }

    public void add(T object) {
        ++size;

        if (head == null) {
            head = new LinkedListNode<T>(object);
            return;
        }

        LinkedListNode<T> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = new LinkedListNode<T>(object);
        tmp.next.previous = tmp;
    }

    public T get(int index) {
        LinkedListNode<T> tmp = head;

        for (int i = 0; i < index && tmp != null; ++i) {
            tmp = tmp.next;
        }

        if (tmp != null) {
            return tmp.object;
        }
        else {
            return null;
        }
    }

    public void delete(T object) {
        if (head != null && head.object == object) {
            --size;
            head = head.next;
            return;
        }

        LinkedListNode<T> tmp = head;

        while (tmp != null) {
            if (tmp.object == object) {
                tmp.previous.next = tmp.next;

                if (tmp.next != null)
                    tmp.next.previous = tmp.previous;

                --size;
                return;
            }

            tmp = tmp.next;
        }
    }

    public void delete(int index) {
        if (head != null && index == 0) {
            head = head.next;
            --size;
            return;
        }

        LinkedListNode<T> tmp = head;

        for (int i = 0; i < index && tmp != null; ++i) {
            tmp = tmp.next;
        }

        if (tmp != null) {
            tmp.previous.next = tmp.next;

            if (tmp.next != null)
                tmp.next.previous = tmp.previous;

            --size;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList<String> lls = new LinkedList<String>();

        lls.add("1");
        lls.add("2");

        System.out.println("Size should be 2 and is: " + lls.size());
        lls.delete("blah");
        System.out.println("Size after delete non-exsting item should be 2 and is: " + lls.size());
        System.out.println("First item should be '1' and is: " + lls.get(0));
        lls.delete(lls.get(0));
        System.out.println("Size after delete exsting item should be 1 and is: " + lls.size());
        System.out.println("First item should be '2' and is: " + lls.get(0));
        System.out.println("Second item should be null and is: " + lls.get(1));

        lls.delete(0);
        System.out.println("Size after delete exsting item should be 0 and is: " + lls.size());
        System.out.println("First item should be null and is: " + lls.get(0));

        LinkedList<Integer> lli = new LinkedList<Integer>();

        lli.add(1);
        lli.add(2);
        lli.add(3);

        System.out.println("Size should be 3 and is: " + lli.size());

        lli.delete(1);

        System.out.println("Size should be 2 and is: " + lli.size());
        System.out.println("First item should be 1 and is: " + lli.get(0));
        System.out.println("Second item should be '3' and is: " + lli.get(1));

        lli.delete(lli.get(1));

        System.out.println("Size should be 1 and is: " + lli.size());
        System.out.println("Last item should be 1 and is: " + lli.get(lli.size() - 1));
    }
}
