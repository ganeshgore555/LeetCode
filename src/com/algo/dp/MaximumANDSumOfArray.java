package com.algo.dp;

import java.util.*;

public class MaximumANDSumOfArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		int numSlots = 3;
		System.out.println(new MaximumANDSumOfArray().maximumANDSum(nums, numSlots));
	}

    public int maximumANDSum(int[] nums, int numSlots) {
        int[] slotWt = new int[numSlots+1];
        HashMap<String, Integer> dp = new HashMap<>();
        return helper(0, nums, slotWt, numSlots, dp);
    }
    
    public int helper(int idx, int[] nums, int[] slotWt, int numSlots, HashMap<String, Integer> dp){
        
        if(idx==nums.length) return 0;
        
        String key = idx + "-" + Arrays.toString(slotWt);
        if(dp.containsKey(key)) return dp.get(key);
        
        int maxi = Integer.MIN_VALUE;
        for(int k=1; k<=numSlots; k++){
            if(slotWt[k] < 2){
                slotWt[k]++;
                int ans = (nums[idx] & k) + helper(idx+1, nums, slotWt, numSlots, dp);
                slotWt[k]--;
                maxi = Math.max(maxi, ans);
            }
        }
        
        dp.put(key, maxi);
        return maxi;
    }
}
