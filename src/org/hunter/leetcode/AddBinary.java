package org.hunter.leetcode;

public class AddBinary {
    public static void main(String[] args) {
        String a = "11", b = "1";
//        String a = "1010", b = "1011";
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        StringBuffer sum = new StringBuffer();
        boolean carry = false;
        while (aIndex >= 0 || bIndex >= 0) {
            char aChar = aIndex >= 0 ? a.charAt(aIndex) : '2';
            char bChar = bIndex >= 0 ? b.charAt(bIndex) : '2';

            if (aChar == '0' && bChar == '0') {
                sum.append(carry ? "1" : "0");
                carry = false;
            } else if (aChar == '1' && bChar == '0') {
                sum.append(carry ? "0" : "1");
            } else if (aChar == '0' && bChar == '1') {
                sum.append(carry ? "0" : "1");
            } else if (aChar == '1' && bChar == '1') {
                sum.append(carry ? "1" : "0");
                carry = true;
            }
            else if (aChar == '2') {
                    if (bChar == '1') {
                            sum.append(carry ? "0" : "1");
                    }
                    else {
                            sum.append(carry ? "1" : "0");
                            carry = false;
                    }
            }
            else if (bChar == '2') {
                    if (aChar == '1') {
                            sum.append(carry ? "0" : "1");
                    }
                    else {
                            sum.append(carry ? "1" : "0");
                            carry = false;
                    }
            }

            --aIndex;
            --bIndex;
        }

        if (carry) {
                sum.append("1");
        }

        return sum.reverse().toString();
    }
}
