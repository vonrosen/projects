package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LCA {

    public static void main(String [] args) {
        LCA l = new LCA();

        //Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        //3

        //Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        //5

        /**
         *
         *
         * [-64,12,18,-4,-53,null,76,null,-51,null,null,-93,3,null,-31,47,null,-7834,53,-81,33,4,null,5657,-44,-60,11,null,null,null,null,78,null,-35,-1800,26,8805,-4992,27,60,74,null,null,8,-38,-389,1968,-24,null,-59,-49,-11,-8262,67,null,null,null,null,null,null,null,-67,null,-37,-19,10,-55,72,null,null,null,-70,17,5857,null,null,null,null,null,null,null,2931,80,44,-88,-91,null,48,-90,-30,null,null,90,-34,37,null,null,73,4304,-6955,-85,3260,-96,null,null,-18,3243,34,-6847,null,-17,-77,null,56,-65,-5715,-377,null,null,null,-33,86,null,81,-42,null,null,98,-40,70,-26,24,null,null,null,null,92,-3953,-27,null,null,null,null,null,null,5400,null,null,null,null,null,null,null,-54,-66,-36,null,-72,null,null,43,null,null,null,-92,-1,-98,null,null,null,null,null,null,null,39,-84,null,null,null,null,null,null,null,null,null,null,null,null,null,5811,null,null,null,-5185]
74
-40

expected=3
         *
         */

        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(5);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(6);
        t.left.right = new TreeNode(2);
        t.right.left = new TreeNode(0);
        t.right.right = new TreeNode(8);
        t.left.right.left = new TreeNode(7);
        t.left.right.right = new TreeNode(4);
        System.out.println(l.lowestCommonAncestor(t, new TreeNode(5), new TreeNode(1)));//3
        System.out.println(l.lowestCommonAncestor(t, new TreeNode(5), new TreeNode(4)));//5

        t = new TreeNode(-1);
        t.left = new TreeNode(0);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(-2);
        t.left.right = new TreeNode(4);
        t.left.left.left = new TreeNode(8);
        //[-1,
        //0,        3
       //-2,4,     null,null,8], 8 4

        /*
         * -1,
         *0,        3,
       -2,  4,  null ,null,
      8


8
4

         */


        System.out.println(l.lowestCommonAncestor(t, new TreeNode(8), new TreeNode(4)));//0
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

    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list2 = new ArrayList<Integer>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val) {
            return root;
        }

        list1.clear();
        list2.clear();

        lowestCommonAncestor2(root.left, p, list1);
        if (!found) {
            list1.clear();
            lowestCommonAncestor2(root.right, p, list1);
        }
        found = false;
        lowestCommonAncestor2(root.left, q, list2);
        if (!found) {
            list2.add(root.val);
            lowestCommonAncestor2(root.right, q, list2);
        }

        list1.add(root.val);
        list2.add(root.val);

        found = false;

        for (int i = 0; i < list1.size(); ++i) {
            int val1 = list1.get(i);

            for (int k = 0; k < list2.size(); ++k) {
                int val2 = list2.get(k);

                if (val1 == val2) {
                    return new TreeNode(val1);
                }
            }
        }

        return null;
    }

    boolean found = false;

    public void lowestCommonAncestor2(TreeNode root, TreeNode p, List<Integer> list) {
        if (root == null || p.val == root.val) {
            if (root != null) {
                found = true;
                list.add(root.val);
            }

            return;
        }

        lowestCommonAncestor2(root.left, p, list);

        if (found) {
            list.add(root.val);
            return;
        }

        lowestCommonAncestor2(root.right, p, list);

        if (found) {
            list.add(root.val);
            return;
        }
    }

}
