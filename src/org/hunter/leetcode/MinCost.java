package org.hunter.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinCost {

    public static void main(String [] args) {
        MinCost m = new MinCost();
        System.out.println(m.mincostTickets(new int [] {1,4,6,7,8,20} , new int [] {2,7,15}));
    }

    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer, Integer> dayToCost = new HashMap<Integer, Integer>();

        for (int day : days) {
            for (int i = 0; i < costs.length; ++i) {
                if (dayToCost.get(day) == null) {
                    if (i == 0) {
                        dayToCost.put(day + 1, costs[i]);
                    }
                    else if (i == 1) {

                    }
                    else {

                    }
                }


            }
        }

    }
}
