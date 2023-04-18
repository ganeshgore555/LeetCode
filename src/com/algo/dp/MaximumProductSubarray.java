package com.algo.dp;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] nums1 = {2,3,-2,4};
		int[] nums2 = {-3,-1,-1};
		int[] nums3 = {-2,3,-4};
		int[] nums4 = {0,2};
		System.out.println(new MaximumProductSubarray().maxProduct(nums1));
		System.out.println(new MaximumProductSubarray().maxProduct(nums2));
		System.out.println(new MaximumProductSubarray().maxProduct(nums3));
		System.out.println(new MaximumProductSubarray().maxProduct(nums4));
	}

    public int maxProduct(int[] nums) {
        int prev = nums[0];
        int current = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	if(prev * nums[i] > nums[i])
        		current = prev * nums[i];
        	else
        		current = nums[i];
        	max = Math.max(max, current);
        	prev = current;        	
        }
        
        
        prev = nums[0];
        current = nums[0];
        int maxNormal = nums[0];
        for(int i = 1; i < nums.length; i++) {
    		current = prev * nums[i];
    		maxNormal = Math.max(maxNormal, current);
        	prev = current;        	
        }
        return Math.max(maxNormal, max);
    }	
}
