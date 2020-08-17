package org.hunter;

public class BinTreeReverse{

	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		TreeNode(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "value: " + value;
		}
	}

	public static void main(String [] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(4);

		TreeNode inverted = invert(root);
		System.out.println("");
	}

	public static TreeNode invert(TreeNode node) {
		if (node.left == null) {
			return node;
		}
		if (node.left.left == null && node.right.left == null) {
			int tmp = node.left.value;
			node.left = new TreeNode(node.right.value);
			node.right = new TreeNode(tmp);
			return node;
		}

		TreeNode reversedLeft = invert(node.left);
		TreeNode reversedRight = invert(node.right);

		node.left = reversedRight;
		node.right = reversedLeft;
		return node;
	}

}
