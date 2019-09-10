package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumTrees2 {

	public static void main(String[] args) {
		NumTrees2 n = new NumTrees2();
//		System.out.println(n.generateTrees(1).size());
		System.out.println(n.generateTrees(3).size());// 5
//		System.out.println(n.generateTrees(4).size());// 14
//		System.out.println(n.generateTrees(5).size());// 42
//		System.out.println(n.generateTrees(6).size()); // 132
//		System.out.println(n.generateTrees(7).size()); // 429
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		
		public String toString() {
			return String.valueOf(val);
		}
	}    

	public List<TreeNode> generateTrees(int n) {
		TreeNode tree1 = new TreeNode(1);
		List<TreeNode> list1 = new ArrayList<TreeNode>();
		list1.add(tree1);
		TreeNode tree2 = new TreeNode(1);
		tree2.right = new TreeNode(2);
		TreeNode tree22 = new TreeNode(2);
		tree22.left = new TreeNode(1);
		List<TreeNode> list2 = new ArrayList<TreeNode>();
		list2.add(tree2);
		list2.add(tree22);

		if (n == 1) {
			return list1;
		}

		if (n == 2) {
			return list2;
		}

		List<List<TreeNode>> mem = new ArrayList<List<TreeNode>>(n + 1);
		mem.add(new <TreeNode>ArrayList());
		mem.add(list1);
		mem.add(list2);

		for (int i = 3; i <= n; ++i) {
			List<TreeNode> list = new ArrayList<TreeNode>();

			for (int k = 1; k <= i; ++k) {
				int left = k - 1;
				int right = i - k;

				if (left == 0 || left == 1) {
					for (TreeNode tree : mem.get(right)) {
						TreeNode t = new TreeNode(k);
						t.right = tree;
						list.add(t);
					}
				} else if (right == 0 || right == 1) {
					for (TreeNode tree : mem.get(left)) {
						TreeNode t = new TreeNode(k);
						t.left = tree;
						list.add(t);
					}
				} else {
					List<TreeNode> list3 = new ArrayList<TreeNode>();

					for (TreeNode tree : mem.get(right)) {
						for (TreeNode tree3 : mem.get(left)) {
							TreeNode t = new TreeNode(k);
							t.right = tree;
							t.left = tree3;
							list3.add(t);
						}
					}

					list.addAll(list3);
				}
			}

			mem.add(list);
		}

		return mem.get(n);
	}

	public int numTrees(int n) {
		int numTrees1 = 1;
		int numTrees2 = 2;

		if (n == 1) {
			return numTrees1;
		}

		if (n == 2) {
			return numTrees2;
		}

		int[] nTrees = new int[n + 1];
		nTrees[0] = 0;
		nTrees[1] = numTrees1;
		nTrees[2] = numTrees2;

		int count = 0;
		for (int i = 3; i <= n; ++i) {
			count = 0;
			for (int k = 1; k <= i; ++k) {
				int left = k - 1;
				int right = i - k;

				if (left == 0 || left == 1) {
					count += nTrees[right];
				} else if (right == 0 || right == 1) {
					count += nTrees[left];
				} else {
					count += nTrees[right] * nTrees[left];
				}
			}

			nTrees[i] = count;
		}

		return nTrees[n];
	}
}
