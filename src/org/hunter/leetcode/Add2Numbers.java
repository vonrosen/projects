package org.hunter.leetcode;

import java.math.BigInteger;

public class Add2Numbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer(String.valueOf(this.val));
            ListNode n = this.next;
            while (n != null) {
                sb.append(n.val);
                n = n.next;
            }

            return sb.toString();
        }
    }

    public static void main(String [] args) {
        Add2Numbers a = new Add2Numbers();

        ListNode n = new ListNode(2);
        n.next = new ListNode(4);
        n.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);

        ListNode result = a.addTwoNumbers(n, n2);
        System.out.println(result);
    }

    /**
     * Definition for singly-linked list. struct ListNode { int val; ListNode *next;
     * ListNode(int x) : val(x), next(NULL) {} };
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer sb = new StringBuffer();
        ListNode n = l1;
        while (n != null) {
            sb.append(n.val);
            sb.append(" ");
            n = n.next;
        }

        StringBuffer sb2 = new StringBuffer();
        ListNode n2 = l2;
        while (n2 != null) {
            sb2.append(n2.val);
            sb2.append(" ");
            n2 = n2.next;
        }

        BigInteger number = new BigInteger(sb.reverse().toString().replace(" ", ""));
        BigInteger number2 = new BigInteger(sb2.reverse().toString().replace(" ", ""));
        StringBuffer result = new StringBuffer(number.add(number2).toString());

        result.reverse();

        ListNode lresult = new ListNode(Integer.parseInt(String.valueOf(result.charAt(0))));
        ListNode next = lresult;

        for (int i = 1; i < result.length(); ++i) {
            next.next = new ListNode(Integer.parseInt(String.valueOf(result.charAt(i))));
            next = next.next;
        }

        return lresult;
    }

}
