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
        int max = Integer.MIN_VALUE;

        return max;
    }	
}
