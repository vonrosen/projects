package org.hunter.hackerrank;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class UniquePaths2 {

    public static void main(String [] args) {
        UniquePaths2 u = new UniquePaths2();
        System.out.println(u.uniquePathsWithObstacles(new int[][] {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        }));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            return obstacleGrid[0][0] == 0 ? 1 : 0;
        }


        Map<Point, Integer> map = new HashMap<Point, Integer>();

        int [][] mem = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < mem.length; ++i) {
            for (int j = 0; j < mem[i].length; ++j) {
                mem[i][j] = obstacleGrid[i][j];
            }
        }

        for (int i = 0; i < mem.length; ++i) {
            for (int j = 0; j < mem[i].length; ++j) {
                for (int k = 0; k < 2; ++k) {
                    if (k == 0) { //move right
                        if (i == 0 && j == 0) {
                            if (i < mem.length - 1 && obstacleGrid[i][j] == 0) {
                                if (obstacleGrid[i + 1][j] == 0) {
                                    mem[i + 1][j] = 1;
                                    Point p = new Point(i + 1, j);

                                    map.put(p, 1);
                                }
                            }
                        }
                        else {
                            if (mem[i][j] > 0) {
                                if (i < mem.length - 1 && obstacleGrid[i][j] == 0) {
                                    if (obstacleGrid[i + 1][j] == 0) {
                                        Integer current = map.get(new Point(i, j));
                                        Integer next = map.get(new Point(i + 1, j));
                                        mem[i + 1][j] = 1;

                                        map.put(new Point(i + 1, j), next == null ? current : current + next);
                                    }
                                }
                            }
                        }
                    }
                    else { //move down
                        if (i == 0 && j == 0) {
                            if (j < mem[i].length - 1 && obstacleGrid[i][j] == 0) {
                                if (obstacleGrid[i][j + 1] == 0) {
                                    mem[i][j + 1] = 1;
                                    Point p = new Point(i, j + 1);
                                    map.put(p, 1);
                                }
                            }
                        }
                        else {
                            if (mem[i][j] > 0) {
                                if (j < mem[i].length - 1 && obstacleGrid[i][j] == 0) {
                                    if (obstacleGrid[i][j + 1] == 0) {
                                        Integer current = map.get(new Point(i, j));
                                        Integer next = map.get(new Point(i, j + 1));

                                        mem[i][j + 1] = 1;

                                        map.put(new Point(i, j + 1), next == null ? current : current + next);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return map.get(new Point(mem.length - 1, mem[0].length - 1)) == null ? 0 :
            map.get(new Point(mem.length - 1, mem[0].length - 1));
    }

}
