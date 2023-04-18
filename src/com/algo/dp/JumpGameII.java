package com.algo.dp;

import java.util.HashMap;

public class JumpGameII {

	public static void main(String[] args) {
		int[] nums1 = {5,9,3,2,1,0,2,3,3,1,0,0};
		int[] nums2 = {1,2,1};
		int[] nums3 = {2,1};
		int[] nums4 = {1,1,1,1};
		System.out.println(new JumpGameII().jump(nums1));
		System.out.println(new JumpGameII().jump(nums2));
		System.out.println(new JumpGameII().jump(nums3));
		System.out.println(new JumpGameII().jump(nums4));

		System.out.println(new JumpGameII().jumpBottomUp(nums1));
		System.out.println(new JumpGameII().jumpBottomUp(nums2));
		System.out.println(new JumpGameII().jumpBottomUp(nums3));
		System.out.println(new JumpGameII().jumpBottomUp(nums4));

	}

	int[] nums;
	HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
	
    public Integer jump(int[] nums) {
    	this.nums = nums;
    	map.put(nums.length-1, 0);
    	return jumpRecursive(0);
    }
	
	private Integer jumpRecursive(int n) {
		if(map.containsKey(n))
			return map.get(n);
		
		if(nums[n] == 0) {
			map.put(n,-1);
			return -1;
		}
					
		int min = Integer.MAX_VALUE;
		
		if(n + nums[n] >= nums.length-1) {
			map.put(n,1);
			return 1;
		}
		
		for(int i = nums[n]; i > 0; i--) {
			 int temp = jumpRecursive(n+i);
			 if(temp == -1)
				 continue;
			 else
				 min = Math.min(min, temp);
		}
		if(min == Integer.MAX_VALUE)
			map.put(n,-1);
		else	
			map.put(n, 1 + min);
		return map.get(n);
	}
	
	
    public Integer jumpBottomUp(int[] nums) {
    	int memo[] = new int[nums.length];
    	memo[nums.length - 1] = 0;
    	
    	if(nums.length == 0)
    		return 0;
    	
    	for(int i = nums.length - 2; i >= 0; i--) {    		
    		int min = Integer.MAX_VALUE;
    		
    		if(nums[i] == 0)
    			memo[i] = -1;
    		else if(i + nums[i] >= nums.length - 1)
    			memo[i] = 1;
    		else {
    			for(int j = i+1; j <= i+nums[i]; j++) {
    				if(memo[j] != -1)
    					min = Math.min(min, memo[j]);
    			}
    			memo[i] = min == Integer.MAX_VALUE ? -1 : 1 + min;
    		}
    	}
		return memo[0];
    }
    
    public int jumpGreedy(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;
        
        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }
        
        return answer;
    }    
}
