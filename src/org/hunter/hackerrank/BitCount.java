package org.hunter.hackerrank;

public class BitCount {

    public static void main(String [] args) {
        BitCount b = new BitCount();
        int [] counts = b.countBits(8);//[0,1,1,2,1,2,2,3,1]
        for (int i = 0; i < counts.length; ++i) {
            System.out.println(counts[i]);
        }
    }

    public int[] countBits(int num) {
        StringBuffer bin = new StringBuffer("0");
        int [] oneBits = new int[num + 1];

        for (int i = 0; i <= num; ++i) {
            int countOnes = 0;
            for (int j = 0; j < bin.length(); ++j) {
                if (bin.charAt(j) == '1') {
                    countOnes++;
                }
            }

            boolean replaced = false;
            for (int j = bin.length() - 1; j >= 0; --j) {
                if (bin.charAt(j) == '0') {
                    replaced = true;
                    bin.replace(j, j + 1, "1");
                    break;
                }
            }

            if (!replaced) {
                int l = bin.length() + 1;
                bin = new StringBuffer();
                for (int j = 0; j < l; ++j) {
                    if (j == 0) {
                        bin.append("1");
                    }
                    else {
                        bin.append("0");
                    }
                }
            }

            oneBits[i] = countOnes;
        }

        return oneBits;
    }
}
