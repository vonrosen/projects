package org.hunter;

public class MergeSort2 {

	public static void main(String [] args) {
		int [] arr = new int [] {
				4,
				44,
				22,
				11,
				23,
				8				
		};		
		MergeSort2 m = new MergeSort2();		
		int [] sorted = m.sort(arr, 0, arr.length - 1);		
		for (int i = 0; i < sorted.length; ++i) {
			System.out.println(sorted[i]);
		}
	}
	
	public int [] sort(int [] arr, int start, int end) {
		if (start >= end) {
			return new int [] { arr[end] };
		}
		
		int mid = start + ((end - start) / 2);
		
		int [] arr1 = sort(arr, start, mid);
		int [] arr2 = sort(arr, mid + 1, end);

		int [] newArr = new int[arr1.length + arr2.length];
		
		int left = 0;
		int right = 0;
		for (int i = 0; i < newArr.length; ++i) {
			if (left >= arr1.length) {
				newArr[i] = arr2[right];
				++right;
				continue;
			}
			
			if (right >= arr2.length) {
				newArr[i] = arr1[left];
				++left;
				continue;
			}
			
			if (arr1[left] < arr2[right]) {
				newArr[i] = arr1[left];
				++left;
				continue;
			}
			
			if (arr1[left] > arr2[right]) {
				newArr[i] = arr2[right];
				++right;
				continue;
			}
		}

		return newArr;
	}
	
}
