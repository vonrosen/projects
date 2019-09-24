package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTotal {

	public static void main(String [] args) {
		MinTotal m = new MinTotal();
		
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);

		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		triangle.add(l4);
		
		System.out.println(m.minimumTotal(triangle));
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int [][] mem = new int[triangle.size()][];
		
		for (int i = 0; i < triangle.size(); ++i) {
			mem[i] = new int[triangle.get(i).size()];
		}
		
		for (int i = 0; i < triangle.size(); ++i) {
			for (int k = 0; k < triangle.get(i).size(); ++k) {
				if (i == 0) {
					mem[i][k] = triangle.get(i).get(k);
				}
				else {
					if (k == 0) {
						mem[i][k] = triangle.get(i).get(k) + mem[i - 1][k];
					}
					else if (k == triangle.get(i).size() - 1) {
						mem[i][k] = triangle.get(i).get(k) + mem[i - 1][k - 1];
					}
					else {
						mem[i][k] = triangle.get(i).get(k) + Math.min(mem[i - 1][k - 1], mem[i - 1][k]);
					}					
				}
			}
		}

		return Arrays.stream(mem[triangle.size() - 1]).sorted().min().getAsInt();
	}
}
