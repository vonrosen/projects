package org.hunter.leetcode;

public class TwoSum{

	public static void main(String [] args) {
		int [] nums = {2, 7, 11, 15};
		int target = 9;

		TwoSum t = new TwoSum();
		t.printArr(t.twoSum(nums, target));
	}

	public void printArr(int [] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i]);
		}
	}

	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; ++i) {
			for (int k = i + 1; k < nums.length; ++k) {
				if (nums[i] + nums[k] == target) {
					return new int [] { i, k };
				}
			}
		}

		//should never happen
		return new int [] { -1, -1 };
	}

}
