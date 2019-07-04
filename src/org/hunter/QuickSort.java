package org.hunter;

public class QuickSort<T extends Comparable<T>> {

	public static <T extends Comparable<T>> void sort(T [] array) {
		if (array == null) {
			return;
		}

		sortRange(array, 0, array.length - 1);
	}

	private static <T extends Comparable<T>> void sortRange(T [] array, int start, int end) {
		if (array == null || start >= end) {
			return;
		}

		int mid = start + ((end - start) / 2);
		int pivot = mid;
		for (int i = start; i <= end; ++i) {
			if (array[i].compareTo(array[pivot]) > 0 && i < pivot) {
				swap(array, i, pivot);
				pivot = i;
			}
			else if (array[i].compareTo(array[pivot]) < 0 && i > pivot) {
				swap(array, i, pivot);
				if (i - pivot > 1) {
					swap(array, i, pivot + 1);
					pivot = pivot + 1;
				}
				else {
					pivot = i;
				}
			}
		}

		sortRange(array, start, pivot);
		sortRange(array, pivot + 1, end);
	}

	private static <T extends Comparable<T>> void swap(T [] array, int index1, int index2) {
		T tmp = array[index1];

		array[index1] = array[index2];
		array[index2] = tmp;
	}

	public static void main(String [] args) {
		Integer [] intsToSort = { 99, 77, 555, 10, 8, 7, 1, 5000, 2000 };

		System.out.println("Before sort:");
		for (int i = 0; i < intsToSort.length; ++i) {
			System.out.println(intsToSort[i]);
		}

		sort(intsToSort);

		System.out.println("After sort:");
		for (int i = 0; i < intsToSort.length; ++i) {
			System.out.println(intsToSort[i]);
		}

		String [] stringsToSort = { "xx", "ee", "rrtr", "ccc", "b", "bb", "a", "yyyyy", "ttt" };

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
