package org.hunter.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LLInBT {

	public static void main(String[] args) {
//		[4,2,8]
//				[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
		//true
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(8);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);		
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(6);
		root.right.left.right = new TreeNode(8);
		root.right.left.right.left = new TreeNode(1);
		root.right.left.right.right = new TreeNode(3);
		
		LLInBT l = new LLInBT();
		System.out.println(l.isSubPath(head, root));
	}

	public boolean isSubPath(ListNode head, TreeNode root) {
		return search(root, head, false);
	}

	public boolean search(TreeNode root, ListNode head, boolean isMatching) {
		if (root.val == head.val) {
			if (head.next == null) {
				return true;
			}
			
			if (root.left != null) {
				boolean result = search(root.left, head.next, true);
				if (result) {
					return result;
				}
			}
			
			if (root.right != null) {
				boolean result = search(root.right, head.next, true);
				if (result) {
					return result;
				}
			}			
		}
		
		if (isMatching) {
			return false;
		}
		
		if (root.left != null) {
			boolean result = search(root.left, head, false);
			if (result) {
				return result;
			}
		}
		
		if (root.right != null) {
			boolean result = search(root.right, head, false);
			if (result) {
				return result;
			}
		}
		
		return false;
	}
}
