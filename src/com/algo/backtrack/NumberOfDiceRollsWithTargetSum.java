package com.algo.backtrack;

import java.util.ArrayList;

public class NumberOfDiceRollsWithTargetSum {

	public static void main(String[] args) {
		int n = 2, k = 6, target = 7;
		System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(n, k, target));
		System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTargetBottonUp(n, k, target));
	}

    final int MOD = 1000000007;
    
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] memo = new Integer[n + 1][target + 1];
        return numRollsToTargetTopDown(memo, 0, n, 0, target, k);
    }
    
    int numRollsToTargetTopDown(Integer[][] memo, int diceIndex, int n, int currSum, int target, int k) {
        // All the n dice are traversed, the sum must be equal to target for valid combination
        if (diceIndex == n) {
            return currSum == target ? 1 : 0;
        }
        
        // We have already calculated the answer so no need to go into recursion
        if (memo[diceIndex][currSum] != null) {
            return memo[diceIndex][currSum];
        }
        
        int ways = 0;
        // Iterate over the possible face value for current dice
        for (int i = 1; i <= Math.min(k, target - currSum); i++) {
            ways = (ways + numRollsToTargetTopDown(memo, diceIndex + 1, n, currSum + i, target, k)) % MOD;
        }
        return memo[diceIndex][currSum] = ways;
    }
    
    public int numRollsToTargetBottonUp(int n, int k, int target) {
        int[][] memo = new int[n + 1][target + 1];
        // Intialize the base case
        memo[n][target] = 1;
        
        for (int diceIndex = n - 1; diceIndex >= 0; diceIndex--) {
            for (int currSum = 0; currSum <= target; currSum++) {
               int ways = 0;
                
                // Iterate over the possible face value for current dice
                for (int i = 1; i <= Math.min(k, target - currSum); i++) {
                    ways = (ways + memo[diceIndex + 1][currSum + i]) % MOD;
                }
                
                memo[diceIndex][currSum] = ways;
            }
        }
        
        return memo[0][0];
    }
}
