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
		
//		String text1 = "mhunuzqrkzsnidwbun";
//		String text2 = "szulspmhwpazoxijwbq";
		//6

		String text1 = "pmjghexybyrgzczy";
		String text2 = "hafcdqbgncrcbihkd";
		//4

//		String text1 = "dknkdizqxkdczafixidorgfcnkrirmhmzqbcfuvojsxwraxe";
//		String text2 = "dulixqfgvipenkfubgtyxujixspoxmhgvahqdmzmlyhajerqz";

		LongestCommonSubsequence l = new LongestCommonSubsequence();
		System.out.println(l.longestCommonSubsequence(text1, text2));
	}

	class CacheKey {
		Integer pos;
		Integer pos2;
		CacheKey(Integer pos, Integer pos2) {
			this.pos = pos;
			this.pos2 = pos2;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			CacheKey cacheKey = (CacheKey) o;
			return Objects.equals(pos, cacheKey.pos) &&
					Objects.equals(pos2, cacheKey.pos2);
		}

		@Override
		public int hashCode() {
			return Objects.hash(pos, pos2);
		}
	}

	public int longestCommonSubsequence(String text1, String text2) {
		Map<CacheKey, Integer> mem = new HashMap<CacheKey, Integer>();
		return longestCommonSubsequenceMem(text1, text2, null, null, mem);
	}

	public int longestCommonSubsequenceMem(String text1, String text2, List<String []> stringToPos, List<String[]> stringToPos2, Map<CacheKey, Integer> mem) {
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

		if (stringToPos == null) {
			stringToPos = new ArrayList<String[]>();
			for (int i = 0; i < text1.length(); ++i) {
				stringToPos.add(new String [] { String.valueOf(text1.charAt(i)), String.valueOf(i) });
			}
		}

		if (stringToPos2 == null) {
			stringToPos2 = new ArrayList<String []>();
			for (int i = 0; i < text2.length(); ++i) {
				stringToPos2.add(new String [] { String.valueOf(text2.charAt(i)), String.valueOf(i) });
			}
		}

		int maxSize = 0;
		int index = 0;
		int pos = 0;
		Map<Integer, String> matches = new HashMap<Integer, String>();
		Map<Integer, Integer> positions = new HashMap<Integer, Integer>();
		for (char aChar : text1.toCharArray()) {
			int indexOf = text2.indexOf(aChar);
			if (indexOf > -1) {
				maxSize = Math.max(1, maxSize);
				matches.put(index,  String.valueOf(aChar));
				positions.put(index, Integer.parseInt(stringToPos.get(pos)[1]));
				++index;
			}
			++pos;
		}
		Map<Integer, String> matches2 = new HashMap<Integer, String>();
		Map<Integer, Integer> positions2 = new HashMap<Integer, Integer>();
		index = 0;
		pos = 0;
		for (char aChar : text2.toCharArray()) {
			int indexOf = text1.indexOf(aChar);
			if (indexOf > -1) {
				maxSize = Math.max(1, maxSize);
				matches2.put(index,  String.valueOf(aChar));
				positions2.put(index, Integer.parseInt(stringToPos2.get(pos)[1]));
				++index;
			}
			++pos;
		}

		for (int i = 0; i < matches.size(); ++i) {
			String string = matches.get(i);
			Integer pos1 = positions.get(i);

			for (int j = 0; j < matches2.size(); ++j) {
				String string2 = matches2.get(j);
				Integer pos2 = positions2.get(j);

				if (mem.get(new CacheKey(pos1, pos2)) != null) {
					maxSize = Math.max(maxSize, mem.get(new CacheKey(pos1, pos2)));
					continue;
				}

				if (string.equals(string2)) {
					List<String> after1 = new ArrayList<String>();
					List<String> after2 = new ArrayList<String>();
					for (int l = i + 1; l < matches.size(); ++l) {
						after1.add(matches.get(l));
					}
					for (int k = j + 1; k < matches2.size(); ++k) {
						after2.add(matches2.get(k));
					}
					StringBuffer after1Matches = new StringBuffer();
					StringBuffer after2Matches = new StringBuffer();
					List<String []> newStringToPos = new ArrayList<String []>();
					List<String []> newStringToPos2 = new ArrayList<String []>();
					pos = i + 1;
					for (String s : after1) {
						for (String s2 : after2.stream().distinct().collect(Collectors.toList())) {
							if (s.equals(s2)) {
								after1Matches.append(s);
								newStringToPos.add(new String [] { s, String.valueOf(positions.get(pos)) });
							}
						}
						++pos;
					}
					pos = j + 1;
					for (String s : after2) {
						for (String s2 : after1.stream().distinct().collect(Collectors.toList())) {
							if (s.equals(s2)) {
								after2Matches.append(s);
								newStringToPos2.add(new String [] { s, String.valueOf(positions2.get(pos)) });
							}
						}
						++pos;
					}

					maxSize = Math.max(maxSize, 1 + longestCommonSubsequenceMem(after1Matches.toString(), after2Matches.toString(), newStringToPos, newStringToPos2, mem));
					mem.put(new CacheKey(pos1, pos2), maxSize);
				}
			}
		}
		
		return maxSize;
	}
}
