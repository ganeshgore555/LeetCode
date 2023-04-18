package com.algo.dp;

import java.util.HashMap;

public class JumpGame {

	public static void main(String[] args) {
		int[] nums = {1,0,1};
		System.out.println(new JumpGame().canJump(nums));
	}

	int[] nums;
	HashMap<Integer,Boolean> map = new HashMap<Integer, Boolean>();
	
    public boolean canJump(int[] nums) {
    	this.nums = nums;
    	return canJumpRecursive(0);
    }

	private boolean canJumpRecursive(int n) {
		if(n >= nums.length-1)
			return true;
		
		if(nums[n] == 0)
			return false;
		
		if(map.containsKey(n))
			return map.get(n);
			
		boolean jump = false;
		for(int i = nums[n]; i > 0; i--) {
			 jump = canJumpRecursive(n+i);
			 if(jump)
				 break;
		}
		map.put(n, jump);
		return jump;
	}
	
	enum Index {
	    GOOD, BAD, UNKNOWN
	}
	
    public boolean canJumpBottomUp(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }
    
    public boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }    
}
