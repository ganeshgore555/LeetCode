package com.algo.graph.bfs;

import java.util.*;


public class ShortestPathInAGridWithObstaclesElimination {

	public static void main(String[] args) {
		int[][] grid = {{0,0,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},{0,1,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},{0,1,0,1,1,1,1,0,0,0},{0,1,0,0,0,0,0,0,1,0},{0,1,1,1,1,1,1,0,1,0},{0,0,0,0,0,0,0,0,1,0}};
		//int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
		//int[][] grid = {{0,1,1},{1,1,1},{1,0,0}};
		int k = 1;
		System.out.println(new ShortestPathInAGridWithObstaclesElimination().shortestPath(grid, k));
	}
	
	//Indexes in data array
	final int row = 0;
	final int col = 1;
	final int remainingK = 2;
	final int steps = 3;
	final int estimate = 4;
	
    public int shortestPath(int[][] grid, int k) {
    	
        int rows = grid.length, cols = grid[0].length;
        int[] target = {rows - 1, cols - 1};

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[estimate] - b[estimate]); // Prioritize based on estimated distance to target, prioritize closest first 
        int[][][] visited = new int[rows][cols][k+1];
        
        int estimateFromStart = target[row] + target[col]; //Manhattan distance for current point + Number of step till now. Which is ((targetRow - startRow i.e 0) + (targetCol - startCol i.e 0)) + steps i.e. 0
        int[] start = {0, 0, k, 0, estimateFromStart}; //row, col, remaining obstacle that can be eliminated, total steps till now, estimated steps to target

        queue.offer(start);
        
        visited[0][0][k] = 1;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            // we can reach the target in the shortest path (Manhattan distance),
            // even if the remaining steps are all obstacles
            int remainMinDistance = curr[estimate] - curr[steps];
            if (remainMinDistance <= curr[remainingK]) {
                return curr[estimate];
            }

            int[][] nextSteps = {{curr[row], curr[col] + 1}, {curr[row], curr[col] - 1}, {curr[row] + 1, curr[col]}, {curr[row] - 1, curr[col]}};

            // explore the four directions in the next step
            for (int i = 0; i < nextSteps.length; i++) {
                int nextRow = nextSteps[i][row];
                int nextCol = nextSteps[i][col];

                // out of the boundary of grid
                if (!isValid(nextRow, nextCol, rows, cols)) {
                    continue;
                }

                int kRemainingInNextState = curr[remainingK] - grid[nextRow][nextCol];
                // add the next move in the queue if it qualifies.
                if (kRemainingInNextState >= 0 && visited[nextRow][nextCol][kRemainingInNextState] != 1) {
                	visited[nextRow][nextCol][kRemainingInNextState] = 1;
                	int estimateFromNewState = ((target[row] - nextRow) + (target[col] - nextCol)) + (curr[steps]+1);
                	int[] newState = {nextRow, nextCol, kRemainingInNextState, curr[steps]+1, estimateFromNewState};
                    queue.offer(newState);
                }
            }
        }

        // did not reach the target
        return -1;
    }

	private boolean isValid(int nextRow, int nextCol, int rows, int cols) {
		if(nextRow >= 0 && nextRow < rows && nextCol >=0 && nextCol < cols) {
			return true;
		}
		return false;
	}
    
}
