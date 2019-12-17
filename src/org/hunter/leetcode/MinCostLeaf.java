package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCostLeaf {

	class Node {
		Node left;
		Node right;
		List<Node> parents = new ArrayList<Node>();
		int indexLeft = -1;
		int indexRight = -1;
		int maxValue = -1;
		
		Node(int value) {
			this.value = value;
		}
		
		int value;
		
		public String toString() {
			return "value = " + this.value + " left = " + this.left + " right = " + this.right + " indexLeft = " + this.indexLeft + " indexRight = " + this.indexRight;
		}
	}
	
	public static void main(String [] args) {
		//int [] arr = new int [] { 6,2,4 };
		//int [] arr = new int [] {15,13,5,3,15};
		//510
		//exp = 500
		
		int [] arr = new int [] {3,7,2,12,15,10,3,9};
		//exp = 566
		
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
		
		List<Node> l = new ArrayList<Node>();
		
		int start = 0;
		int end = 1;
		int skip = 1;

		for (; end < arr.length; end += skip) {
			Node n = new Node(arr[start] * arr[end]);
			n.indexLeft = start;
			n.indexRight = end;
			n.maxValue = Math.max(arr[start], arr[end]);
			Node left = new Node(arr[start]);
			Node right = new Node(arr[end]);
			left.parents.add(n);
			right.parents.add(n);
			
			l.add(n);						
			start += skip;			
		}		

		while (l.size() > 0) {
			int size = l.size();
			for (int i = 0; i < size; ++i) {
				Node n = l.get(i);			
				if (n.parents.size() == 0) {
					//left
					if (n.indexLeft - 1 >= 0) {
						Node parent = new Node((arr[n.indexLeft - 1] * n.maxValue) + n.value);
						parent.indexLeft = n.indexLeft - 1;
						parent.indexRight = n.indexRight;
						parent.maxValue = Math.max(n.maxValue, arr[n.indexLeft - 1]);
						n.parents.add(parent);
						l.add(parent);
						
//						if (parent.value == 582) {
//							System.out.println("good!");
//						}
						
						if (n.indexLeft - 2 >= 0) {
							parent = new Node((arr[n.indexLeft - 1] * arr[n.indexLeft - 2]) + (Math.max(arr[n.indexLeft - 1], arr[n.indexLeft - 2]) * n.maxValue) + n.value);
//							if (parent.value == 582) {
//								System.out.println("good!");
//							}
							parent.indexLeft = n.indexLeft - 2;
							parent.indexRight = n.indexRight;
							parent.maxValue = Math.max(Math.max(n.maxValue, arr[n.indexLeft - 1]), arr[n.indexLeft - 2]);
							n.parents.add(parent);
							l.add(parent);						
						}
					}
					
					//then right
					if (n.indexRight + 1 < arr.length) {
						Node parent = new Node((arr[n.indexRight + 1] * n.maxValue) + n.value);
//						if (parent.value == 582) {
//							System.out.println("good!");
//						}
						parent.indexLeft = n.indexLeft;
						parent.indexRight = n.indexRight + 1;
						parent.maxValue = Math.max(n.maxValue, arr[n.indexRight + 1]);
						n.parents.add(parent);
						l.add(parent);
						
						if (n.indexRight + 2 < arr.length) {							
							parent = new Node((arr[n.indexRight + 1] * arr[n.indexRight + 2]) + (Math.max(arr[n.indexRight + 1], arr[n.indexRight + 2]) * n.maxValue) + n.value);
//							if (parent.value == 582) {
//								System.out.println("good!");
//							}
							parent.indexLeft = n.indexLeft;
							parent.indexRight = n.indexRight + 2;
							parent.maxValue = Math.max(Math.max(n.maxValue, arr[n.indexRight + 1]), arr[n.indexRight + 2]);
							n.parents.add(parent);
							l.add(parent);						
						}
					}				
				}
			}
			
//			for (int i = 0; i < l.size(); ++i) {
//				Node n = l.get(i);
//				if (n.value == 566) {
//					System.out.println("DONE");
//				}
//			}
			
			
			if (l.size() == size) {				
				for (int i = 0; i < l.size(); ++i) {
					Node n = l.get(i);
					if (n.value == 611 && n.parents.size() == 0) {
						System.out.println("DONE");
					}
				}				
				
				result = l.stream().filter(i -> i.parents.size() == 0).reduce((first, next) -> first.value < next.value ? first : next).get().value;
				break;
			}
		}
		
		return result;
	}
}
