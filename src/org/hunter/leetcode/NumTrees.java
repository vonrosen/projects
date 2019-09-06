package org.hunter.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumTrees {

    public static void main(String [] args) {
        NumTrees n = new NumTrees();
        System.out.println(n.numTrees(1));
        System.out.println(n.numTrees(3));//5
        System.out.println(n.numTrees(4));//14
        System.out.println(n.numTrees(5));//42
        System.out.println(n.numTrees(6));        //132
        System.out.println(n.numTrees(7));        //429
    }

    
    public int numTrees(int n) {
    		int numTrees1 = 1;
    		int numTrees2 = 2;
    		int numTrees3 = 5;
    		
    		if (n == 1) {
    			return numTrees1;		
    		}
    		
    		if (n == 2) {
    			return numTrees2;    		
    		}
    		
    		if (n == 3) {
    			return numTrees3;
    		}
    		
    		int [] nTrees = new int[n + 1];
    		nTrees[0] = 0;
    		nTrees[1] = numTrees1;
    		nTrees[2] = numTrees2;
    		nTrees[3] = numTrees3;
    		
    		int count = 0;
    		for (int i = 4; i <= n; ++i) {
    			count = 0;
        		for (int k = 1; k <= i; ++k) {
        			int left = k - 1;
        			int right = i - k;
        			
        			if (left == 0 || left == 1) {
        				count += nTrees[right];
        			}        			
        			else if (right == 0 || right == 1) {
        				count += nTrees[left];
        			}            			
        			else {
        				count += nTrees[right] * nTrees[left];
        			}        			
        		}
        		
        		nTrees[i] = count;
    		}
    		
    		return nTrees[n];
    }
    
    public int numTrees2(int n) {
        int count = 0;
        Set<Integer> s = new HashSet<Integer>();

        for (int i = 1; i <= n; ++i) {
            s.add(i);
        }

        for (int i = 1; i <= n; ++i) {
            count += c(i, n);
        }

        return count;
    }

    public int c(int i, int n) {
        if (n == 1) {
            return 1;
        }

        if (i == 1 || i == n) {
            return n - 1;
        }

        int count = 1;
        for (int j = 1; j < i; ++j) {
            for (int k = i + 1; k <=n; ++k) {
                count = 1;
                count += cc(j, k, i, n);
            }
        }

        return count;
    }

    public int cc(int left, int right, int i, int n) {

        return 1;


    }

    public int m(int i, int n) {
        if (n == 1) {
            return 1;
        }

        if (i == 1 || i == n) {
            return n - 1;
        }

        int [] mem = new int[n + 1];

        for (int j = 1; j <= n; ++j) {
            if (j == i) {

            }


            if (i < j) {

            }
            else if (i > j) {

            }

            mem[i] = mem[j - 1] + mem[j + 1];



        }

        return mem[i];
    }


    public int n(int i, int n) {
        int [] nodes = new int[2];
        if (i > n) {
            return 0;
        }

        int count = 0;

        for (int j = 1; j <= n; ++j) {
            if (j < i) {
                nodes[0] = 1;
                if (nodes[1] == 0) {
                    count++;
                }

                count += n(j, i - 2);
            }
            else if (j > i) {
                nodes[1] = 1;
                if (nodes[0] == 0) {
                    count++;
                }

                count += n(j + 2, n);
            }
        }

        return count;
    }


}
