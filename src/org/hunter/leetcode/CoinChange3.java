package org.hunter.leetcode;

public class CoinChange3 {
	
	public static void main(String [] args) {
		CoinChange3 c = new CoinChange3();	
		
		System.out.println(c.coinChange(new int [] {1}, 0));
		System.out.println(c.coinChange(new int [] {1,2,5}, 11));
		System.out.println(c.coinChange(new int [] {186,419,83,408}, 6249));
		//System.out.println(c.coinChange(new int [] {1,5}, 6249));
		//System.out.println(c.coinChange(new int [] {1,2}, 33));
		System.out.println(c.coinChange(new int [] {1,2147483647}, 2));
		//System.out.println(c.coinChange(new int [] {474,83,404,3}, 264));
		
		System.out.println(c.coinChange(new int [] {1,2147483647}, 2));		
	}

    public int coinChange(int[] coins, int amount) {
    		if (amount == 0) {
    			return 0;
    		}
    		
    		int [] mem = new int[amount + 1];
    		
    		for (int i = 0; i <= amount; ++i) {
    			for (int c = 0; c < coins.length; ++c) {
    				long coin = coins[c];

    				if (i + coin > amount) {
    					continue;
    				}
    				
    				if (i == 0) {
    					mem[i + coins[c]] = 1;
    				}
    				else {
    					if (mem[i] > 0) {
    						mem[i + coins[c]] = mem[i + coins[c]] > 0 ? Math.min(mem[i + coins[c]], mem[i] + 1) : mem[i] + 1;  
    					}
    				}
    			}
    		}
    		
    		return mem[amount] == 0 ? -1 : mem[amount];
    }
	
}
