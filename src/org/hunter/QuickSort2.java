package org.hunter;

public class QuickSort2 {

    public static void main(String [] args) {
        int [] arr = new int [] { 10, 3, 44, 22, 1 };
        int [] arr2 = new int [] { 1, 2, 3, 4 };
        int [] arr3 = new int [] { 100, 55 };
        int [] arr4 = new int [] {5, 7, 8, 3, 2, 1, 4, 6};

        sort(arr, 0, arr.length - 1);
        sort(arr2, 0, arr2.length - 1);
        sort(arr3, 0, arr3.length - 1);
        sort(arr4, 0, arr4.length - 1);

        for (int i  = 0; i < arr.length; ++i) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }

        System.out.println("");
        for (int i  = 0; i < arr2.length; ++i) {
            System.out.print(arr2[i]);
            System.out.print(" ");
        }

        System.out.println("");
        for (int i  = 0; i < arr3.length; ++i) {
            System.out.print(arr3[i]);
            System.out.print(" ");
        }

        System.out.println("");
        for (int i  = 0; i < arr4.length; ++i) {
            System.out.print(arr4[i]);
            System.out.print(" ");
        }
    }

    public static void sort(int [] arr, int start, int end) {
        if (start < end) {
            int newMidIndex = partition(start, end, arr);
            sort(arr, start, newMidIndex - 1);
            sort(arr, newMidIndex + 1, end);
        }
    }

    private static int partition(int start, int end, int [] arr) {
        int lower = start;
        for (int i = start; i <= end; ++i) {
            if (arr[i] < arr[end]) {
                swap(lower, i, arr);
                ++lower;
            }
        }
        swap(lower > end ? end : lower, end, arr);
        return lower > end ? end : lower;
    }

    private static void swap(int index1, int index2, int [] arr) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
