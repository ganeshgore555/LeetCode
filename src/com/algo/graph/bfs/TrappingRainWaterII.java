package com.algo.graph.bfs;

import java.util.*;

public class TrappingRainWaterII {

	public static void main(String[] args) {
		int[][] heightMap = { { 1, 4, 3, 1, 3, 2 },
							  { 3, 2, 1, 3, 2, 4 },
							  { 2, 3, 3, 2, 3, 1 } };
		System.out.println(new TrappingRainWaterII().trapRainWater(heightMap));
	}

	public int trapRainWater(int[][] heights) {
		if (heights == null || heights.length == 0 || heights[0].length == 0)
			return 0;

		// each cell is represented as {row, col, height}
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[2]-b[2]);

		int m = heights.length;
		int n = heights[0].length;
		boolean[][] visited = new boolean[m][n];

		// Initially, add all the Cells which are on borders to the queue.
		for (int i = 0; i < m; i++) {
			visited[i][0] = true;
			visited[i][n - 1] = true;
			int[] cell1 = {i, 0, heights[i][0]};			
			queue.offer(cell1);
			int[] cell2 = {i, n - 1, heights[i][n - 1]};
			queue.offer(cell2);
		}

		for (int i = 0; i < n; i++) {
			visited[0][i] = true;
			visited[m - 1][i] = true;
			int[] cell1 = {0, i, heights[0][i]};
			queue.offer(cell1);
			int[] cell2 = {m - 1, i, heights[m - 1][i]};
			queue.offer(cell2);
		}

		// from the borders, pick the shortest cell visited and check its neighbors:
		// if the neighbor is shorter, collect the water it can trap and update its
		// height as its height plus the water trapped
		// add all its neighbors to the queue.
		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int res = 0;
		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			for (int[] dir : dirs) {
				int row = cell[0] + dir[0];
				int col = cell[1] + dir[1];
				if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
					visited[row][col] = true;
					res += Math.max(0, cell[2] - heights[row][col]);
					int[] nextCell = {row, col, Math.max(heights[row][col], cell[2])};
					queue.offer(nextCell);
				}
			}
		}

		return res;
	}
}
