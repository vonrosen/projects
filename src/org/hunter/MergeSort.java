package org.hunter;

public class MergeSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void sort(T[] array) {

        if (array == null || array.length == 1) {
            return;
        }

        T[] sorted = sortRange(array, 0, array.length - 1);

        for (int i = 0; i < array.length; ++i) {
            array[i] = sorted[i];
        }
    }

    private static <T extends Comparable<T>> T[] sortRange(T[] array, int start, int end) {
        if (end <= start) {
            return (T[]) new Comparable[] { array[start] };
        }

        int mid = start + ((end - start) / 2);

        // divide
        T[] left = sortRange(array, start, mid);
        T[] right = sortRange(array, mid + 1, end);

        // and conquer
        T[] merged = (T[]) new Comparable[left.length + right.length];

        int currentMergedIndex = 0, leftIndex = 0, rightIndex = 0;
        while (currentMergedIndex < merged.length) {

            if (rightIndex > right.length - 1) {
                merged[currentMergedIndex] = left[leftIndex];
                ++leftIndex;
                ++currentMergedIndex;
                continue;
            }

            if (leftIndex > left.length - 1) {
                merged[currentMergedIndex] = right[rightIndex];
                ++rightIndex;
                ++currentMergedIndex;
                continue;
            }

            if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
                merged[currentMergedIndex] = left[leftIndex];
                ++leftIndex;
            }
            else {
                merged[currentMergedIndex] = right[rightIndex];
                ++rightIndex;
            }

            ++currentMergedIndex;
        }

        return merged;
    }

    public static void main(String[] args) {
        Integer[] intsToSort = { 99, 77, 555, 10, 8, 7, 1, 5000, 2000 };

        System.out.println("Before sort:");
        for (int i = 0; i < intsToSort.length; ++i) {
            System.out.println(intsToSort[i]);
        }

        sort(intsToSort);

        System.out.println("After sort:");
        for (int i = 0; i < intsToSort.length; ++i) {
            System.out.println(intsToSort[i]);
        }

        Integer[] intsToSort2 = { 5, 4, 3, 2 };

        System.out.println("Before sort:");
        for (int i = 0; i < intsToSort2.length; ++i) {
            System.out.println(intsToSort2[i]);
        }

        sort(intsToSort2);

        System.out.println("After sort:");
        for (int i = 0; i < intsToSort2.length; ++i) {
            System.out.println(intsToSort2[i]);
        }

        String[] stringsToSort = { "xx", "ee", "rrtr", "ccc", "b", "bb", "a", "yyyyy", "ttt" };

        System.out.println("Before sort:");
        for (int i = 0; i < stringsToSort.length; ++i) {
            System.out.println(stringsToSort[i]);
        }

        sort(stringsToSort);

        System.out.println("After sort:");
        for (int i = 0; i < stringsToSort.length; ++i) {
            System.out.println(stringsToSort[i]);
        }
    }
}
