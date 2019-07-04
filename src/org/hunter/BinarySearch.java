package org.hunter;

public class BinarySearch<T extends Comparable<T>> {

    public static <T extends Comparable<T>> T search(T array[], T searchTarget) {
        if (array == null) {
            return null;
        }

        QuickSort.sort(array);

        return searchRange(array, searchTarget, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> T searchRange(T array[], T searchTarget, int start, int end) {

        if (start >= end) {
            return null;
        }

        int midIndex = start + ((end - start) / 2);
        T midValue = array[midIndex];

        if (midValue.compareTo(searchTarget) > 0) {
            return searchRange(array, searchTarget, start, midIndex);
        }
        else if (midValue.compareTo(searchTarget) < 0) {
            return searchRange(array, searchTarget, midIndex + 1, end);
        }
        else {
            return midValue;
        }
    }

    public static void main(String[] args) {

        Integer[] searchInts = { 5, 66, 888, 2, 2334, 44, 4, 4, 77, 444 };

        System.out.println(search(searchInts, 5));
        System.out.println(search(searchInts, 54));
        System.out.println(search(searchInts, 4));
        System.out.println(search(searchInts, 455555));
        System.out.println(search(searchInts, 0));

        String[] searchStrings = { "aa", "ccc", "mad", "ab", "aaaaa", "cc", "xxxxx", "mad", "aeed", "eed", "ffee" };

        System.out.println(search(searchStrings, "aa"));
        System.out.println(search(searchStrings, "qq"));
        System.out.println(search(searchStrings, "mad"));
        System.out.println(search(searchStrings, "zzzzzz"));
        System.out.println(search(searchStrings, "a"));
    }
}
