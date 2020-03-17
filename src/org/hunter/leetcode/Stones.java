package org.hunter.leetcode;

import java.util.Arrays;

public class Stones {

	public static void main(String[] args) {
		int[] piles = { 5, 3, 4, 5 };
//		int[] piles = { 3, 4, 5 };
//		int[] piles = { 4, 5 };

		Stones s = new Stones();
		System.out.println(s.stoneGame(piles));
	}

	public boolean stoneGame(int[] piles) {
		if (piles.length == 2) {
			return Math.max(piles[0], piles[1]) > (Arrays.stream(piles).sum() / 2);
		}		
		
		int [][] mem = new int[piles.length][piles.length];
		int max = max(piles, mem, true, 0, piles.length - 1);		
		return max > (Arrays.stream(piles).sum() / 2);
	}
	
	public int max(int [] piles, int [][] mem, boolean turn, int start, int end) {
		if (mem[start][end] > 0) {
			return mem[start][end];
		}
		
		if (end - 1 == start) {
			int value = 0;
			if (turn) {
				value = Math.max(piles[start], piles[end]);
				mem[start][end] = value;
			}
			else {
				value = Math.min(piles[start], piles[end]);
				mem[start][end] = value;
			}
			
			return value;
		}				
		
		int max1 = piles[start] + max(piles, mem, !turn, start + 1, end);
		int max2 = piles[end] + max(piles, mem, !turn, start, end - 1);
		mem[start][end] = Math.max(max1, max2);
		return mem[start][end]; 
	}	
}
