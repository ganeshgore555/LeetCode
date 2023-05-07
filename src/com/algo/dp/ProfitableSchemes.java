package com.algo.dp;

import java.util.Arrays;

public class ProfitableSchemes {

	public static void main(String[] args) {
    	int n = 100, minProfit = 10;
    	int[] group = {66,24,53,49,86,37,4,70,99,68,14,91,70,71,70,98,48,26,13,86,4,82,1,7,51,37,27,87,2,65,93,66,99,28,17,93,83,91,45,3,59,87,92,62,77,21,9,37,11,4,69,46,70,47,28,40,74,47,12,3,85,16,91,100,39,24,52,50,40,23,64,22,2,15,18,62,26,76,3,60,64,34,45,40,49,11,5,8,40,71,12,60,3,51,31,5,42,52,15,36};
    	int[] profit = {8,4,8,8,9,3,1,6,7,10,1,10,4,9,7,11,5,1,7,4,11,1,5,9,9,5,1,10,0,10,4,1,1,1,6,9,3,6,2,5,4,7,8,5,2,3,0,6,4,5,9,9,10,7,1,8,9,6,0,2,9,2,2,8,6,10,3,4,6,1,10,7,5,4,8,1,8,5,5,4,1,1,10,0,8,0,1,11,5,4,7,9,1,11,1,0,1,6,8,3};
    	System.out.println(new ProfitableSchemes().profitableSchemes(n, minProfit, group, profit));
	}
	/*
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		profitableSchemesDFS(n, minProfit, group, profit, combs, new ArrayList<Integer>(), 0, 0, 0);
		return combs.size();
    }
    
    public void profitableSchemesDFS(int n, int minProfit, int[] group, int[] profit, List<List<Integer>> combs, ArrayList<Integer> comb, int start, int currentTotal, int includedMember) {
    	if(currentTotal >= minProfit) {
    		combs.add(new ArrayList<Integer>(comb));
    	}    	
    	for(int i = start; i < group.length; i++) {
    		if((group[i] + includedMember) <= n) {
    			comb.add(i);
    			profitableSchemesDFS(n, minProfit, group, profit, combs, new ArrayList<Integer>(), i+1, currentTotal + profit[i], includedMember + group[i]);
    			comb.remove(comb.size()-1);    			
    		}
    	}
    }
    */
	
	/*
	long ways = 0;
	
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
		profitableSchemesDFS(n, minProfit, group, profit, 0, 0, 0);
		return (int) (ways % 1000000007);
    }
    
    public void profitableSchemesDFS(int n, int minProfit, int[] group, int[] profit, int start, int currentTotal, int includedMember) {
    	if(currentTotal >= minProfit) {
    		ways++;
    	}    	
    	for(int i = start; i < group.length; i++) {
    		if((group[i] + includedMember) <= n) {
    			profitableSchemesDFS(n, minProfit, group, profit, i+1, currentTotal + profit[i], includedMember + group[i]);
    		}
    	}
    }
	*/
	
	
    int mod = 1000000007;
    int[][][] dp = new int[101][101][101];

    public int profitableSchemesBottomUp(int n, int minProfit, int[] group, int[] profits) {
        // Initializing the base case.
        for (int count = 0; count <= n; count++) {
            dp[group.length][count][minProfit] = 1;
        }

        for (int index = group.length - 1; index >= 0; index--) {
            for (int count = 0; count <= n; count++) {
                for(int profit = 0; profit <= minProfit; profit++) {
                    // Ways to get a profitable scheme without this crime.
                    dp[index][count][profit] = dp[index + 1][count][profit];
                    if (count + group[index] <= n) {
                        // Adding ways to get profitable schemes, including this crime.
                        dp[index][count][profit]
                                = (dp[index][count][profit] + dp[index + 1][count + group[index]][Math.min(minProfit, profit + profits[index])]) % mod;
                    }
                }
            }
        }

        return dp[0][0][0];
    }
    	

	
    //int mod = 1000000007;
    int[][][] memo = new int[101][101][101];    //memo[index][count][profit];

    int find(int pos, int count, int profit, int n, int minProfit, int[] group, int[] profits) {
        if (pos == group.length) {
            // If profit exceeds the minimum required; it's a profitable scheme.
            return profit >= minProfit ? 1 : 0;
        }
        
        if (memo[pos][count][profit] != -1) {
            // Repeated subproblem, return the stored answer.
            return memo[pos][count][profit];
        }
        
        // Ways to get a profitable scheme without this crime.
        int totalWays = find(pos + 1, count, profit, n, minProfit, group, profits);
        if (count + group[pos] <= n) {
            // Adding ways to get profitable schemes, including this crime.
            totalWays += find(pos + 1, count + group[pos], Math.min(minProfit, profit + profits[pos]), n, minProfit, group, profits);
        }
        
        return memo[pos][count][profit] = totalWays % mod;
    }
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // Initializing all states as -1.
        for (int i = 0; i <= group.length; i++) {
            for(int j = 0; j <= n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        return find(0, 0, 0, n, minProfit, group, profit);
    }	
}
