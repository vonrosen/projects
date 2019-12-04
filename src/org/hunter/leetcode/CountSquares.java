package org.hunter.leetcode;

import java.util.Arrays;

public class CountSquares {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
			{ 0, 1, 1, 1 }, 
			{ 1, 1, 1, 1 },
			{ 0, 1, 1, 1 }

		};

		int[][] matrix2 = new int[][] { 
			{ 1, 0, 1 }, 
			{ 1, 1, 0 }, 
			{ 1, 1, 0 } 
		};				
		
		CountSquares s = new CountSquares();
		System.out.println(s.countSquares(matrix));
		System.out.println(s.countSquares(matrix2));
	}

	public int countSquares(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		int [] results = new int[Math.min(matrix.length, matrix[0].length) + 1];
		
		for (int i = 0; i < matrix.length; ++i) {			
			for (int j = 0; j < matrix[i].length; ++j) {
				if (matrix[i][j] == 1) {
					results[1]++;
					
					for (int k = 1; k < matrix.length - i; ++k) {
						boolean isSquare = true;
						
						for (int l = 0; l < k + 1; ++l) {
							for (int m = 0; m < k + 1; ++m) {
								if (i + l < matrix.length && j + m < matrix[0].length) {
									if (matrix[i + l][j + m] == 0) {
										isSquare = false;
										break;
									}										
								}
								else {
									isSquare = false;
									break;
								}
							}
						}
						
						if (isSquare) {
							if (k + 1 < results.length) {
								results[k + 1]++;	
							}							
						}
						else {
							break;
						}
					}					
				}
			}
		}
		
		return Arrays.stream(results).sum();
	}
}
