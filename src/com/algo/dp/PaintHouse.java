package com.algo.dp;

import java.util.HashMap;

public class PaintHouse {

	public static void main(String[] args) {
		int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
		System.out.println(new PaintHouse().minCost(costs));
	}

	int[][] costs; 
	HashMap<String,Integer> map = new HashMap<String, Integer>();
	
    public int minCost(int[][] costs) {
    	this.costs = costs;   
    	return Math.min(minCostRecursive(costs.length-1, 0), Math.min(minCostRecursive(costs.length-1, 1), minCostRecursive(costs.length-1, 2)));
    }

    private int minCostRecursive(int n, int c) {
		if(n < 0)
			return 0;
		
		if(map.containsKey(n+"-"+c))
			return map.get(n+"-"+c);
			
		int current = costs[n][c];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			if(i != c)
				min = Math.min(min,minCostRecursive(n-1, i));
		}
		int result = current + min;
		map.put(n+"-"+c, result);
		return result;
	}
	
	
    public int minCostBottomUp(int[][] costs){
        int[] prev=costs[costs.length-1];
        for(int i=costs.length-2;i>=0;i--){
            int[] curr=costs[i];
            curr[0]+=Math.min(prev[1],prev[2]);
            curr[1]+=Math.min(prev[0],prev[2]);
            curr[2]+=Math.min(prev[0],prev[1]);
            prev=curr;
        }
        return Math.min(prev[0],Math.min(prev[1],prev[2]));
    }
	
}
