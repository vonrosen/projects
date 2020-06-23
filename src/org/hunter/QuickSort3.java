package org.hunter;

public class QuickSort3 {

    public static void main(String[] args) {
        Integer [] arr = new Integer [] { 10, 3, 44, 22, 1 };
        Integer [] arr2 = new Integer [] { 1, 2, 3, 4 };
        Integer [] arr3 = new Integer [] { 100, 55 };
        Integer [] arr4 = new Integer [] {5, 7, 8, 3, 2, 1, 4, 6, 66, 33, 24, 435, 6, 0};
        String [] arr5 = new String [] {"aa", "aab", "bbbb", "ba"};

        sort(arr, 0, arr.length - 1);
        sort(arr2, 0, arr2.length - 1);
        sort(arr3, 0, arr3.length - 1);
        sort(arr4, 0, arr4.length - 1);
        sort(arr5, 0, arr5.length - 1);

        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println("");
        for (int i = 0; i < arr2.length; ++i) {
            System.out.print(arr2[i]);
            System.out.print(" ");
        }
        System.out.println("");
        for (int i = 0; i < arr3.length; ++i) {
            System.out.print(arr3[i]);
            System.out.print(" ");
        }
        System.out.println("");
        for (int i = 0; i < arr4.length; ++i) {
            System.out.print(arr4[i]);
            System.out.print(" ");
        }
        System.out.println("");
        for (int i = 0; i < arr5.length; ++i) {
            System.out.print(arr5[i]);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static <T extends Comparable<? super T>> void sort(T [] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        sort(arr, start, pivot - 1);
        sort(arr, pivot + 1, end);
    }

    private static <T extends Comparable<? super T>> int partition(T [] arr, int start, int end) {
        int currentPivot = end;
        int newPivot = start;
        for (int i = start; i <= end - 1; ++i) {
            if (arr[i].compareTo(arr[currentPivot]) < 0) {
                swap(arr, i, newPivot);
                if (newPivot < currentPivot) {
                    ++newPivot;
                }
            }
        }
        swap(arr, newPivot, currentPivot);
        return newPivot;
    }

    private static <T extends Comparable<? super T>> void swap(T [] arr, int index1, int index2) {
        T tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
