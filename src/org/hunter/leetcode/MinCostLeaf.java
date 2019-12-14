package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCostLeaf {

	public static void main(String [] args) {
		//int [] arr = new int [] { 6,2,4 };
		int [] arr = new int [] {15,13,5,3,15};
		//510
		//exp = 500
		
		MinCostLeaf mcl = new MinCostLeaf();		
		System.out.println(mcl.mctFromLeafValues(arr));
	}
	
	public int mctFromLeafValues(int[] arr) {
		if (arr.length == 0 || arr.length == 1) {
			return 0;
		}

		if (arr.length == 2) {
			return arr[0] * arr[1];
		}
		
		int result = 0;

		List<int []> l = new ArrayList<int []>();
		
		int start = 0;
		int end = 1;
		int skip = 1;

		for (; end < arr.length; end += skip) {
			int prod = arr[start] * arr[end];
			int max = Math.max(arr[start], arr[end]);
			int left = -1;
			if (start - 1 >= 0) {
				left = start - 1;
			}
			
			int right = -1;
			if (end + 1 < arr.length) {
				right = end + 1;
			}
			
			if (left != -1) {
				l.add(new int [] { prod, max, left, -1 });	
			}
			
			if (right != -1) {
				l.add(new int [] { prod, max, -1, right });
			}
						
			start += skip;			
		}

		while (l.size() > 0) {
			int minProd = 0;
			int size = l.size();
			for (int i = 0;  i < l.size(); ++i) {
				int [] e = l.get(i);
				
				int prod = e[0];
				int max = e[1];
				int left = e[2];
				int right = e[3];
				
				if (left != -1) {
					int newProd = prod + (max * arr[left]);
					int newLeft = left - 1 >= 0 ? left - 1 : -1;		
					int newMax = Math.max(arr[left], max);
					
					if (minProd == 0) {
						minProd = newProd;
					}
					else {
						minProd = Math.min(minProd, newProd);
					}									
					
					if (newLeft != -1) {
						l.add(new int [] { newProd, newMax, newLeft, right });	
					}					
				}
				
				if (right != -1) {
					int newProd = prod + (max * arr[right]);
					int newRight = right + 1 < arr.length ? right + 1 : -1;					
					int newMax = Math.max(arr[right], max);
					
					if (minProd == 0) {
						minProd = newProd;
					}
					else {
						minProd = Math.min(minProd, newProd);
					}														
					
					if (newRight != -1) {
						l.add(new int [] { newProd, newMax, left, newRight });	
					}					
				}	
			}
			
			for (int i = size - 1; i >= 0; --i) {
				l.remove(i);
			}
			
			result = minProd;
		}
		
		return result;
	}
	
	public int mctFromLeafValues2(int[] arr) {
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
			int finalValue = 0;
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
							l.add(tmpArr[start] * tmpArr[tmpEnd]);
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
				
				int sum = l.stream().mapToInt(Integer::intValue).sum();				
				l.clear();
				
				if (finalValue == 0) {
					finalValue = sum + (remaining * Arrays.stream(tmpArr).max().getAsInt());
				}
				else {
					finalValue = Math.min(finalValue, sum + (remaining * Arrays.stream(tmpArr).max().getAsInt()));
				}
				
				tmpEven++;
				outerStart++;
			}
			
			return finalValue;
		}

		return l.stream().mapToInt(Integer::intValue).sum();
    }	
}
