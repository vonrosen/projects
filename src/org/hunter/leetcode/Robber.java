package org.hunter.leetcode;

import java.util.Arrays;

public class Robber{

	public static void main(String [] args){

		//int [] nums = {1,2,3,1};
		int [] nums = {2,7,9,3,1};

		Robber r = new Robber();
		System.out.println(r.rob(nums));
	}

	public int rob(int[] nums) {
		int [] mem = new int[nums.length];
		Arrays.fill(mem, -1);
		return rob(0, nums, mem);
	}

	public int rob(int start, int [] nums, int [] mem){
		if (start >= nums.length) {
			return 0;
		}

		int max = 0;
		for (int i = start; i < nums.length; ++i){
			int amount;
			if (i + 2 < nums.length && mem[i + 2] != -1){
				 amount = nums[i] + mem[i + 2];
			}
			else {
				amount = nums[i] + rob(i + 2, nums, mem);
			}

			max = Math.max(max, amount);
		}

		mem[start] = max;
		return max;
	}

}
