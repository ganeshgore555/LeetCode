package com.algo.graph.bfs;

import java.util.LinkedList;

public class RottingOranges {

	public static void main(String[] args) {
		int[][] mat = {{2,1,1},{0,1,1},{1,0,1}};
    	int rows = mat.length;
    	int cols = mat[0].length;
		System.out.println(new RottingOranges().orangesRotting(mat));
	}

    public int orangesRotting(int[][] grid) {
    	int rows = grid.length;
    	int cols = grid[0].length;
    	
    	LinkedList<int[]> queue =  new LinkedList<>();
    	boolean[][] visited = new boolean[rows][cols];
    	
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == 0) {
					visited[i][j] = true;
				}else if((grid[i][j] == 2)) {
					grid[i][j] = -1;
					queue.offer(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int max = 0;
        while(!queue.isEmpty()) {
        	int[] cell = queue.poll();
	        for(int[] dir : dirs) {
	        	int row = cell[0] + dir[0];
	        	int col = cell[1] + dir[1];
	        	
                if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
                    continue;
                }
                
                queue.offer(new int[] {row,col});
                visited[row][col]=true;
                grid[row][col] = (grid[cell[0]][cell[1]] == -1 ? 0 : grid[cell[0]][cell[1]]) + 1;
                if(grid[row][col] > max) {
                	max = grid[row][col];
                }
	        }
        }
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(visited[i][j] == false) {
					max = -1;
					break;
				}
			}
		}
		return max;
    }
}
