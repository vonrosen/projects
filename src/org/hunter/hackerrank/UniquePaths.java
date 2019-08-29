package org.hunter.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniquePaths {

    public static void main(String [] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePaths(3, 2));
//        /System.out.println(u.uniquePaths(7, 3));
    }


    public void printArr(int [][][] mem) {
        System.out.print("BEGIN print array");
        for (int i = 0; i < mem.length; ++i) {
            System.out.println("");
            String leftTab = "";
            for (int j = 0; j < mem[i].length; ++j) {
                System.out.print(leftTab + "i = " + i + " j = " + j + " move is " + mem[i][j][0] + " and path count is " + mem[i][j][1]);
                leftTab += "              ";
            }
        }
        System.out.println("");
        System.out.println("END print array");
    }

    //m=across, n=down
    public int uniquePaths(int m, int n) {

        Map<Map<Integer, Integer>, List<String>> map = new HashMap<Map<Integer, Integer>, List<String>>();

        int [][][] mem = new int[m][n][2];

        for (int i = 0; i < mem.length; ++i) {
            for (int j = 0; j < mem[i].length; ++j) {
                for (int k = 0; k < 2; ++k) {
                    if (k == 0) { //move right
                        if (i == 0 && j == 0) {
                            mem[i + 1][j][0] = 1;
                            mem[i + 1][j][1] = 1;

                            Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
                            mp.put(i + 1, j);
                            List<String> l = new ArrayList<String>();
                            l.add("1");
                            map.put(mp, l);
                        }
                        else {
                            if (mem[i][j][0] > 0) {
                                if (i < mem.length - 1) {
                                    mem[i + 1][j][0] = 1;

                                    if (mem[i + 1][j][1] > 0) {
                                        mem[i + 1][j][1] = mem[i][j][0] == 2 ? mem[i][j][1] + 1 + mem[i + 1][j][1] : mem[i][j][1] + 1;
                                    }
                                    else {
                                        mem[i + 1][j][1] = mem[i][j][0] == 2 ? mem[i][j][1] + 1 : mem[i][j][1];
                                    }
                                }
                            }
                        }
                    }
                    else { //move down
                        if (i == 0 && j == 0) {
                            mem[i][j + 1][0] = 2;
                            mem[i][j + 1][1] = 1;

                            Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
                            mp.put(i, j + 1);
                            List<String> l = new ArrayList<String>();
                            l.add("2");
                            map.put(mp, l);
                        }
                        else {
                            if (mem[i][j][0] > 0) {
                                if (j < mem[i].length - 1) {
                                    mem[i][j + 1][0] = 2;

                                    if (mem[i][j + 1][1] > 0) {
                                        mem[i][j + 1][1] = mem[i][j][0] == 1 ? mem[i][j][1] + 1 + mem[i][j + 1][1] : mem[i][j][1] + 1;
                                    }
                                    else {
                                        mem[i][j + 1][1] = mem[i][j][0] == 1 ? mem[i][j][1] + 1 : mem[i][j][1];
                                    }

                                    Map<Integer, Integer> key = new HashMap<Integer, Integer>();
                                    key.put(i, j);
                                    List<String> paths = map.get(key);
                                    for (String path: paths) {
                                        path
                                    }

                                    map.put(new, value)
                                }
                            }
                        }
                    }
                }

                System.out.println("I = " + i);
                System.out.println("J = " + j);
                printArr(mem);

            }
        }

        return mem[m - 1][n - 1][1];
    }

}
