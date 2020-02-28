package org.hunter.leetcode;

public class OneThreeTwoPattern {

	public static void main(String [] args) {		
		int [] nums = new int [] {
				1, 2, 3, 4		
		};
		
		int [] nums2 = new int [] {
				3, 1, 4, 2		
		};				

		int [] nums3 = new int [] {
				-1, 3, 2, 0
		};
		int [] nums4 = new int [] {
				1,0,1,-4,-3
		};				
		
		int [] nums5 = new int [] {
				3,5,0,3,4
		};			
		//true
		
		OneThreeTwoPattern p = new OneThreeTwoPattern();
		System.out.println(p.find132pattern(nums));
		System.out.println(p.find132pattern(nums2));
		System.out.println(p.find132pattern(nums3));
		System.out.println(p.find132pattern(nums4));
		System.out.println(p.find132pattern(nums5));
	}
	
    public boolean find132pattern(int[] nums) {
    		 for (int i = 0; i < nums.length; ++i) {
    			 int [] diffs = new int[nums.length - (i + 1)];
    			 
    			 int k = i + 1;
    			 int diffCounter = 0;
    			 if (k < nums.length) {
    				 for (; k < nums.length; ++k) {    					 
    					 diffs[diffCounter] = nums[k] - nums[i];
    					 ++diffCounter;
    				 }
    				 
    				 int maxDiff = diffs[0] > 0 ? diffs[0] : 0;
    				 for (int d = 0; d < diffs.length; ++d) {
    					 if (diffs[d] <= 0) {
    						 continue;
    					 }
    					 
    					 if (diffs[d] < maxDiff) {
    						 return true;
    					 }    					 
    					 
    					 maxDiff = Math.max(diffs[d], maxDiff);
    				 }
    			 }
    		 }
    		 
    		 return false;
    }
	
}
