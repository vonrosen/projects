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
		
//		String text1 = "pmjghexybyrgzczy";
//		String text2 = "hafcdqbgncrcbihkd";
		//4
		
//		String text1 = "bsbininm";
//		String text2 = "jmjkbkjkv";
		
//		String text1 = "yzebsbuxmtcfmtodclszgh";
//		String text2 = "ejevmhcvshclydqrulwbyha";
		
		String text1 = "mhunuzqrkzsnidwbun";
		String text2 = "szulspmhwpazoxijwbq";
		//6
		
//		String text1 = "pcbmdupybalwpkbidypqbwhefijytypwdwbsharqdurkrslqlqla";
//		String text2 = "jodcpirubsryvudgpwncrmtypatunqpkhehuhkdmbctyxghsfktaz";		
		
		LongestCommonSubsequence l = new LongestCommonSubsequence();
		System.out.println(l.longestCommonSubsequence(text1, text2));
	}
	
	public int longestCommonSubsequence(String text1, String text2) {
		int maxSize = 0;		
		Map<Integer, String[]> matches = new HashMap<Integer, String[]>();
		int pos = 0;
		int index = 0;
		for (char aChar : text1.toCharArray()) {			
			if (text2.indexOf(aChar) > -1) {
				maxSize = Math.max(1, maxSize);
				matches.put(Integer.valueOf(index),  new String [] { String.valueOf(aChar), String.valueOf(pos) });
				++index;
			}
			++pos;
		}		
		Map<Integer, String[]> matches2 = new HashMap<Integer, String[]>();
		pos = 0;
		index = 0;
		for (char aChar : text2.toCharArray()) {			
			if (text1.indexOf(aChar) > -1) {
				maxSize = Math.max(1, maxSize);
				matches2.put(Integer.valueOf(index),  new String [] { String.valueOf(aChar), String.valueOf(pos) });
				++index;
			}
			++pos;
		}		
		
		for (int i = 0; i < matches.size(); ++i) {
			String [] string = matches.get(i);			
			
			for (int j = 0; j < matches2.size(); ++j) {
				String [] string2 = matches2.get(j);
				
				if (string[0].equals(string2[0])) {
					List<String[]> after2 = new ArrayList<String []>();
					
					for (int k = j + 1; k < matches2.size(); ++k) {
						String [] string3 = matches2.get(k);
						after2.add(string3);
					}

					List<String []> after2Matching = new ArrayList<String []>();
					index = 0;
					for (int l = i + 1; l < matches.size(); ++l) {
						String [] string4 = matches.get(l);
						if (index < after2.size()) {
							String [] s = after2.get(index);
							if (s != null) {
								if (s[0].equals(string4[0])) {
									after2Matching.add(string4);	
								}														
							}									
							++index;							
						}
					}
					maxSize = Math.max(after2Matching.size() + 1, maxSize);
				}
			}			
		}
		
		return maxSize;
	}
	
	public int longestCommonSubsequence3(String text1, String text2) {	
		int maxSize = 0;		
		Map<Integer, String[]> matches = new HashMap<Integer, String[]>();
		int pos = 0;
		int index = 0;
		for (char aChar : text1.toCharArray()) {			
			if (text2.indexOf(aChar) > -1) {
				maxSize = Math.max(1, maxSize);
				matches.put(Integer.valueOf(index),  new String [] { String.valueOf(aChar), String.valueOf(pos) });
				++index;
			}
			++pos;
		}
		
		Map<Integer, List<String[]>> sToLen = new HashMap<Integer, List<String[]>>();
		int len = matches.size();		
		for (int i = 2; i <= len; ++i) {
			sToLen.put(i, new ArrayList<String []>());
			if (i == 2) {				
				for (int j = 0; j < matches.size(); ++j) {
					for (int k = j + 1; k < matches.size(); ++k) {
						String[] chars = matches.get(j);
						String[] chars2 = matches.get(k);
						String s = chars[0] + chars2[0];
						int length = textLen(s, text2);
						if (length > -1) {
							maxSize = Math.max(length, maxSize);
							sToLen.get(i).add(new String [] { s, chars2[1] });	
						}
					}
				}
			}
			else {
				List<String []> strings = sToLen.get(i - 1);
				System.out.println(strings.size());
				for (String [] string : strings) {
					pos = Integer.parseInt(string[1]);
					for (int j = 0; j < matches.size(); ++j) {
						String s []  = matches.get(j);
						if (Integer.parseInt(s[1]) > pos) {
							StringBuffer sb = new StringBuffer(string[0]);
							sb.append(s[0]);
							int length = textLen(sb.toString(), text2);
							if (length > -1) {
								maxSize = Math.max(length, maxSize);
								sToLen.get(i).add(new String [] { sb.toString(), s[1] });	
							}
						}
					}
				}				
			}
		}		
		
		return maxSize;
	}
	
	public int longestCommonSubsequence2(String text1, String text2) {
		int maxSize = 0;		
		int lastMatchPos = text1.length();
		Map<Integer, List<String>> mem = new HashMap<Integer, List<String>>();
		mem.put(text1.length(), new ArrayList<String>());
		for (int i = text1.length() - 1; i >= 0; --i) {			
			mem.putIfAbsent(i, new ArrayList<String>());
			char charAtThisPos = text1.charAt(i);
			int io = text2.indexOf(charAtThisPos);
			if (io > -1) {
				maxSize = Math.max(1, maxSize);
				mem.get(i).add(String.valueOf(charAtThisPos));
			}			
			else {
				continue;
			}						
			for (String s : mem.get(lastMatchPos)) {
				StringBuffer sb = new StringBuffer();
				sb.append(charAtThisPos).append(s);
				int len = textLen(sb.toString(), text2);
				if (len != -1) {
					maxSize = Math.max(len, maxSize);
					mem.get(i).add(sb.toString());					
				}
				mem.get(i).add(s);
			}
			System.out.println(mem.get(i).size());
			mem.remove(lastMatchPos);
			lastMatchPos = i;
		}
		
		return maxSize;
    }	
	
	public int textLen(String subString, String text) {
		int pos = -1;
		for (char aChar : subString.toCharArray()) {
			int pos2 = text.indexOf(aChar, pos);
			if (pos2 == -1) {
				return -1;
			}
			pos = pos2 + 1;
		}
		
		return subString.length();
	}
}
