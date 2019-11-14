package org.hunter.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestPathColors {

    public void printArr(int [] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String [] args) {
        ShortestPathColors s = new ShortestPathColors();

//        9
//        [[1,8],[5,7],[1,2],[2,2],[7,4],[7,2],[3,8],[7,0],[1,5],[2,7],[2,3],[6,3],[3,0],[4,8],[7,5],[1,6],[3,7]]
//        [[2,1],[1,4],[0,3],[0,5],[1,5],[8,2],[5,8],[2,6],[5,3],[6,7],[4,0],[2,2]]
        //exp: [0,5,3,1,8,1,5,2,2]

//        5
//        [[2,2],[0,4],[4,2],[4,3],[2,4],[0,0],[0,1],[2,3],[1,3]]
//        [[0,4],[1,0],[1,4],[0,0],[4,0]]
        //e: [0,1,2,2,1]

        int n = 5;
        int[][] red_edges = new int[][] {
            {2, 2},
            {0, 4},
            {4, 2},
            {4, 3},
            {2, 4},
            {0, 0},
            {0, 1},
            {2, 3},
            {1, 3}
        };
        int[][] blue_edges = new int[][] {
            {0, 4},
            {1, 0},
            {1, 4},
            {0, 0},
            {4, 0}
        };

//        int n = 2;
//        int[][] red_edges = new int[][] { };
//        int[][] blue_edges = new int[][] { };

//        int n = 9;
//		int[][] red_edges = new int[][] { { 1, 8 }, { 5, 7 }, { 1, 2 }, { 2, 2 }, { 7, 4 }, { 7, 2 }, { 3, 8 },
//				{ 7, 0 }, { 1, 5 }, { 2, 7 }, { 2, 3 }, { 6, 3 }, { 3, 0 }, { 4, 8 }, { 7, 5 }, { 1, 6 }, { 3, 7 } };
//		int[][] blue_edges = new int[][] { { 2, 1 }, { 1, 4 }, { 0, 3 }, { 0, 5 }, { 1, 5 }, { 8, 2 }, { 5, 8 },
//				{ 2, 6 }, { 5, 3 }, { 6, 7 }, { 4, 0 }, { 2, 2 } };

//        int n = 9;
//        int [][] red_edges = new int[][]
//                  {{2,1},{5,1},{6,4},{1,0},{7,4},{0,8},{7,8},{7,6},{6,8},{3,1},{2,7},{3,6},{8,3},{0,0},{5,0},{8,1},{4,8},{4,7},{8,0},{8,5}};
//        int [][] blue_edges = new int[][]
//                  {{1,5},{2,7},{2,0},{5,2},{8,5},{1,7},{6,1},{1,4},{4,1},{3,6},{8,8},{7,6},{1,1},{6,8},{2,8},{7,7},{7,3},{1,2},{2,6}};

//        [[2,1],[5,1],[6,4],[1,0],[7,4],[0,8],[7,8],[7,6],[6,8],[3,1],[2,7],[3,6],[8,3],[0,0],[5,0],[8,1],[4,8],[4,7],[8,0],[8,5]]
//        [[1,5],[2,7],[2,0],[5,2],[8,5],[1,7],[6,1],[1,4],[4,1],[3,6],[8,8],[7,6],[1,1],[6,8],[2,8],[7,7],[7,3],[1,2],[2,6]]


//        5
//        [[3,2],[4,1],[1,4],[2,4]]
//        [[2,3],[0,4],[4,3],[4,4],[4,0],[1,0]]


//        6
//        [[2,3],[0,5],[3,1],[5,0],[3,0],[0,0]]
//        [[1,2],[3,2],[1,0],[2,2],[5,2]]
        //exp: [0,-1,2,3,-1,1]

//        7
//        [[0,2],[1,3],[1,5],[4,0],[4,2]]
//        [[1,2],[4,3],[3,1],[6,1],[1,5],[6,0],[5,1],[1,4],[6,3],[1,3],[0,1],[2,1]]
        //exp: [0,1,1,2,-1,2,-1]

//        int n = 7;
//        int [][] red_edges = new int[][] {
//            {0, 2},
//            {1, 3},
//            {1, 5},
//            {4, 0},
//            {4, 2}
//        };
//        int [][] blue_edges = new int[][] {
//            {1, 2},
//            {4, 3},
//            {3, 1},
//            {6, 1},
//            {1, 5},
//            {6, 0},
//            {5, 1},
//            {1, 4},
//            {6, 3},
//            {1, 3},
//            {0, 1},
//            {2, 1}
//        };


//      5
//      [[0,1],[1,2],[2,3],[3,4]]
//      [[1,2],[2,3],[3,1]]
      //expected: [0,1,2,3,7]

//                  5
//                  [[3,2],[4,1],[1,4],[2,4]]
//                  [[2,3],[0,4],[4,3],[4,4],[4,0],[1,0]]
                  //exp: [0,2,-1,-1,1]


//        6
//        [[1,5],[2,2],[5,5],[3,0],[4,5],[2,4],[4,1],[1,0],[1,2],[5,2],[2,3],[0,1]]
//        [[4,4],[2,5],[1,1],[5,4],[3,3]]
        //exp: [0,1,3,-1,4,3]


//        int n = 6;
//        int [][] red_edges = new int[][] {
//            {1, 5},
//            {2, 2},
//            {5, 5},
//            {3, 0},
//            {4, 5},
//            {2, 4},
//            {4, 1},
//            {1, 0},
//            {1, 2},
//            {5, 2},
//            {2, 3},
//            {0, 1}
//        };
//        int [][] blue_edges = new int[][] {
//            {4, 4},
//            {2, 5},
//            {1, 1},
//            {5, 4},
//            {3, 3}
//        };


//            int n = 5;
//            int [][] red_edges = new int[][] {
//                {3, 2},
//                {4, 1},
//                {1, 4},
//                {2, 4}
//            };
//            int [][] blue_edges = new int[][] {
//                {2, 3},
//                {0, 4},
//                {4, 3},
//                {4, 4},
//                {4, 0},
//                {1, 0}
//            };

//          int n = 5;
//          int [][] red_edges = new int[][] {
//              {0, 1},
//              {1, 2},
//              {2, 3},
//              {3, 4}
//          };
//          int [][] blue_edges = new int[][] {
//              {1, 2},
//              {2, 3},
//              {3, 1}
//          };

//        int [][] red_edges = new int[][] {
//                {0, 1},
//                {1, 2}
//        };
//        int [][] blue_edges = new int[][] {};

//        int [][] red_edges = new int[][] {
//            {0, 1}
//        };
//        int [][] blue_edges = new int[][] {
//            {1, 2}
//        };

//        int n = 3;
//        int [][] red_edges = new int[][] {
//            {0, 1},
//            {1, 2}
//        };
//        int [][] blue_edges = new int[][] {
//        };
//        int [][] red_edges = new int[][] {
//            {0, 1},
//            {0, 2}
//        };
//        int [][] blue_edges = new int[][] {
//            {1, 0}
//        };

        s.printArr(s.shortestAlternatingPaths(n, red_edges, blue_edges));
    }

    Map<String, Boolean> redGuard = new HashMap<String, Boolean>();
    Map<String, Boolean> blueGuard = new HashMap<String, Boolean>();
    Map<String, Integer> blueCache = new HashMap<String, Integer>();
    Map<String, Integer> redCache = new HashMap<String, Integer>();

    public int getHopsFromRed(int [] edge, int [][] blue_edges, int [][] red_edges, int hops) {
        if (redGuard.get(edge[0] + "-" + edge[1]) != null && redGuard.get(edge[0] + "-" + edge[1])) {
            return -1;
        }

        int redStart = edge[0];

        if (redCache.get(edge[0] + "-" + edge[1]) != null) {
        		int r = redCache.get(edge[0] + "-" + edge[1]);
        		return r > 0 ? r + hops - 1 : r;
        }

        if (redStart == 0) {
            return hops;
        }
        else {
            int result = -1;
            for (int b = 0; b < blue_edges.length; ++b) {
                if (blue_edges[b][1] == redStart) {
                    redGuard.put(edge[0] + "-" + edge[1], true);
                    int tmpResult = getHopsFromBlue(blue_edges[b], blue_edges, red_edges, hops + 1);
                    redGuard.remove(edge[0] + "-" + edge[1]);
                    if (tmpResult > 0) {
                        if (result == -1) {
                            result = tmpResult;
                        }
                        else {
                            result = Math.min(tmpResult, result);
                        }
                    }
                }
            }

            if (edge[0] == 1 && edge[1] == 2) {
            		System.out.println("alsdfj");
            }

            redCache.put(edge[0] + "-" + edge[1], result > 0 ? result - hops + 1	: result);
            return result;
        }
    }

    public int getHopsFromBlue(int [] edge, int [][] blue_edges, int [][] red_edges, int hops) {
        if (blueGuard.get(edge[0] + "-" + edge[1]) != null && blueGuard.get(edge[0] + "-" + edge[1])) {
            return -1;
        }

        if (edge[0] == 6 && edge[1] == 7) {
        		System.out.println("asdfasfsss");
        }

        if (blueCache.get(edge[0] + "-" + edge[1]) != null) {
    			int r = blueCache.get(edge[0] + "-" + edge[1]);
    			return r > 0 ? r + hops - 1 : r;
        }

        int blueStart = edge[0];

        if (blueStart == 0) {
            return hops;
        }
        else {

            int result = -1;
            for (int r = 0; r < red_edges.length; ++r) {
                if (red_edges[r][1] == blueStart) {
                    blueGuard.put(edge[0] + "-" + edge[1], true);
                    int tmpResult = getHopsFromRed(red_edges[r], blue_edges, red_edges, hops + 1);
                    blueGuard.remove(edge[0] + "-" + edge[1]);
                    if (tmpResult > 0) {
                        if (result == -1) {
                            result = tmpResult;
                        }
                        else {
                        		result = Math.min(tmpResult, result);
                        }
                    }
                }
            }

            blueCache.put(edge[0] + "-" + edge[1], result > 0 ? result - hops + 1: result);
            return result;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int [][] red = new int[100][100];
        int [][] blue = new int[100][100];
        int [] results = new int[n];

        if (red_edges.length == 0 && blue_edges.length == 0) {
            for (int i = 0; i < n; ++i) {
                if (i > 0) {
                    results[i] = -1;
                }
            }
        }

        for (int i = 0; i < red_edges.length + blue_edges.length; ++i) {
            //red first graph
            for (int r = 0; r < red_edges.length; ++r) {
                if (red[red_edges[r][0]][red_edges[r][1]] == 0 && red_edges[r][0] == 0) {
                    red[red_edges[r][0]][red_edges[r][1]] = 1;
                }

                for (int rr = 0; rr < red.length; ++rr) {
                    if (red[rr][red_edges[r][0]] > 0 && red[rr][red_edges[r][0]] % 2 == 0) {
                        if (red[red_edges[r][0]][red_edges[r][1]] == 0) {
                            red[red_edges[r][0]][red_edges[r][1]] = red[rr][red_edges[r][0]] + 1;
                        }
                        else {
                            red[red_edges[r][0]][red_edges[r][1]] = Math.max(red[rr][red_edges[r][0]] + 1, red[red_edges[r][0]][red_edges[r][1]]);
                            //red[red_edges[r][0]][red_edges[r][1]] = red[rr][red_edges[r][0]] + 1;
                        }
                    }
                }
            }

            //System.out.println("s " + red[1][2]);


            for (int b = 0; b < blue_edges.length; ++b) {
                for (int r = 0; r < red.length; ++r) {
                    if (red[r][blue_edges[b][0]] > 0 && red[r][blue_edges[b][0]] % 2 != 0) {
                        if (red[blue_edges[b][0]][blue_edges[b][1]] == 0) {
                            red[blue_edges[b][0]][blue_edges[b][1]] = red[r][blue_edges[b][0]] + 1;
                        }
                        else {
                            red[blue_edges[b][0]][blue_edges[b][1]] =
                                    Math.max(red[blue_edges[b][0]][blue_edges[b][1]], red[r][blue_edges[b][0]] + 1);
//                            red[blue_edges[b][0]][blue_edges[b][1]] = red[r][blue_edges[b][0]] + 1;
                        }
                    }
                }
            }

            //blue first graph
            for (int b = 0; b < blue_edges.length; ++b) {
                if (blue[blue_edges[b][0]][blue_edges[b][1]] == 0 && blue_edges[b][0] == 0) {
                    blue[blue_edges[b][0]][blue_edges[b][1]] = 1;
                }

                for (int bb = 0; bb < red.length; ++bb) {
                    if (blue[bb][blue_edges[b][0]] > 0 && blue[bb][blue_edges[b][0]] % 2 == 0) {
                        if (blue[blue_edges[b][0]][blue_edges[b][1]] == 0) {
                            blue[blue_edges[b][0]][blue_edges[b][1]] = blue[bb][blue_edges[b][0]] + 1;
                        }
                        else {
                            blue[blue_edges[b][0]][blue_edges[b][1]] = Math.max(blue[bb][blue_edges[b][0]] + 1, blue[blue_edges[b][0]][blue_edges[b][1]]);
//                            blue[blue_edges[b][0]][blue_edges[b][1]] = blue[bb][blue_edges[b][0]] + 1;
                        }
                    }
                }
            }

            for (int r = 0; r < red_edges.length; ++r) {
                for (int b = 0; b < blue.length; ++b) {
                    if (blue[b][red_edges[r][0]] > 0 && blue[b][red_edges[r][0]] % 2 != 0) {
                        if (blue[red_edges[r][0]][red_edges[r][1]] == 0) {
                            blue[red_edges[r][0]][red_edges[r][1]] = blue[b][red_edges[r][0]] + 1;
                        }
                        else {
                            blue[red_edges[r][0]][red_edges[r][1]] =
                                    Math.max(blue[red_edges[r][0]][red_edges[r][1]], blue[b][red_edges[r][0]] + 1);
//                            blue[red_edges[r][0]][red_edges[r][1]] = blue[b][red_edges[r][0]] + 1;
                        }
                    }
                }
            }

            for (int to = 0; to < n; ++to) {
                if (to == 0) {
                    results[to] = 0;
                    continue;
                }

                if (results[to] > 0) {
                    continue;
                }

                int result = -1;

                for (int j = 0; j < red.length; ++j) {
                    if (red[j][to] > 0) {
                        if (result == -1) {
                            result = red[j][to];
                        }
                        else {
                            result = Math.min(result, red[j][to]);
                        }
                    }
                }

                for (int j = 0; j < blue.length; ++j) {
                    if (blue[j][to] > 0) {
                        if (result == -1) {
                            result = blue[j][to];
                        }
                        else {
                            result = Math.min(result, blue[j][to]);
                        }
                    }
                }

                results[to] = result;
            }
        }


        return results;
    }

    public int[] shortestAlternatingPaths2(int n, int[][] red_edges, int[][] blue_edges) {
        int [] result = new int[n];
        Arrays.fill(result, -1);

        for (int to = 0; to <= n; ++to) {
            if (to == 0) {
                result[to] = 0;
            }
            else {
                for (int r = 0; r < red_edges.length; ++r) {
                    if (to == red_edges[r][1]) {
                        int hops = getHopsFromRed(red_edges[r], blue_edges, red_edges, 1);
                        if (hops > 0) {
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
                    if (to == blue_edges[b][1]) {
                        int hops = getHopsFromBlue(blue_edges[b], blue_edges, red_edges, 1);
                        if (hops > 0) {
                            if (result[to] > 0) {
                                result[to] = Math.min(result[to], hops);
                            }
                            else {
                                result[to] = hops;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
