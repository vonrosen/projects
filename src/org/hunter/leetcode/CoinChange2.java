package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CoinChange2 {
	
	public static void main(String [] args) {
		CoinChange2 c = new CoinChange2();
		
		c.coinChange(new int [] {3, 2}, 7770);
		//System.out.println(c.coinChange(new int [] {2}, 3));
	}
    
    public int coinChange(int[] coins, int amount) {
    		if (amount == 0) return 0;
    	
    		List<Integer> cs = new ArrayList<Integer>();
    		
    		for (int c : coins) {
    			cs.add(c);
    		}
    		
    		Collections.sort(cs, new Comparator<Integer>() {
    			public int compare(Integer c1, Integer c2) {
    				if (c1 < c2) {
    					return 1;
    				}
    				
    				if (c1 > c2) {
    					return -1;
    				}
    				
    				return 0;
    			}
    		});

    		List<Integer> results = new ArrayList<Integer>();
    		countCoins(cs, amount, 0, results);
    		
    		if (results.stream().filter(item -> item != -1).count() > 0) {
    			System.out.println(results.stream().filter(item -> item != -1).mapToInt(item -> item).min().getAsInt());
    			return results.stream().filter(item -> item != -1).mapToInt(item -> item).min().getAsInt();
    		}
    		else {
    			System.out.println(-1);
    			return -1;
    		}    		
    }

    boolean found = false;

    public void countCoins(List<Integer> coins, int amount, int numberCoins, List<Integer> results) {
    		
    		for (int coin: coins) {
    			if (found) {
    				return;
    			}
    			if (amount == coin) {
    				results.add(numberCoins + 1);
    				found = true;
    			}
    			else if (amount < coin) {    			
    				if (!results.contains(-1)) {
    					results.add(-1);
    				}
    				
    				if (coin == coins.get(coins.size() - 1)) {
    					return;
    				}
    				else {
    					continue;
    				}
    			}
    			else {
    				int remaining = amount - coin;    			
        			countCoins(coins, remaining, numberCoins + 1, results);    				
    			}
    		}
    }

}
