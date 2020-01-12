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

		@Override
        public String toString() {
			return "value = " + this.value + " indexLeft = " + this.indexLeft + " indexRight = " + this.indexRight + " maxLeafValue = " + this.maxLeafValue;
		}
	}

	public static void main(String [] args) {
		//int [] arr = new int [] { 6,2,4 };
		//int [] arr = new int [] {15,13,5,3,15};
		//510
		//exp = 500

		int [] arr = new int [] {3,7,2,12,15,10,3,9};
		//int [] arr = new int [] {3,7,2,12};
		//int [] arr = new int [] {15,10,3,9};
		//int [] arr = new int [] {6,2,8,3};
		//int [] arr = new int [] {6,2,4,1,7};

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

		Map<Integer, List<Node>> m = new HashMap<Integer, List<Node>>();

		int skip = 1;
		while (skip < arr.length) {
			int start = 0;
			int end = start + skip;

			for (; end < arr.length; end += skip) {
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

									if (endLeft - startLeft == 0) {
										int product = (node.maxLeafValue * arr[startLeft]) + node.value;
										n.value = product < n.value || n.value == 0 ? product : n.value;
									}
									else {
										for (Node nn : m.get(endLeft - startLeft)) {
											if (nn.indexLeft == start && nn.indexRight == endLeft) {
												int product = (node.maxLeafValue * nn.maxLeafValue) + node.value + nn.value;
												n.value = product < n.value || n.value == 0 ? product : n.value;
											}
										}
									}

									if (endRight - startRight == 1) {

									}
									else {
										for (Node nn : m.get(endRight - startRight)) {
											if (nn.indexLeft == startRight && nn.indexRight == endRight) {
												int product = (node.maxLeafValue * nn.maxLeafValue) + node.value + nn.value;
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

				start += skip;
			}
			++skip;
		}

		return m.get(skip - 1).stream().reduce((first, next) -> first.value < next.value ? first : next).get().value;
	}
}
