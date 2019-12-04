package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
	
	public static void main(String [] args) {
		CoinChange c = new CoinChange();

		/*
		 * [186,419,83,408]
6249

[186,419,83,408]
6249

[1,2147483647]
2


[474,83,404,3]
264
		 */
		
		//System.out.println(c.coinChange(new int [] {1, 2}, 10));
		//System.out.println(c.coinChange(new int [] {1,2,5}, 11));
		//System.out.println(c.coinChange(new int [] {186,419,83,408}, 6249));
		//System.out.println(c.coinChange(new int [] {1,5}, 6249));
		//System.out.println(c.coinChange(new int [] {1,2}, 33));
		//System.out.println(c.coinChange(new int [] {1,2147483647}, 2));
		System.out.println(c.coinChange(new int [] {474,83,404,3}, 264));
		
		//System.out.println(c.coinChange(new int [] {1,2147483647}, 2));		
	}

    public int coinChange(int[] coins, int amount) {
    		if (amount == 0) return 0;
    		
    		Arrays.sort(coins);
    		
    		int [] mem = new int[amount + 1];
    		
    		for (int i = 0; i <= amount; ++i) {
    			for (int coin : coins) {
    				if (i == 0 || mem[i] > 0) {
    					
    					if (coin > amount) {
    						break;
    					}
    					
    					int index = i + coin;

    					if (index <= amount) {
    						mem[index] = mem[i] == 0 ? i + 1 : mem[index] > 0 ? Math.min(mem[i] + 1, mem[index]) : mem[i] + 1;	
    					}
    				}
    			}    			
    		}
    		
    		return mem[amount] == 0 ? -1 : mem[amount];
    }
	
}
