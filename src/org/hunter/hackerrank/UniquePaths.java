package org.hunter.hackerrank;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

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

        if (m == 1 && n == 1) {
            return 1;
        }

        Map<Point, Integer> map = new HashMap<Point, Integer>();

        int [][] mem = new int[m][n];

        for (int i = 0; i < mem.length; ++i) {
            for (int j = 0; j < mem[i].length; ++j) {
                for (int k = 0; k < 2; ++k) {
                    if (k == 0) { //move right
                        if (i == 0 && j == 0) {
                            if (i < mem.length - 1) {
                                mem[i + 1][j] = 1;
                                Point p = new Point(i + 1, j);

                                map.put(p, 1);
                            }
                        }
                        else {
                            if (mem[i][j] > 0) {
                                if (i < mem.length - 1) {
                                    Integer current = map.get(new Point(i, j));
                                    Integer next = map.get(new Point(i + 1, j));
                                    mem[i + 1][j] = 1;

                                    map.put(new Point(i + 1, j), next == null ? current : current + next);
                                }
                            }
                        }
                    }
                    else { //move down
                        if (i == 0 && j == 0) {
                            if (j < mem[i].length - 1) {
                                mem[i][j + 1] = 1;
                                Point p = new Point(i, j + 1);
                                map.put(p, 1);
                            }
                        }
                        else {
                            if (mem[i][j] > 0) {
                                if (j < mem[i].length - 1) {
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

        return map.get(new Point(m - 1, n - 1)) == null ? 0 : map.get(new Point(m - 1, n - 1));
    }

}
