package com.algo.dp;

public class UniquePathsII {

	public static void main(String[] args) {
		int [][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
	}

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        if(obstacleGrid[m-1][n-1] == 1)
        	return 0;
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
            	if(i == m-1 && j == n-1)
            		dp[i][j] = 1;
            	else if(obstacleGrid[i][j] != 1)
            		dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
