package com.algo.dp;

import java.util.HashMap;

public class HouseRobberII {

	public static void main(String[] args) {
		int[] nums = {2,3,2};
		System.out.println(new HouseRobberII().rob(nums));
	}
	
	int[] nums;
	HashMap<String,Integer> map = new HashMap<>();
	
	public int rob(int[] nums) {
		this.nums = nums;
		
		if(nums.length == 1)
			return nums[0];
		
		return Math.max(robRecursive(nums.length-1, true),robRecursive(nums.length-2, false));
	}

	private int robRecursive(int n, boolean last) {
		if(n < 0)
			return 0;
		
		if(n == 0 && last)
			return 0;
		
		String key = n+""+last;
		if(map.containsKey(key))
			return map.get(key);
		
		map.put(key, Math.max(robRecursive(n - 2, last) + nums[n], robRecursive(n - 1, last)));
		return map.get(key);
	}
}
