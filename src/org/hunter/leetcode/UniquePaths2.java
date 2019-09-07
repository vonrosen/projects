package org.hunter.leetcode;

public class UniquePaths2 {

    public static void main(String [] args) {
        UniquePaths2 u = new UniquePaths2();
        System.out.println(u.uniquePathsWithObstacles(new int[][] {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        }));
        System.out.println(u.uniquePathsWithObstacles(new int[][] {
            {1}
        }));
        System.out.println(u.uniquePathsWithObstacles(new int[][] {
            {1,0}
        }));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] mem = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < mem.length; ++i) {
            for (int j = 0; j < mem[i].length; ++j) {
                if ((i == 0 || j == 0) && obstacleGrid[i][j] == 0) {
                    if (i > 0) {
                        mem[i][j] = obstacleGrid[i - 1][j] == 0 ? mem[i - 1][j] : 0;
                    }
                    else if (j > 0) {
                        mem[i][j] = obstacleGrid[i][j - 1] == 0 ? mem[i][j - 1] : 0;
                    }
                    else {
                        mem[i][j] = 1;
                    }
                }
                else {
                    if (obstacleGrid[i][j] == 0) {
                        mem[i][j] = mem[i - 1][j]  + mem[i][j - 1];
                    }
                }
            }
        }

        return mem[mem.length - 1][mem[0].length - 1];
    }

}
