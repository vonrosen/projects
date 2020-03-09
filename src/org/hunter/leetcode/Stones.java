package org.hunter.leetcode;

import java.util.Arrays;

public class Stones {

	public static void main(String[] args) {
		int[] piles = { 5, 3, 4, 5 };

		Stones s = new Stones();
		System.out.println(s.stoneGame(piles));
	}

	public boolean stoneGame(int[] piles) {
		int [] mem = new int[250 * 500];
		int [][] mem2 = new int[250 * 500][2];
		int turns = 0;
		
		while (turns <= piles.length / 2) {
			for (int i = 0; i < mem.length; ++i) {
				if (i == 0) {
					mem[piles[0]] = piles[0];
					mem[piles[piles.length - 1]] = piles[piles.length - 1];
					mem2[piles[0]][0] = i + 1;
					mem2[piles.length - 1][1] = piles.length - 2;
					++turns;
				}
				else {
					if (mem[i] > 0) {
						if (mem2[i][0] > 0) {
							for (int k = mem2[i][0]; k < piles.length; ++k) {
								int value = mem[i] + piles[k];
								mem[value] = value;
								mem2[value][0] = k + 1;
							}
						}
						
						if (mem2[i][1] > 0) {
							for (int k = mem2[i][1]; k > 0; --k) {
								int value = mem[i] + piles[k];
								mem[value] = value;
								mem2[value][1] = k - 1;
							}						
						}
					}
				}			
			}
		}
		
		int max = Arrays.stream(mem).max().getAsInt();
		int sum = Arrays.stream(mem).sum();
		return (max > (sum / 2));
	}

}
