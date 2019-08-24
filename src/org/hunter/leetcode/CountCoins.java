package org.hunter.leetcode;

public class CountCoins {

    public static void main(String [] args) {
        CountCoins c = new CountCoins();
//        System.out.println(c.coinChange(new int [] {1, 2, 5}, 11));
//        System.out.println(c.coinChange(new int [] {2}, 3));
//        System.out.println(c.coinChange(new int [] {2}, 1));
        System.out.println(c.coinChange(new int [] {2}, 4));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int [] mem = new int[amount + 1];

        for (int i = 1; i <= amount; ++i) {
            for (int c = 0; c < coins.length; ++c) {
                if (i == 1) {
                    if (coins[c] <= amount) {
                        mem[coins[c]] = 1;
                    }
                }
                else {
                    if (mem[i] == 0) {
                        if (i - coins[c] < 1) {
                            continue;
                        }
                        else {
                            if (mem[i - coins[c]] > 0) {
                                mem[i] = mem[i - coins[c]] + 1;
                            }
                        }
                    }
                    else {
                        if (i - coins[c] < 1) {
                            continue;
                        }
                        else {
                            if (mem[i - coins[c]] > 0) {
                                mem[i] = mem[i] > mem[i - coins[c]] + 1 ? mem[i - coins[c]] + 1 : mem[i];
                            }
                        }
                    }
                }
            }
        }

        return mem[amount] > 0 ? mem[amount] : -1;
    }

}
