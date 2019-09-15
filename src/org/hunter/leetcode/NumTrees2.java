package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumTrees2 {

	public static void main(String[] args) {
		NumTrees2 n = new NumTrees2();
//		System.out.println(n.generateTrees(1).size());
//		System.out.println(n.generateTrees(3));// 5
		System.out.println(n.generateTrees(4));// 14
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

		@Override
        public String toString() {
			return String.valueOf(val);
		}
	}

	public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> mem = new ArrayList<List<TreeNode>>(n + 1);
        mem.add(new <TreeNode>ArrayList());

        generateTrees3(n, mem);

        return mem.get(n);
	}

	public List<TreeNode> generateTrees3(int n, List<List<TreeNode>> mem) {
        List<TreeNode> list2 = new ArrayList<TreeNode>();
        list2.add(new TreeNode(1));
        mem.add(list2);

        for (int i = 2; i <= n; ++i) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            for (int k = 1; k <= i; ++k) {
                if (k == 1) {
                    if (i - k == 1) {
                        TreeNode root = new TreeNode(k);
                        root.right = new TreeNode(k + 1);
                        list.add(root);
                    }
                    else {
                        //i = 3
                        //k = 1
                        for (TreeNode t : mem.get(i - 1)) {
                            TreeNode root = new TreeNode(k);
                            root.right = copyAndIncrement(t, 1);
                            list.add(root);
                        }
                    }
                }
                else if (k == i) {
                    for (TreeNode t : mem.get(i - 1)) {
                        TreeNode root = new TreeNode(k);
                        root.left = t;
                        list.add(root);
                    }
                }
                else {
                    for (TreeNode t : mem.get(k - 1)) {
                        TreeNode root = new TreeNode(k);
                        root.left = t;

                        if (i - k == 1) {
                            root.right = new TreeNode(k + 1);
                            list.add(root);
                        }
                        else {
                            //i = 3
                            //k = 1
                            for (TreeNode t2 : mem.get(i - k)) {
                                if (root.right != null) {
                                    TreeNode copyLeft = copyAndIncrement(root.left, 0);
                                    root = new TreeNode(k);
                                    root.left = copyLeft;
                                }
                                root.right = copyAndIncrement(t2, k);
                                list.add(root);
                            }
                        }
                    }
                }
            }

            mem.add(list);
        }

	    return mem.get(n);
	}

	public TreeNode copyAndIncrement(TreeNode t, int increaseBy) {
        if (t == null) {
            return null;
        }

        TreeNode c = new TreeNode(t.val + increaseBy);

        c.left = copyAndIncrement(t.left, increaseBy);
        c.right = copyAndIncrement(t.right, increaseBy);

        return c;
    }
}
