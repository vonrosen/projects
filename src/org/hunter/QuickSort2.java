package org.hunter;

public class QuickSort2 {

    public static void main(String [] args) {
        int [] arr = new int [] { 10, 3, 44, 22, 1 };
        int [] arr2 = new int [] { 1, 2, 3, 4 };
        int [] arr3 = new int [] { 100, 55 };

        sort(arr, 0, arr.length - 1);
        sort(arr2, 0, arr2.length - 1);
        sort(arr3, 0, arr3.length - 1);

        for (int i  = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }

        for (int i  = 0; i < arr2.length; ++i) {
            System.out.println(arr2[i]);
        }

        for (int i  = 0; i < arr3.length; ++i) {
            System.out.println(arr3[i]);
        }
    }

    public static void sort(int [] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int newMidIndex = partition(start, end, (start + end) / 2, arr);
        sort(arr, start, newMidIndex);
        sort(arr, newMidIndex + 1, end);
    }

    private static int partition(int start, int end, int midIndex, int [] arr) {
        int newMidIndex = midIndex;
        for (int i = start; i <= end; ++i) {
            if (i < newMidIndex && arr[i] > arr[newMidIndex]) {
                swap(i, newMidIndex, arr);
                newMidIndex = i;
            }
            else if (i > newMidIndex && arr[i] < arr[newMidIndex]) {
                swap(i, newMidIndex, arr);
                newMidIndex = i;
            }
        }

        return newMidIndex;
    }

    private static void swap(int index1, int index2, int [] arr) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
