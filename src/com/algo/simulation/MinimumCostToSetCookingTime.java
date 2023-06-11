package com.algo.simulation;

import java.util.*;

public class MinimumCostToSetCookingTime {

	public static void main(String[] args) {
		int startAt = 1;
		int moveCost = 9403;
		int pushCost = 9402;
		int targetSeconds = 6008;
		System.out.println(new MinimumCostToSetCookingTime().minCostSetTime(startAt, moveCost, pushCost, targetSeconds));
	}

	public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
	    int mins = targetSeconds / 60, secs = targetSeconds % 60;
	    return Math.min(cost(mins, secs, startAt, moveCost, pushCost), 
	                  cost(mins - 1, secs + 60, startAt, moveCost, pushCost));
	}
	private int cost(int mins, int secs, int startAt, int moveCost, int pushCost) {
	    if (mins > 99 || secs > 99 || mins < 0 || secs < 0) return Integer.MAX_VALUE;
	    String s = Integer.toString(mins * 100 + secs); char curr = Integer.toString(startAt).charAt(0);
	    int res = 0;
	    for(int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == curr) res += pushCost;
	        else {
	            res += pushCost + moveCost;
	            curr = s.charAt(i);
	        }
	    }
	    return res;
	}
}
