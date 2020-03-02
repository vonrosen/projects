package org.hunter.leetcode;

public class MatrixBlockSum {

	public static void main(String [] args) {
//		int [][] mat = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
//		int K = 1;
		int [][] mat = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int K = 2;		
		
		MatrixBlockSum m = new MatrixBlockSum();
		m.printArr(m.matrixBlockSum(mat, K));
	}
	
	private void printArr(int [][] arr) {
		for (int i = 0; i < arr.length; ++i) {
			for (int k = 0; k < arr[i].length; ++k) {
				System.out.print(arr[i][k]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	public int[][] matrixBlockSum(int[][] mat, int K) {
		if (mat.length == 0 || mat[0].length == 0) {
			return new int [][] {{}};
		}
		int i = 0, j;
		int [][] ans = new int[mat.length][mat[0].length];	
		while (i < mat.length) {
			j = 0;
			while (j < mat[0].length) {
				int sum = 0;
				for (int r = i - K; r <= i + K;  r++) {
					for (int c = j - K; c <= j + K; ++c) {
						if (r >= 0 && r < mat.length) {
							if (c >= 0 && c < mat[0].length) {
								sum += mat[r][c];
							}
						}										
					}
				}
				ans[i][j] = sum;
				++j;
				if (j >= mat[0].length) {
					break;
				}
			}
			++i;
			if (i >= mat.length) {
				break;
			}
		}
		
		return ans;
    }	
}
