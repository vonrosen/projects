package org.hunter.hackerrank;

public class UniquePaths {

    public static void main(String [] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePaths(3, 2));
        System.out.println(u.uniquePaths(7, 3));
        System.out.println(u.uniquePaths(1, 2));
        System.out.println(u.uniquePaths(23, 12));
    }

    //m=across, n=down
    public int uniquePaths(int m, int n) {

        int [][] mem = new int[m][n];

        for (int i = 0; i < mem.length; ++i) {
            for (int j = 0; j < mem[i].length; ++j) {
                if (i == 0 || j == 0) {
                    mem[i][j] = 1;
                }
                else {
                    mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
                }
            }
        }

        return mem[m - 1][n - 1];
    }

}
