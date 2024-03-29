package com.algo.dp;

public class UniquePaths {

	public static void main(String[] args) {
		int m = 3, n = 7;
		System.out.println(new UniquePaths().uniquePaths(m, n));
	}

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];                 
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
            	if(i == m-1 && j == n-1)
            		dp[i][j] = 1;
            	else
            		dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
