package com.algo.prefixsum.array;

import java.util.HashMap;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		int[] arr = {23,2,4,6,7};
		int k = 6;
		System.out.println(new SubarraySumEqualsK().subarraySum(arr, k));
	}
	
    public int subarraySum(int[] nums, int k) {
        int count = 0, currSum = 0;
        HashMap<Integer, Integer> h = new HashMap();
        
        for (int num : nums) {
            // current prefix sum
            currSum += num;
            
            // situation 1:  
            // continuous subarray starts 
            // from the beginning of the array
            if (currSum == k)
                count++;
            
            // situation 2:
            // number of times the (curr_sum-k) has occured already, 
            // determines the number of times a subarray with sum k 
            // has occured upto the current index
            count += h.getOrDefault(currSum - k, 0);
            
            // add the current sum
            h.put(currSum, h.getOrDefault(currSum, 0) + 1);    
        }
                
        return count;
    }

}