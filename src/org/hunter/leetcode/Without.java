package org.hunter.leetcode;

public class Without {

    public static void main(String [] args) {
        Without w = new Without();

        System.out.println(w.strWithout3a3b(1, 2));
        System.out.println(w.strWithout3a3b(4, 1));
        System.out.println(w.strWithout3a3b(1, 4));//bbabb
        System.out.println(w.strWithout3a3b(6, 6));
        System.out.println(w.strWithout3a3b(27, 33));

    }

    public String strWithout3a3b(int A, int B) {

        StringBuffer s = new StringBuffer();

        int ACount = 0;
        int BCount = 0;

        int BLeft = B;
        int ALeft = A;

        for (int i = 0; i < (A + B); ++i) {
            boolean bLessThana = BLeft < ALeft;
            boolean bequalsa = BLeft == ALeft;

            if (bequalsa) {
                int start = i - 1 < 0 ? 0 : i - 1;
                if ((BCount < B && !s.substring(start, i).equals("b"))) {
                    s.append("b");
                    ++BCount;
                    BLeft--;
                    continue;
                }

                if ((ACount < A && !s.substring(start, i).equals("a"))) {
                    s.append("a");
                    ++ACount;
                    --ALeft;
                    continue;
                }

            }
            else {
                int start = i - 2 < 0 ? 0 : i - 2;
                if (bLessThana) {
                    if ((ACount < A && !s.substring(start, i).equals("aa"))) {
                        s.append("a");
                        ++ACount;
                        --ALeft;
                        continue;
                    }

                    if ((BCount < B && !s.substring(start, i).equals("bb"))) {
                        s.append("b");
                        ++BCount;
                        --BLeft;
                        continue;
                    }
                }
                else {
                    //more bs than as
                    if ((BCount < B && !s.substring(start, i).equals("bb"))) {
                        s.append("b");
                        ++BCount;
                        --BLeft;
                        continue;
                    }

                    if ((ACount < A && !s.substring(start, i).equals("aa"))) {
                        s.append("a");
                        ++ACount;
                        --ALeft;
                        continue;
                    }
                }
            }

            if (ACount == A && BCount == B && s.length() == (A + B)) {
                break;
            }
        }

        return s.toString();
    }

}
