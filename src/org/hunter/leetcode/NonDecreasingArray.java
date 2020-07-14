package org.hunter.leetcode;

public class NonDecreasingArray {
    public static void main(String[] args) {
        int [] nums = {4,2,3};
        //int [] nums = {4,2,1};
        //int [] nums = {3,4,2,3};
        //int [] nums = {2,3,3,2,4};
        //int [] nums = {1,2,4,5,3};
        //true
        NonDecreasingArray d = new NonDecreasingArray();
        System.out.println(d.checkPossibility(nums));
    }

    public boolean checkPossibility(int[] nums) {
        int n = 0;
        int max = -Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                if (n >= 1) {
                    return false;
                }
                if (nums[i + 1] >= max) {
                    ++n;
                    max = Math.max(max, nums[i + 1]);
                }
                else if (i + 2 < nums.length && nums[i] <= nums[i + 2]) {
                    ++n;
                    max = Math.max(max, nums[i + 2]);
                }
                else if (i == nums.length - 2) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                max = Math.max(max, nums[i]);
            }

        }
        return n <= 1;
    }

}
