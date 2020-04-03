package org.hunter.leetcode;

public class PalindromicSubstrings {

	public static void main(String [] args) {
		String s = "aaa";
		
		PalindromicSubstrings p = new PalindromicSubstrings();
		System.out.println(p.countSubstrings(s));
		
	}

	//N + (N ^ 2) = O(N^2)
	public int countSubstrings(String s) {
		int count = s.length();
		int [][] palins = new int[s.length()][s.length() + 1];
		
		for (int i = 0; i < s.length(); ++i) {
			palins[i][0] = 1;
			palins[i][1] = 1;
		}

		for (int l = 2; l <= s.length(); ++l) {
			for (int i = 0; i < s.length(); ++i) {
				if (i + l - 1 < s.length()) {				
					if (s.charAt(i) == s.charAt(i + l - 1)) {
						if (palins[i + 1][l - 2] > 0) {
							palins[i][l] = 1;
							++count;
						}						
					}
				}
			}
		}
		
		return count;		
    }	
	
}
