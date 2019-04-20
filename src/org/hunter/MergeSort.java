package org.hunter;

public class MergeSort<T extends Comparable<T>> {
	
	public static <T extends Comparable<T>> T [] sort(T [] array) {
		
		if (array == null) {
			return null;
		}
		
		return sortRange(array, 0, array.length);
	}
	
	private static <T extends Comparable<T>> T [] sortRange(T [] array, int start, int end) {
		
		if (start >= end) {
			return (T[]) new Comparable[]{ array[start] };	
		}
		
		int midIndex = start + ((end - start) / 2);
		
		T [] left = sortRange(array, start, midIndex);
		T [] right = sortRange(array, midIndex + 1, end);
		
		
		
		if (left.length < array.length) {
			T [] subArray = (T [])new Comparable[left.length + right.length];
			
			for (int i = 0; i < left.length; ++i) {
				if (left[i] < right[i]) {
					
				}
			}
		}
		else {
			
		}
		
	}

}
