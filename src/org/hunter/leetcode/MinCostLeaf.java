package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCostLeaf {

	public static void main(String [] args) {
		int [] arr = new int [] { 6,2,4 };
		
		MinCostLeaf mcl = new MinCostLeaf();		
		System.out.println(mcl.mctFromLeafValues(arr));
	}
	
	public int mctFromLeafValues(int[] arr) {
		if (arr.length == 0 || arr.length == 1) {
			return 0;
		}
		
		List<Integer> l = new ArrayList<Integer>();
		
		if (arr.length % 2 == 0) {			
			int end = 1;
			while (end < arr.length) {
				int start = 0;
				int tmpEnd = end;
				int skip = (tmpEnd - start) + 1;
				for (; tmpEnd < arr.length; tmpEnd += skip) {
					int mid = (start + tmpEnd) / 2;
					if (start == mid) {
						l.add(arr[start] * arr[tmpEnd]);
					}
					else {
						int limit = mid - start;
						int leftMax = Arrays.stream(arr).skip(start).limit(limit + 1).max().getAsInt();
						int rightMax = Arrays.stream(arr).skip(mid + 1).limit(limit + 1).max().getAsInt();						
						l.add(leftMax * rightMax);
					}					
					start += skip;
				}
				end *= 2;
				end++;
			}
		}
		else {
			int even = arr.length - 1;
			int tmpEven = even;
			int outerStart = 0;
			while (tmpEven - 1 < arr.length) {
				int [] tmpArr = Arrays.stream(arr).skip(outerStart).limit(tmpEven).toArray();
				
				int end = 1;
				while (end < tmpArr.length) {
					int start = 0;
					int tmpEnd = end;
					int skip = (tmpEnd - start) + 1;
					for (; tmpEnd < tmpArr.length; tmpEnd += skip) {
						int mid = (start + tmpEnd) / 2;
						if (start == mid) {
							l.add(arr[start] * arr[tmpEnd]);
						}
						else {
							int limit = mid - start;
							int leftMax = Arrays.stream(tmpArr).skip(start).limit(limit + 1).max().getAsInt();
							int rightMax = Arrays.stream(tmpArr).skip(mid + 1).limit(limit + 1).max().getAsInt();						
							l.add(leftMax * rightMax);
						}					
						start += skip;
					}
					end *= 2;
					end++;
				}				
				
				int remaining = 0;
				if (outerStart == 0) {
					remaining = arr[arr.length - 1];
				}
				else {
					remaining = arr[0];
				}
				
				
				
				l.stream().mapToInt(Integer::intValue).sum();				
				l.clear();
				
				tmpEven++;
				outerStart++;
			}
		}

		return l.stream().mapToInt(Integer::intValue).sum();
    }	
}
