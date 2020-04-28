package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonSubsequence {

	public static void main(String [] args) {
//		String text1 = "abcde";
//		String text2 = "ace";
//		String text1 = "abc", text2 = "abc";
//		String text1 = "abc", text2 = "def";
		
		String text1 = "pmjghexybyrgzczy";
		String text2 = "hafcdqbgncrcbihkd";		
		
		LongestCommonSubsequence l = new LongestCommonSubsequence();
		System.out.println(l.longestCommonSubsequence(text1, text2));
	}
	
	public int longestCommonSubsequence(String text1, String text2) {
		int maxSize = 0;		
		Map<Integer, List<String>> mem = new HashMap<Integer, List<String>>();
		mem.put(text1.length(), new ArrayList<String>());
		for (int i = text1.length() - 1; i >= 0; --i) {			
			mem.putIfAbsent(i, new ArrayList<String>());
			char charAtThisPos = text1.charAt(i);
			int io = text2.indexOf(charAtThisPos);
			if (io > -1) {
				maxSize = Math.max(1, maxSize);
			}			
			mem.get(i).add(String.valueOf(charAtThisPos));
			for (String s : mem.get(i + 1)) {
				StringBuffer sb = new StringBuffer();
				sb.append(charAtThisPos).append(s);
				maxSize = Math.max(textLen(sb.toString(), text2), maxSize);
				mem.get(i).add(sb.toString());
				mem.get(i).add(s);
			}			
			
			
			
//			for (int p = i + 1; p < text1.length(); ++p) {				
//				for (String s : mem.get(p)) {
//					StringBuffer sb = new StringBuffer();
//					sb.append(charAtThisPos).append(s);
//					maxSize = Math.max(textLen(sb.toString(), text2), maxSize);
//					mem.get(i).add(sb.toString());
//				}
//			}
		}
		
		return maxSize;
    }
	
	public int textLen(String subString, String text) {
		int pos = -1;
		for (char aChar : subString.toCharArray()) {
			int textPos = text.lastIndexOf(aChar);
			if (textPos > pos) {
				pos = textPos;				
			}
			else {
				return -1;
			}
		}
		
		return subString.length();
	}
}
