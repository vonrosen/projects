package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinCost {

    public static void main(String [] args) {
        MinCost m = new MinCost();
//        System.out.println(m.mincostTickets(new int [] {1,4,6,7,8,20} , new int [] {2,7,15}));
//        System.out.println(m.mincostTickets(new int [] {1,2,3,4,5,6,7,8,9,10,30,31} , new int [] {2,7,15}));
//        System.out.println(m.mincostTickets(new int [] {1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20,21,24,25,27,28,29,30,31,34,37,38,39,41,43,44,45,47,48,49,54,57,60,62,63,66,69,70,72,74,76,78,80,81,82,83,84,85,88,89,91,93,94,97,99}, new int [] {9,38,134}));
//        System.out.println(m.mincostTickets(new int [] {1,4,6,7,8,365} , new int [] {2,7,15}));//11
//        System.out.println(m.mincostTickets(new int [] {1,3,7} , new int [] {1,4,20}));
//        System.out.println(m.mincostTickets(new int [] {1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28},
//                new int [] {3,13,45})); //44
//        System.out.println(m.mincostTickets(new int [] {1,4,6,7,8,20} , new int [] {7,2,15})); //6
//        System.out.println(m.mincostTickets(new int [] {1,5,8,9,10,12,13,16,17,18,19,20,23,24,29} ,
//                new int [] {3,12,54})); //39
//        System.out.println(m.mincostTickets(new int [] {1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29} ,
//                new int [] {3,14,50})); //50
        System.out.println(m.mincostTickets(new int [] {1,2,4,5,6,9,10,12,14,15,18,20,21,22,23,24,25,26,28} ,
                new int [] {3,13,57})); //45


    }

    static class Node {
        int dayPurchased;
        int totalCost;
        int type;
        Node one;
        Node seven;
        Node thirty;

        @Override
        public String toString() {
            return "Day purchased: " + dayPurchased + " Type: " + type + " Total cost: " + totalCost;
        }
    }

    public int mincostTickets(int[] days, int[] costs) {
    		int [] mem = new int[466];

    		if (days.length == 1) {
    			return costs[0];
    		}

    		int last = 0;
    		int lastDay = days[days.length -1];
    		for (int i = 1; i <= lastDay; ++i) {
    		    int day = i;

    		    boolean atDay = false;
    		    for (int d = 0; d < days.length; ++d) {
    		        if (days[d] == day) {
    		            atDay = true;
    		            break;
    		        }
    		    }

    			for (int j = 0; j < costs.length; ++j) {
    				if (j == 0) {
                        if (mem[day] == 0) {
                            mem[day] = mem[last] + costs[j];
                        }
                        else {
                            mem[day] = mem[day] < mem[last] + costs[j] ? mem[day] : mem[last] + costs[j];
                            mem[day + 1] = mem[day + 1] < mem[day] + costs[j] ? mem[day + 1] : mem[day] + costs[j];
                        }
    				}

    				if (j == 1) {
                        if (mem[day + 6] == 0) {
                            mem[day + 6] = mem[last] + costs[j];
                        }
                        else {
                            mem[day] = mem[day] < mem[last] + costs[j] ? mem[day] : mem[last] + costs[j];
                            mem[day + 6] = mem[day + 6] < mem[day] + costs[j] ? mem[day + 6] : mem[day] + costs[j];
                        }
    				}

    				if (j == 2) {
                        if (mem[day + 29] == 0) {
                            mem[day + 29] = mem[last] + costs[j];
                        }
                        else {
                            mem[day] = mem[day] < mem[last] + costs[j] ? mem[day] : mem[last] + costs[j];
                            mem[day + 29] = mem[day + 29] < mem[day] + costs[j] ? mem[day + 29] : mem[day] + costs[j];
                        }
    				}
    			}


    			if (atDay) {
                    last = day;

                    if (mem[day + 6] < mem[last]) {
                        last = day + 6;
                    }

                    if (mem[day + 29] < mem[last]) {
                        last = day + 29;
                    }

                    if (i == days[days.length - 1]) {
                        break;
                    }
    			}
    		}

//    		return mem[days[days.length - 1]];

    		int min = mem[last];
    		for (int i = last; i < 400; ++i) {
    		    if (mem[i] > 0) {
    		        min = min > mem[i] ? mem[i] : min;
    		    }
    		}

    		return min;
    }

    public int mincostTickets2(int[] days, int[] costs) {
        Node root = new Node();
        root.type = 1;

        for (int day : days) {
            List<Node> leafs = new ArrayList<Node>();
            getLeafs(root, leafs);

            for (Node leaf: leafs) {
                if (leaf.type == 1 && leaf.dayPurchased + 1 <= day) {
                    if (leaf.one == null) {
                        leaf.one = new Node();
                        leaf.one.type = 1;
                        leaf.one.dayPurchased = day;
                        leaf.one.totalCost = leaf.totalCost + costs[0];
                    }

                    if (leaf.seven == null) {
                        leaf.seven = new Node();
                        leaf.seven.type = 7;
                        leaf.seven.dayPurchased = day;
                        leaf.seven.totalCost = leaf.totalCost + costs[1];
                    }

                    if (leaf.thirty == null) {
                        leaf.thirty = new Node();
                        leaf.thirty.type = 30;
                        leaf.thirty.dayPurchased = day;
                        leaf.thirty.totalCost = leaf.totalCost + costs[2];
                    }
                }

                if (leaf.type == 7 && leaf.dayPurchased + 7 <= day) {
                    if (leaf.one == null) {
                        leaf.one = new Node();
                        leaf.one.type = 1;
                        leaf.one.dayPurchased = day;
                        leaf.one.totalCost = leaf.totalCost + costs[0];
                    }

                    if (leaf.seven == null) {
                        leaf.seven = new Node();
                        leaf.seven.type = 7;
                        leaf.seven.dayPurchased = day;
                        leaf.seven.totalCost = leaf.totalCost + costs[1];
                    }

                    if (leaf.thirty == null) {
                        leaf.thirty = new Node();
                        leaf.thirty.type = 30;
                        leaf.thirty.dayPurchased = day;
                        leaf.thirty.totalCost = leaf.totalCost + costs[2];
                    }
                }

                if (leaf.type == 30 && leaf.dayPurchased + 30 <= day) {
                    if (leaf.one == null) {
                        leaf.one = new Node();
                        leaf.one.type = 1;
                        leaf.one.dayPurchased = day;
                        leaf.one.totalCost = leaf.totalCost + costs[0];
                    }

                    if (leaf.seven == null) {
                        leaf.seven = new Node();
                        leaf.seven.type = 7;
                        leaf.seven.dayPurchased = day;
                        leaf.seven.totalCost = leaf.totalCost + costs[1];
                    }

                    if (leaf.thirty == null) {
                        leaf.thirty = new Node();
                        leaf.thirty.type = 30;
                        leaf.thirty.dayPurchased = day;
                        leaf.thirty.totalCost = leaf.totalCost + costs[2];
                    }
                }
            }
        }

        return getMinCost(root);
    }

    private int getMinCost(Node node) {
        List<Node> leafs = new ArrayList<Node>();

        getLeafsForCost(node, leafs);

        int minCost = 0;
        for (Node leaf : leafs) {
            if (minCost == 0) {
                minCost = leaf.totalCost;
            }
            else {
                minCost = leaf.totalCost < minCost ? leaf.totalCost : minCost;
            }
        }

        return minCost;
    }

    private void getLeafsForCost(Node node, List<Node> leafs) {
        if (node == null) {
            return;
        }

        if (node.one == null && node.seven == null && node.thirty == null) {
            leafs.add(node);
        }

        getLeafsForCost(node.one, leafs);
        getLeafsForCost(node.seven, leafs);
        getLeafsForCost(node.thirty, leafs);
    }

    void getLeafs(Node node, List<Node> leafs) {
        if (node == null) {
            return;
        }

        if (node.one == null || node.seven == null || node.thirty == null) {
            leafs.add(node);
        }

        getLeafs(node.one, leafs);
        getLeafs(node.seven, leafs);
        getLeafs(node.thirty, leafs);
    }
}
