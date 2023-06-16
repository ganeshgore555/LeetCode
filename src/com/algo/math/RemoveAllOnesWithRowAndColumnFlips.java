package com.algo.math;

public class RemoveAllOnesWithRowAndColumnFlips {

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };
		System.out.println(new RemoveAllOnesWithRowAndColumnFlips().removeOnes(grid));
	}

	public boolean removeOnesMath(int[][] grid) {
		for (int[] g : grid) {
			for (int i = 0; i < g.length; i++) {
				if (Math.abs(g[i] - grid[0][i]) != Math.abs(g[0] - grid[0][0]))
					return false;
			}
		}
		return true;
	}

	public boolean removeOnes(int[][] grid) {
		for (int i = 1; i < grid.length; i++) {
			boolean same = true;
			boolean opposite = true;
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[0][j] != grid[i][j])same = false;
				else opposite = false;
			}
			// If the current row is neither the same, neither the opposite of the first row
			if (!same && !opposite) {
				return false;
			}
		}
		return true;
	}
}
