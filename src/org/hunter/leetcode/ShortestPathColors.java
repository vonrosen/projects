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

        
        int n = 6;
        int [][] red_edges = new int[][] {
            {1, 5},
            {2, 2},
            {5, 5},
            {3, 0},
            {4, 5},
            {2, 4},
            {4, 1},
            {1, 0},
            {1, 2},
            {5, 2},
            {2, 3},
            {0, 1}
        };
        int [][] blue_edges = new int[][] {
            {4, 4},
            {2, 5},
            {1, 1},
            {5, 4},
            {3, 3}
        };                  
        
        
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

        if (redStart == 0) {
            return hops;
        }
        else {
            int result = -1;
            for (int b = 0; b < blue_edges.length; ++b) {
                if (blue_edges[b][1] == redStart) {
                		if (blueCache.get(blue_edges[b][0] + "-" + blue_edges[b][1]) != null) {
                			int tmpResult = blueCache.get(blue_edges[b][0] + "-" + blue_edges[b][1]);
    	                    if (tmpResult > 0) {
    	                        if (result == -1) {
    	                            result = tmpResult + hops;
    	                        }
    	                        else {
    	                            result = tmpResult  + hops < result ? tmpResult + hops: result;
    	                        }
    	                    }                			
                		}
                		else {
	                    redGuard.put(edge[0] + "-" + edge[1], true);
	                    int tmpResult = getHopsFromBlue(blue_edges[b], blue_edges, red_edges, hops + 1);
	                    redGuard.remove(edge[0] + "-" + edge[1]);
	                    if (tmpResult > 0) {
	                        if (result == -1) {
	                            result = tmpResult;
	                        }
	                        else {
	                            result = tmpResult < result ? tmpResult : result;
	                        }
	                    }                    
                		}
                }
            }

            redCache.put(edge[0] + "-" + edge[1], result);
            return result;
        }
    }

    public int getHopsFromBlue(int [] edge, int [][] blue_edges, int [][] red_edges, int hops) {
        if (blueGuard.get(edge[0] + "-" + edge[1]) != null && blueGuard.get(edge[0] + "-" + edge[1])) {
            return -1;
        }

        int blueStart = edge[0];

        if (blueStart == 0) {
            return hops;
        }
        else {
            int result = -1;
            for (int r = 0; r < red_edges.length; ++r) {
                if (red_edges[r][1] == blueStart) {
	            		if (redCache.get(red_edges[r][0] + "-" + red_edges[r][1]) != null) {
	            			int tmpResult = redCache.get(red_edges[r][0] + "-" + red_edges[r][1]);
	                    if (tmpResult > 0) {
	                        if (result == -1) {
	                            result = tmpResult + hops;
	                        }
	                        else {
	                            result = tmpResult + hops < result ? tmpResult + hops : result;
	                        }
	                    }                			
	            		}
	            		else {
	                    blueGuard.put(edge[0] + "-" + edge[1], true);
	                    int tmpResult = getHopsFromRed(red_edges[r], blue_edges, red_edges, hops + 1);
	                    blueGuard.remove(edge[0] + "-" + edge[1]);
	                    if (tmpResult > 0) {
	                        if (result == -1) {
	                            result = tmpResult;
	                        }
	                        else {
	                            result = tmpResult < result ? tmpResult : result;
	                        }
	                    }
	            		}
                }
            }

            blueCache.put(edge[0] + "-" + edge[1], result);
            return result;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int [] result = new int[n];
        Arrays.fill(result, -1);

        for (int to = 0; to < n; ++to) {
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
