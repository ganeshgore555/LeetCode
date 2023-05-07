package com.algo.dp;

public class MaximumLengthOfSubarrayWithPositiveProduct {

	public static void main(String[] args) {
		int[] arr1 = {0,1,-2,-3,-4};
		int[] arr2 = {-1,2};
		System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(arr1));
		System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(arr2));
	}

    public int getMaxLen(int[] nums) {
        int positiveCount = 0, negativeCount = 0;    
        int ans = 0;
        for(int x : nums) {
            if(x == 0)  {
                positiveCount = 0;
                negativeCount = 0;
            }
            else if(x > 0) {
                positiveCount++;
                negativeCount = negativeCount == 0 ? 0  : negativeCount+1;
            }
            else {
                int temp = positiveCount;
                positiveCount = negativeCount == 0 ? 0  : negativeCount+1;
                negativeCount = temp+1;
            }
            ans = Math.max(ans, positiveCount);
        }
        return ans;
    }	
}
