package org.hunter;

public class MergeSort<T extends Comparable<T>> {
	
	public static <T extends Comparable<T>> T [] sort(T [] array) {
		
		if (array == null || array.length == 1) {
			return array;
		}
		
		return sortRange(array, 0, array.length - 1);
	}
	
	private static <T extends Comparable<T>> T [] sortRange(T [] array, int start, int end) {
		if (end <= start) {
			return (T[]) new Comparable[]{ array[start] };
		}
		
		int mid = start + ((end - start) / 2);
		
		T [] left = sortRange(array, start, mid);

		if (left.length == array.length) {
			return left;
		}
		
		if (left.length > 1) {
			end = mid + 1 + left.length - 1;
			if (end > array.length - 1) {
				end = array.length - 1; 
			}
		}

		T [] right = sortRange(array, mid + 1, end);
		
		T [] merged = (T [])new Comparable[left.length * 2 > array.length ? 
					array.length : left.length * 2];
		
		int currentMergedIndex = 0;
		int rightIndex = 0;
		
		for (int i = 0; i < left.length; ++i) {
			if (rightIndex > right.length - 1) {
				rightIndex = right.length - 1;
			}
			else {
				if (left[i].compareTo(right[rightIndex]) < 0) {
					merged[currentMergedIndex] = left[i];
					merged[currentMergedIndex + 1] = right[rightIndex];
				}
				else {
					merged[currentMergedIndex] = right[rightIndex];
					merged[currentMergedIndex + 1] = left[i];
				}
			}
			
			++rightIndex;
			currentMergedIndex += 2;
		}
		
		return merged;
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
