package org.hunter.leetcode;

public class ShortestAltPath {

	public static void main(String [] args) {
		ShortestAltPath s = new ShortestAltPath();

		int n = 3;
		int [][] red = new int[][]
			{
				{0, 1}
			};
		int [][] blue = new int[][]
			{
				{1, 2}
			};
		System.out.println(s.shortestAlternatingPaths(n, red, blue));
	}

	public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
       		return new int[0]; 
    	}
}
