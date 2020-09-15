package org.hunter.leetcode;

public class IsPalindrome{

	public static void main(String [] args) {
		IsPalindrome i = new IsPalindrome();
		System.out.println(i.isPalindrome(121));
		System.out.println(i.isPalindrome(-121));
		System.out.println(i.isPalindrome(10));
	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		if (x < 10){
			return true;
		}

		int start = 0;
		int end = String.valueOf(x).length() - 1;
		while (start < end) {
			if (!String.valueOf(x).substring(start, start + 1).equals(String.valueOf(x).substring(end, end + 1))) {
				return false;
			}
			++start;
			--end;
			if (start >= end) {
				break;
			}
		}

		return true;
	}

}
