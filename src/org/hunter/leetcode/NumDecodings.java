package org.hunter.leetcode;

public class NumDecodings {

    public static void main(String [] args) {
        NumDecodings n = new NumDecodings();
        System.out.println(n.numDecodings("12"));//2
        System.out.println(n.numDecodings("226"));//3
        System.out.println(n.numDecodings("0"));//0
        System.out.println(n.numDecodings("10"));//1
        System.out.println(n.numDecodings("00"));//0
        System.out.println(n.numDecodings("27"));//1
        System.out.println(n.numDecodings("01"));//0
        System.out.println(n.numDecodings("110"));//1
        System.out.println(n.numDecodings("101"));//1
        System.out.println(n.numDecodings("1090"));//0
        System.out.println(n.numDecodings("5114"));//3

        //511452234566
        //1211452234566
        //12110452234566
        //12110204
        //511412
    }

    public int numDecodings(String s) {
        int count = 1;

        if (s.contains("0")) {
            count = 0;
        }

        if (s.contains("00")) {
            return 0;
        }

        if (s.startsWith("0")) {
            return 0;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                if (Integer.parseInt(s.substring(i - 1, i + 1)) > 26) {
                    return 0;
                }
            }
        }

        if (s.length() == 2) {
            if (Integer.parseInt(s) <= 26) {
                if (s.endsWith("0")) {
                    return 1;
                }
                else {
                    return 2;
                }
            }
            else {
                if (s.endsWith("0")) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        }

        for (int i = 0; i < s.length(); ++i) {
            if (i + 1 > s.length() - 1) {
                break;
            }

            if (i + 2 < s.length() && s.charAt(i + 2) == '0') {
                continue;
            }

            if (Integer.parseInt(s.substring(i, i + 2)) <= 26 && s.charAt(i) != '0') {
                //count = count == 0 ? 2 : count * 2;
                count++;
            }
        }

        return count;
    }

    public int numDecodings2(String s) {
        int count = 1;

        if (s.contains("00")) {
            return 0;
        }

        if (s.startsWith("0")) {
            return 0;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                if (Integer.parseInt(s.substring(i - 1, i + 1)) > 26) {
                    return 0;
                }
            }
        }

        if (s.length() == 2) {
            if (Integer.parseInt(s) <= 26) {
                if (s.endsWith("0")) {
                    return 1;
                }
                else {
                    return 2;
                }
            }
            else {
                if (s.endsWith("0")) {
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
            if (!sub.contains("0")) {
                if (Integer.parseInt(sub.substring(0, 2)) <= 26) {
                    subCount++;
                }

                if (Integer.parseInt(sub.substring(1, 3)) <= 26) {
                    subCount++;
                }
            }

            count *= subCount;

            //12326
            //12043
            if (i + 2 == s.length() - 1) {
                if (!s.contains("0")) {
                   if (Integer.parseInt(s.substring(s.length() - 2, s.length())) <= 26) {
                       count *= 2;
                   }
                }
            }

            i += 3;
        }

        return count;
    }
}
