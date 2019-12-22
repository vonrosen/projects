package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinCostLeaf {

	class Node {
		int indexLeft = -1;
		int indexRight = -1;
		int maxLeafValue = -1;
		
		Node(int value) {
			this.value = value;
		}
		
		int value;
		
		public String toString() {
			return "value = " + this.value + " indexLeft = " + this.indexLeft + " indexRight = " + this.indexRight + " maxLeafValue = " + this.maxLeafValue;
		}
	}
	
	public int mctFromLeafValuesBest(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        return dfs(arr, 0, n - 1, dp);
    }
    
    public int dfs(int[] arr, int s, int e, int[][] dp) {
        if (s == e) return 0;
        if (dp[s][e] > 0) return dp[s][e];
        int ans = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            int left = dfs(arr, s, i, dp);
            int right = dfs(arr, i + 1, e, dp);
            int maxLeft = 0, maxRight = 0;
            for (int j = s; j <= i; j++) maxLeft = Math.max(maxLeft, arr[j]);
            for (int j = i + 1; j <= e; j++) maxRight = Math.max(maxRight, arr[j]);
            ans = Math.min(ans, left + right + maxLeft * maxRight);
        }
        dp[s][e] = ans;
        return ans;
    }	
	
	public static void main(String [] args) {
		//int [] arr = new int [] { 6,2,4 };
		//int [] arr = new int [] {15,13,5,3,15};
		//510
		//exp = 500
		
		int [] arr = new int [] {3,7,2,12,15,10,3,9};
		//exp = 566		
		//int [] arr = new int [] {3,7,2,12};
		//int [] arr = new int [] {15,10,3,9};
		//int [] arr = new int [] {6,2,8,3};
		//int [] arr = new int [] {6,2,4,1,7};

		
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
		
		Map<Integer, List<Node>> m = new HashMap<Integer, List<Node>>();
		
		int skip = 1;
		while (skip < arr.length) {
			int end = skip;
			for (int start = 0; end < arr.length; start++, end++) {
				if (skip == 1) {
					Node n = new Node(arr[start] * arr[end]);
					n.indexLeft = start;
					n.indexRight = end;
					n.maxLeafValue = Math.max(arr[start], arr[end]);		

					m.putIfAbsent(skip, new ArrayList<Node>());
					m.get(skip).add(n);					
				}
				else {
					Node n = new Node(0);
					n.indexLeft = start;
					n.indexRight = end;
					
					for (int ii = start; ii <= end; ++ii) {
						n.maxLeafValue = n.maxLeafValue < arr[ii] || n.maxLeafValue == 0 ? arr[ii] : n.maxLeafValue;
					}
					
					int mid = skip / 2;
					for (int i = skip - 1; i >= mid; --i) {
						for (Node node : m.get(i)) {
							if (node.indexLeft >= start && node.indexRight <= end) {
								if (node.indexLeft == start) {
									int remain = end - node.indexRight - 1;
									if (remain == 0) {
										//only 1 element remaining
										int product = node.maxLeafValue * arr[end] + node.value;										
										n.value = product < n.value || n.value == 0 ? product : n.value;										
									}
									else {
										for (Node nn : m.get(remain)) {
											if (nn.indexLeft == node.indexRight + 1 && nn.indexRight == end) {
												int product = (node.maxLeafValue * nn.maxLeafValue) + node.value + nn.value; 										
												n.value = product < n.value || n.value == 0 ? product : n.value;																						
											}
										}
									}
								}
								
								if (node.indexRight == end) {
									int remain = node.indexLeft - start - 1;
									if (remain == 0) {
										//only 1 element remaining
										int product = node.maxLeafValue * arr[start] + node.value;										
										n.value = product < n.value || n.value == 0 ? product : n.value;										
									}
									else {
										for (Node nn : m.get(remain)) {
											if (nn.indexLeft == start && nn.indexRight == node.indexLeft - 1) {
												int product = (node.maxLeafValue * nn.maxLeafValue) + node.value + nn.value; 										
												n.value = product < n.value || n.value == 0 ? product : n.value;																						
											}
										}
									}									
								}
								
								if (node.indexLeft > start && node.indexRight < end) {
									int startLeft = start;
									int endLeft = node.indexLeft - 1;
									int startRight = node.indexRight + 1;
									int endRight = end;
									int nodeValue = 0;
									int maxLeafValue = 0;

									if (startLeft == endLeft) {
										int product = (node.maxLeafValue * arr[startLeft]) + node.value; 										
										nodeValue = product < n.value || n.value == 0 ? product : n.value;
										maxLeafValue = Math.max(n.maxLeafValue, arr[startLeft]);
									}
									else {
										for (Node nn : m.get(endLeft - startLeft)) {
											if (nn.indexLeft == start && nn.indexRight == endLeft) {
												int product = (node.maxLeafValue * nn.maxLeafValue) + node.value + nn.value; 										
												nodeValue = product < n.value || n.value == 0 ? product : n.value;
												maxLeafValue = Math.max(nn.maxLeafValue, n.maxLeafValue);
											}
										}										
									}
									
									if (startRight == endRight) {
										int product = (maxLeafValue * arr[endRight]) + nodeValue; 										
										n.value = product < n.value || n.value == 0 ? product : n.value;																				
									}
									else {
										for (Node nn : m.get(endRight - startRight)) {
											if (nn.indexLeft == startRight && nn.indexRight == endRight) {
												int product = (maxLeafValue * nn.maxLeafValue) + nodeValue + nn.value; 										
												n.value = product < n.value || n.value == 0 ? product : n.value;																						
											}										
										}										
									}
								}
							}
						}
					}	
					
					m.putIfAbsent(skip, new ArrayList<Node>());
					m.get(skip).add(n);					
				}			
			}
			++skip;
		}
		
		return m.get(skip - 1).stream().reduce((first, next) -> first.value < next.value ? first : next).get().value;		
	}
}
