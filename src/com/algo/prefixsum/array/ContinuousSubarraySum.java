package com.algo.prefixsum.array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

	public static void main(String[] args) {
		int[] arr = {23,2,4,6,7};
		int k = 6;
		System.out.println(new ContinuousSubarraySum().checkSubarraySum(arr, k));
	}

    public boolean checkSubarraySum(int[] nums, int k) {
        // initialize the hash map with index 0 for sum 0
        Map<Integer, Integer> hashMap = new HashMap<>(Map.of(0, 0));
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // if the remainder sum % k occurs for the first time
            Integer mod = sum % k;
            if (!hashMap.containsKey(mod))
                hashMap.put(mod, i + 1);
            // if the subarray size is at least two
            else if (hashMap.get(mod) < i)
                return true;
        }
        return false;
    }
}
