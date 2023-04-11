package com.algo.graph.dfs;

public class NumberOfClosedIslands {
	public static void main(String[] args) {
		int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
		System.out.println(new NumberOfClosedIslands().closedIsland(grid));
	}
	
	/*
		   0 1 2 3 4 5 6 7
		
		0  1 1 1 1 1 1 1 0
		1  1 0 0 0 0 1 1 0
		2  1 0 1 0 1 1 1 0
		3  1 0 0 0 0 1 0 1
		4  1 1 1 1 1 1 1 0
	 * */
	
    public int closedIsland(int[][] grid) {
    	int count = 0;
    	for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 0 && checkIslandByDFS(grid, i, j)) {
        			count++;
        		}
        	}    		
    	}
		return count;
    }
    
    public boolean checkIslandByDFS(int[][] grid, int i, int j) {
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
        
        if(grid[i][j] != 0) return true;
    	
        grid[i][j] = 2;
        
        boolean isClosed = true;
        
        if(!checkIslandByDFS(grid, i - 1, j))isClosed = false;
        if(!checkIslandByDFS(grid, i + 1, j))isClosed = false;
        if(!checkIslandByDFS(grid, i, j - 1))isClosed = false;
        if(!checkIslandByDFS(grid, i, j + 1))isClosed = false;
        
        return isClosed;
    }
}
