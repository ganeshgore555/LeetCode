package com.algo.dp;

import java.util.HashMap;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		int[] cost = {10,50,20,10};
		System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));
	}
    public int minCostClimbingStairs(int[] cost) {
    	this.cost = cost;
    	return minCost(cost.length);
    }
    
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] cost;
    
	private int minCost(int n) {
		if(n <= 1)
			return 0;
		
		if(map.get(n) != null)
			return map.get(n);
		
		int result = Math.min((minCost(n-1)+cost[n-1]),(minCost(n-2)+cost[n-2]));
		map.put(n, result);
		return result;
	}
	
    public int minCostClimbingStairsBottomUp(int[] cost) {
        // The array's length should be 1 longer than the length of cost
        // This is because we can treat the "top floor" as a step to reach
        int minimumCost[] = new int[cost.length + 1];
        
        // Start iteration from step 2, since the minimum cost of reaching
        // step 0 and step 1 is 0
        for (int i = 2; i < minimumCost.length; i++) {
            int takeOneStep = minimumCost[i - 1] + cost[i - 1];
            int takeTwoSteps = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(takeOneStep, takeTwoSteps);
        }
        
        // The final element in minimumCost refers to the top floor
        return minimumCost[minimumCost.length - 1];
    }
	
}
