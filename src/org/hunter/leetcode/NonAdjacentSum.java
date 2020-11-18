package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NonAdjacentSum{

	public static void main(String [] args){
		int [] arr = {1, 9, 8, 3, 16, 7, 15, 11, 12, 4};
		int K = 14;
		NonAdjacentSum n = new NonAdjacentSum();
		int [] mem = new int [arr.length];
		n.sum(0, arr, K, mem);
		System.out.println(n.sums);
	}

	List<Integer> sums = new ArrayList<>();

	public boolean sum(int start, int [] arr, int K, int [] mem){
		if (K == 0){
			return true;
		}
		if (start >= arr.length){
			return false;
		}
		for (int i = start; i < arr.length; ++i){
			for (int skip = 2; skip < arr.length; ++skip){
				if (sum(i + skip, arr,K - arr[i], mem)) {
					sums.add(arr[i]);
					return true;
				}
			}
		}
		return false;
	}

}
