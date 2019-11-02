package org.hunter.leetcode;

public class ShortestPathColors {

    public void printArr(int [] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String [] args) {
        ShortestPathColors s = new ShortestPathColors();

        int n = 3;
        int [][] red_edges = new int[][] {
                {0, 1},
                {1, 2}
        };
        int [][] blue_edges = new int[][] {};

        s.printArr(s.shortestAlternatingPaths(n, red_edges, blue_edges));
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int [] result = new int[n];
        int [][] red_graph = new int[n][n];
        int [][] blue_graph = new int[n][n];

        for (int r = 0; r < red_edges.length; ++r) {
            int start = red_edges[r][0];
            int end = red_edges[r][1];

            if (start == 0) {
                red_graph[start][end] = 1;
            }
        }

        for (int b = 0; b  < blue_edges.length; ++b) {
            int start = blue_edges[b][0];
            int end = blue_edges[b][1];

            if (start == 0) {
                blue_graph[start][end] = 1;
            }
        }

        for (int to = 0; to < n; ++to) {
            if (to == 0) {
                result[to] = 0;
            }
            else {
                for (int hops = 1; hops <= to; ++hops) {
                    for (int r = 0; r < red_edges.length; ++r) {
                        int start = red_edges[r][0];
                        int end = red_edges[r][1];

                        if (to == end && red_graph[start][end] == hops) {
                            result[to] = hops;
                        }
                        else {
                            for (int b = 0; b < blue_graph.length; ++b) {
                                if (blue_graph[b][start] > 0) {
                                    if (red_graph[start][end] > 0) {
                                        red_graph[start][end] = Math.min(blue_graph[b][start] + 1, red_graph[start][end]);
                                    }
                                    else {
                                        red_graph[start][end] = blue_graph[b][start] + 1;
                                    }
                                }
                            }

                            if (red_graph[start][end] == hops) {
                                if (result[to] > 0) {
                                    result[to] = Math.min(result[to], hops);
                                }
                                else {
                                    result[to] = hops;
                                }
                            }
                        }
                    }

                    for (int b = 0; b < blue_edges.length; ++b) {
                        int start = blue_edges[b][0];
                        int end = blue_edges[b][1];

                        if (to == end && blue_graph[start][end] == 0) {
                            blue_graph[start][end] = 1;
                        }
                        else {
                            for (int r = 0; r < red_graph.length; ++r) {
                                if (red_graph[r][start] > 0) {
                                    blue_graph[start][end] = Math.min(red_graph[r][start] + 1, blue_graph[start][end]);
                                }
                            }
                        }

                        if (blue_graph[start][end] == k) {
                            if (result[i] > 0) {
                                result[i] = Math.min(result[i], k);
                            }
                            else {
                                result[i] = k;
                            }
                        }
                    }

                    if (result[i] > 0) {
                        break;
                    }
                }

                if (result[i] == 0) {
                    result[i] = -1;
                }
            }
        }

        return result;
    }
}
