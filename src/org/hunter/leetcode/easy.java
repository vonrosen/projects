package org.hunter.leetcode;

import java.util.*;

class easy {

	public static void main(String [] args) {

		int [] arr = new int [] {
			4,3,2,7,8,2,3,1
		};		

		easy e = new easy();
		System.out.println(e.findDisappearedNumbers(arr));
	}

    public List<Integer> findDisappearedNumbers(int[] nums) {

	int [] n = new int [] {
		1,2,3,4,5,6,7,8,9
	};

	for (int i = 0; i < nums.length; ++i) {
		n[nums[i]-1] = -1;
	}

	return Arrays.asList(Arrays.stream(n).filter(i -> i != -1).boxed().toArray(Integer[]::new));
    }
}
