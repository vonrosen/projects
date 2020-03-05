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
		ListNode head = new ListNode(1);
		TreeNode root = new TreeNode(1);
		
		LLInBT l = new LLInBT();
		System.out.println(l.isSubPath(head, root));
	}

	public boolean isSubPath(ListNode head, TreeNode root) {
		return search(root, head);
	}

	public boolean search(TreeNode root, ListNode head) {
		if (root.val == head.val) {
			if (head.next == null) {
				return true;
			}
			
			if (root.left != null) {
				return search(root.left, head.next);	
			}
			
			if (root.right != null) {
				return search(root.right, head.next);	
			}			
		}		
		
		if (root.left != null) {
			return search(root.left, head);
		}
		
		if (root.right != null) {
			return search(root.right, head);
		}
		
		return false;
	}
}
