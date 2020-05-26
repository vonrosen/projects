package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int x) {
        val = x;
    }
}

public class KthSmallest {

    public static void main(String[] args) {
//        TreeNode t = new TreeNode(3);
//        t.left = new TreeNode(1);
//        t.right = new TreeNode(4);
//        t.left.right = new TreeNode(2);
//
//        int k = 1;

//        [5,3,6,2,4,null,null,1]
//                3
        //output: 3

        TreeNode2 t = new TreeNode2(5);
        t.left = new TreeNode2(3);
        t.right = new TreeNode2(6);
        t.left.left = new TreeNode2(2);
        t.left.right = new TreeNode2(4);
        t.left.left.left = new TreeNode2(1);
        int k = 4;

        KthSmallest o = new KthSmallest();
        System.out.println(o.kthSmallest(t, k));
    }

    public int kthSmallest(TreeNode2 root, int k) {
        List<Integer> values = new ArrayList<Integer>();

        populateValuesList(root, values);
        sort(values, 0, values.size() - 1);

        return values.get(k - 1);
    }

    public void sort(List<Integer> values, int start, int end) {
        if (start < end) {
            int newMid = partition(values, start, end);
            sort(values, start, newMid - 1);
            sort(values, newMid + 1, end);
        }
    }

    public int partition(List<Integer> values, int start, int end) {
        int lower = start;

        for (int i = start; i <= end; ++i) {
            if (values.get(i) < values.get(end)) {
                swap(values, lower, i);
                ++lower;
            }
        }

        swap(values, lower > end ? end : lower, end);
        return lower > end ? end : lower;
    }

    public void swap(List<Integer> values, int index1, int index2) {
        int tmp = values.get(index1);
        values.set(index1, values.get(index2));
        values.set(index2, tmp);
    }

    public void populateValuesList(TreeNode2 root, List<Integer> values) {
        if (root == null) {
            return;
        }

        values.add(root.val);

        if (root.left != null) {
            populateValuesList(root.left, values);
        }

        if (root.right != null) {
            populateValuesList(root.right, values);
        }
    }

}
