package com.algo.dp;

import java.util.*;

public class CheckIfThereIsAPathWithEqualNumberOf0sAnd1s {

	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},{0,1,0,0},{1,0,1,0}};
		System.out.println(new CheckIfThereIsAPathWithEqualNumberOf0sAnd1s().isThereAPath(grid));
	}

    public boolean isThereAPath(int[][] grid) {
        Map<String, Boolean> memo = new HashMap<>();
        return isThereAPathDP(grid, 0, 0, 0, memo);
    }
    int[][] dirs = {{0, 1}, {1, 0}};

    private boolean isThereAPathDP(int[][] grid, int r, int c, int sum, Map<String, Boolean> memo) {

        if (r > grid.length - 1 || c > grid[0].length - 1) {
            return false;
        }
        int nextSum = sum + (grid[r][c] == 0 ? -1 : 1);

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return nextSum == 0;
        }
        String key = r + "|" + c + "|" + sum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        boolean ans = false;

        for (int[] dir : dirs) {
            ans = isThereAPathDP(grid, r + dir[0], c + dir[1], nextSum, memo);
            
            if (ans) {
                break;
            }
        }
        memo.put(key, ans);
        return ans;
    }
}
