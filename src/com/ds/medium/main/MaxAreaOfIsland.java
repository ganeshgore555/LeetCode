package com.ds.medium.main;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid));
	}

    public static int maxAreaOfIsland(int[][] grid) {
    	int max = 0;
    	int area = 0;
		for(int i = 0; i < grid.length; i++ ) {
			for(int j = 0; j < grid[0].length; j++ ) {
				area = areaByDFS(grid, i, j);
				max = Math.max(area, max);
			}
		}
		return max;
    }
    
    public static int areaByDFS(int[][] grid, int i, int j) {
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 ) return 0;
    	grid[i][j] = 2;
    	return 1 + areaByDFS(grid, i - 1, j) + areaByDFS(grid, i + 1, j) + areaByDFS(grid, i, j - 1) + areaByDFS(grid, i, j + 1);
    }
}
