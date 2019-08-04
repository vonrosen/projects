package org.hunter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String [] args) {
        LongestSubstring l = new LongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
        System.out.println(l.lengthOfLongestSubstring("dvdf")); //3
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        //int [] mem = new int[s.length()];
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int currentLength = 1;
        int maxLength = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == null) {
                maxLength = currentLength > maxLength ? currentLength : maxLength;
                map.put(s.charAt(i), i);
            }
            else {

                currentLength = 0;
            }

            ++currentLength;
        }

        return maxLength;
    }

//    public int lengthOfLongestSubstring(String s) {
//        if (s == null) {
//            return 0;
//        }
//
//        if (s.length() == 1) {
//            return 1;
//        }
//
//        int length = s.length();
//        while (length > 1) {
//            int start = 0;
//            while (start + length <= s.length()) {
//                String sub = s.substring(start, start + length);
//
//                boolean repeat = false;
//                for (int i = 0; i < sub.length(); ++i) {
//                    if (sub.indexOf(sub.charAt(i), i + 1) != -1) {
//                        repeat = true;
//                        break;
//                    }
//                }
//
//                if (!repeat) {
//                    return length;
//                }
//
//                ++start;
//            }
//
//            length--;
//        }
//
//        return length;
//    }

}
