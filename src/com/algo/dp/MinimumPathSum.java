package com.algo.dp;

import java.util.*;

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(new MinimumPathSum().minPathSum(grid));
	}

	int[][] memo;
	
    public int minPathSum(int[][] grid) {
    	memo = new int[grid.length+1][grid[0].length+1];
        return minPathSumDP(grid, 0, 0);
    }

	private int minPathSumDP(int[][] grid, int r, int c) {
		if(r > grid.length-1 || c > grid[0].length-1)
			return Integer.MAX_VALUE;
		
		if(r == grid.length-1 && c == grid[0].length-1)
			return grid[r][c];
		
		if(memo[r][c] != 0)
			return memo[r][c];
		
		return memo[r][c] = grid[r][c] + Math.min(minPathSumDP(grid, r+1, c), minPathSumDP(grid, r, c+1));
	}         
}
