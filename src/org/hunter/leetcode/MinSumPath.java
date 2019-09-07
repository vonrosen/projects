package org.hunter.leetcode;

public class MinSumPath {

    public static void main(String [] args) {
        MinSumPath m = new MinSumPath();

        System.out.println(m.minPathSum(new int [][] {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        }));
    }

    public int minPathSum(int[][] grid) {

        int [][] mem = new int[grid.length][grid[0].length];

        for (int i = 0; i < mem.length; ++i) {
            for (int j = 0; j < mem[0].length; ++j) {
                if (i == 0 && j == 0) {
                    mem[i][j] = grid[i][j];
                }
                else {
                    if (j == 0) {
                        mem[i][j] = grid[i][j] + mem[i - 1][j];
                    }
                    else if (i == 0) {
                        mem[i][j] = grid[i][j] + mem[i][j - 1];
                    }
                    else {
                        mem[i][j] = grid[i][j] + (mem[i - 1][j] > mem[i][j - 1] ? mem[i][j - 1] : mem[i - 1][j]);
                    }
                }
            }
        }

        return mem[grid.length - 1][grid[0].length -1];
    }
}
