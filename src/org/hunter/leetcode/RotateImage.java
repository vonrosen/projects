package org.hunter.leetcode;

public class RotateImage {

	public static void main(String [] args) {
//		int [][] matrix = {
//				{1,2,3},
//				{4,5,6},
//				{7,8,9},				
//		};
//		int [][] matrix = {
//				{5, 1, 9,11},
//				{2, 4, 8,10},
//				{13, 3, 6, 7},
//				{15,14,12,16}
//		};
		
		int [][] matrix = new int [][]
				{
					{1,2,3,4,5},
					{6,7,8,9,10},
					{11,12,13,14,15},
					{16,17,18,19,20},
					{21,22,23,24,25}
				};
				
			/*
			 * 
			 * [
			 * [21,16,11,6,1],
			 * [22,17,12,7,2],
			 * [23,18,13,8,3],
			 * [24,19,14,9,4],
			 * [25,20,15,10,5]]
			 */
		
		RotateImage ri = new RotateImage();
		ri.rotate(matrix);

		for (int r = 0; r < matrix.length; ++r) {
			for (int c = 0; c < matrix[r].length; ++c) {
				System.out.print(matrix[r][c]);
				System.out.print(" ");
			}
			System.out.println("");
		}		
	}
	
    public void rotate(int[][] matrix) {
    		if (matrix.length == 0 || matrix[0].length == 0) {
    			return;
    		}
    	
    		int numberRowsToProcess = matrix[0].length / 2;
    		int clength = matrix[0].length;
    		
    		int r = 0;    		
    		while (r < numberRowsToProcess) {
    			int row = r;
    			int col = r;
    			for (int colStart = r, colCtr = 0; colStart < r + clength - 1; ++colStart, ++colCtr) {
    				int from = matrix[row][colStart];
    	    			for (int i = 0; i < 4; ++i) {    				
    	    				if (i == 0) {
    	    					col = r + clength - 1;
    	    					row = colStart;
    	    				}
    	    				else if (i == 1) {
    	    					row = r + clength - 1;
    	    					col = (r + clength - 1) - colCtr;
    	    				}
    	    				else if (i == 2) {
    	    					col = r;
    	    					row = (r + clength - 1) - colCtr;
    	    				}
    	    				else if (i == 3) {
    	    					row = r;
    	    					col = colStart;
    	    				}
    	    				int to = matrix[row][col];
    	    				matrix[row][col] = from;
    	    				from = to;
    	    			}
    	    			row = r;
    			}
    			
    			clength -= 2;
    			++r;
    		}
    }	
	
}
