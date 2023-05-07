package com.algo.dp;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] nums1 = {2,3,-2,4,4,5,-1,0,2,3,-1,5,-3,5,6,-1};
		int[] nums2 = {-3,-1,-1};
		int[] nums3 = {-2,3,-4};
		int[] nums4 = {0,2};
		System.out.println(new MaximumProductSubarray().maxProduct(nums1));
		System.out.println(new MaximumProductSubarray().maxProduct(nums2));
		System.out.println(new MaximumProductSubarray().maxProduct(nums3));
		System.out.println(new MaximumProductSubarray().maxProduct(nums4));
	}

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }
}
