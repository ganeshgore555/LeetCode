package com.algo.dp;

import java.util.HashMap;

public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 45;
		System.out.println(new ClimbingStairs().climbStairs(n));
	}

	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	
    public int climbStairs(int n) {    	
        if(n == 1) {
        	return 1;
        }else if(n == 2) {
        	return 2;
        }
        int result = (map.get(n-1) != null ?  map.get(n-1) : climbStairs(n-1)) + (map.get(n-2) != null ?  map.get(n-2) : climbStairs(n-2));
        map.put(n, result);
        return result;
    }
}
