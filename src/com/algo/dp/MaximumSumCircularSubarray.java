package com.algo.dp;

public class MaximumSumCircularSubarray {

	public static void main(String[] args) {
		int[] nums = {5,-3,5};
		System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(nums));
	}
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0, curMin = 0, sum = 0, maxSum = nums[0], minSum = nums[0];
        for (int num : nums) {
            curMax = Math.max(curMax, 0) + num;
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin, 0) + num;
            minSum = Math.min(minSum, curMin);
            sum += num;  
        }
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
    
    public int maxSubarraySumCircularSpecialSum(int[] nums) {
        final int n = nums.length;
        final int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int suffixSum = nums[n - 1], i = n - 2; i >= 0; --i) {
            suffixSum += nums[i];
            rightMax[i] = Math.max(rightMax[i + 1], suffixSum);
        }
        int maxSum = nums[0];
        int specialSum = nums[0];
        for (int i = 0, prefixSum = 0, curMax = 0; i < n; ++i) {
            curMax = Math.max(curMax, 0) + nums[i];
            // This is Kadane's algorithm.
            maxSum = Math.max(maxSum, curMax);
            prefixSum += nums[i];
            if (i + 1 < n) {
                specialSum = Math.max(specialSum, prefixSum + rightMax[i + 1]);
            }
        }
        return Math.max(maxSum, specialSum);  
    }    
}
