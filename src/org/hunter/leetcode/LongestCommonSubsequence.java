package org.hunter.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LongestCommonSubsequence {

	public static void main(String [] args) {
//		String text1 = "abcde";
//		String text2 = "ace";
		//3

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

//		String text1 = "pmjghexybyrgzczy";
//		String text2 = "hafcdqbgncrcbihkd";
		//4

//		String text1 = "dknkdizqxkdczafixidorgfcnkrirmhmzqbcfuvojsxwraxe";
//		String text2 = "dulixqfgvipenkfubgtyxujixspoxmhgvahqdmzmlyhajerqz";

		LongestCommonSubsequence l = new LongestCommonSubsequence();
		System.out.println(l.longestCommonSubsequence(text1, text2));
	}

	class CacheKey {
		String string;
		String pos;
		CacheKey(String string, String pos) {
			this.string = string;
			this.pos = pos;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			CacheKey cacheKey = (CacheKey) o;
			return Objects.equals(string, cacheKey.string) &&
					Objects.equals(pos, cacheKey.pos);
		}

		@Override
		public int hashCode() {
			return Objects.hash(string, pos);
		}
	}

	public int longestCommonSubsequence(String text1, String text2) {
		Map<CacheKey, Integer> mem = new HashMap<CacheKey, Integer>();
		return longestCommonSubsequenceMem(text1, text2, mem);
	}

	public int longestCommonSubsequenceMem(String text1, String text2, Map<CacheKey, Integer> mem) {
		if (text1.length() == 0 || text2.length() == 0) {
			return 0;
		}
		if (text1.equals(text2)) {
			return text1.length();
		}
		if (text1.length() == 1 && text2.length() == 1) {
			if (text1.equals(text2)) {
				return 1;
			}
			return 0;
		}
		int maxSize = 0;
		Map<String, Integer> matches = new HashMap<String, Integer>();
		for (char aChar : text1.toCharArray()) {
			if (text2.indexOf(aChar) > -1) {
				maxSize = Math.max(1, maxSize);
				matches.put(aChar,  String.valueOf(aChar));
			}
		}
		Map<Integer, String> matches2 = new HashMap<Integer, String>();
		index = 0;
		for (char aChar : text2.toCharArray()) {			
			if (text1.indexOf(aChar) > -1) {
				maxSize = Math.max(1, maxSize);
				matches2.put(Integer.valueOf(index),  String.valueOf(aChar));
				++index;
			}
		}
		
		for (int i = 0; i < matches.size(); ++i) {
			String string = matches.get(i);

			if (mem.get(new CacheKey(string, String.valueOf(i))) != null) {
				maxSize = Math.max(maxSize, mem.get(new CacheKey(string, String.valueOf(i))));
				continue;
			}
			
			for (int j = 0; j < matches2.size(); ++j) {
				String string2 = matches2.get(j);
				
				if (string.equals(string2)) {
					List<String> after2 = new ArrayList<String>();
					List<String> after1 = new ArrayList<String>();
					for (int k = j + 1; k < matches2.size(); ++k) {
						after2.add(matches2.get(k));
					}
					for (int l = i + 1; l < matches.size(); ++l) {
						after1.add(matches.get(l));
					}
					StringBuffer after1Matches = new StringBuffer();
					StringBuffer after2Matches = new StringBuffer();
					for (String s : after1) {
						for (String s2 : after2.stream().distinct().collect(Collectors.toList())) {
							if (s.equals(s2)) {
								after1Matches.append(s);
							}
						}
					}
					for (String s : after2) {
						for (String s2 : after1.stream().distinct().collect(Collectors.toList())) {
							if (s.equals(s2)) {
								after2Matches.append(s);
							}
						}
					}

					maxSize = Math.max(maxSize, 1 + longestCommonSubsequenceMem(after1Matches.toString(), after2Matches.toString(), mem));
					mem.put(new CacheKey(string, String.valueOf(i)), maxSize);
				}
			}
		}
		
		return maxSize;
	}
}
