package org.hunter.leetcode;

public class StoneGame2 {
	public static void main(String [] args) {
//		int [] piles = new int[] {2,7,9,4,4};
//		int [] piles = new int[] {2,7,5};
//		int [] piles = new int [] {1,5,7,9,9};
		int [] piles = new int [] { 8270,7145,575,5156,5126,2905,8793,7817,5532,5726,7071,7730,5200,5369,5763,7148,8287,9449,7567,4850,1385,2135,1737,9511,8065,7063,8023,7729,7084,8407 };
		//exp = 17
		
		StoneGame2 s = new StoneGame2();
		System.out.println(s.stoneGameII(piles));		
	}
	
	 public int stoneGameII(int[] piles) {
		 int [][][][] mem = new int[100][100][100][3];
		 int M = 1;		 
		 int [] indices = sum(0, M, mem, 0, piles);
		 return mem[0][indices[0]][indices[1]][0];
	 }
	 
	 public int [] sum(int s, int M, int [][][][] mem, int turn, int [] piles) {
		 if (s > piles.length - 1) {
			 return new int [] { 0, 0 };
		 }		 
		 int maxM = 2 * M;
		 int maxSum = 0;
		 int [] optMOpponentFinal = new int[2];
		 int [] optM = new int[2];		 
		 for (int m = 1; m <= maxM; ++m) {			 
			 if (mem[turn][s][s + m][0] > 0) {
				 int totalSum = mem[turn][s][s + m][0];
				 if (totalSum > maxSum) {
					 maxSum = totalSum;
					 optMOpponentFinal = new int [] { mem[turn][s][s + m][1], mem[turn][s][s + m][2] };
					 optM = new int[] { s, s + m };
				 }				 
				 continue;
			 }
			 int sum = 0;
			 for (int t = 0; t < m; ++t) {
				 if (s + t > piles.length - 1) {
					 break;
				 }
				 sum += piles[s + t];
			 }				 
			 int [] optMOpponent = sum(s + m, Math.max(m, M), mem, turn + 1, piles);
			 int totalSum = sum + mem[turn + 2][mem[turn + 1][optMOpponent[0]][optMOpponent[1]][1]][mem[turn + 1][optMOpponent[0]][optMOpponent[1]][2]][0];
			 if (totalSum > maxSum) {
				 maxSum = totalSum;
				 optMOpponentFinal = optMOpponent;
				 optM = new int[] { s, s + m };
			 }			 			 
		 }		 
		 mem[turn][optM[0]][optM[1]][0] = maxSum;
		 mem[turn][optM[0]][optM[1]][1] = optMOpponentFinal[0];
		 mem[turn][optM[0]][optM[1]][2] = optMOpponentFinal[1];
		 return optM;
	 }	 
}
