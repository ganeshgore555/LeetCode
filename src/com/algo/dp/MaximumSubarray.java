package com.algo.dp;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new MaximumSubarray().maxSubArray(nums));
	}
    public int maxSubArray(int[] nums) {
        int prev = nums[0];
        int current = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	if(prev + nums[i] > nums[i])
        		current = prev + nums[i];
        	else
        		current = nums[i];
        	max = Math.max(max, current);
        	prev = current;        	
        }
        return max;
    }
}
