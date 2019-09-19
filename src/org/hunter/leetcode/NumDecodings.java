package org.hunter.leetcode;

public class NumDecodings {

    public static void main(String [] args) {
        NumDecodings n = new NumDecodings();
        System.out.println(n.numDecodings("12"));
        System.out.println(n.numDecodings("226"));
        System.out.println(n.numDecodings("0"));//0
        System.out.println(n.numDecodings("10"));//1
        System.out.println(n.numDecodings("00"));//0
        System.out.println(n.numDecodings("27"));//1
        System.out.println(n.numDecodings("01"));//0
        System.out.println(n.numDecodings("110"));//1

    }

    public int numDecodings(String s) {
        int count = 1;

        if (s.length() == 1 && s.equals("0")) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        if (s.length() == 2) {
            if (s.replace("0", "").length() == 2) {
                if (Integer.parseInt(s.replace("0", "")) <= 26) {
                    return 2;
                }
                else {
                    return 1;
                }
            }
            else {
                if (s.charAt(0) == '0') {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        }

        for (int i = 2; i < s.length(); ++i) {
            int subCount = 1;

            String sub = s.substring(i - 2, i + 1);

            for (int j = 0; j < sub.length(); ++j) {

            }


            if (sub.substring(0, 2).replace("0", "").length() == 2) {
                if (Integer.parseInt(sub.substring(0, 2)) <= 26) {
                    subCount++;
                }
            }

            if (sub.substring(1, 3).replace("0", "").length() == 2) {
                if (Integer.parseInt(sub.substring(1, 3)) <= 26) {
                    subCount++;
                }
            }

            count *= subCount;

            if (i + 2 == s.length()) {
                sub = s.substring(i, i + 2);
                if (sub.replace("0", "").length() == 2) {
                    if (Integer.parseInt(sub) <= 26) {
                        count *= 2;
                    }
                }
            }

            i += 3;

        }

        return count;
    }
}
