package com.ds.medium.main;

public class NumberOfEnclaves {

	public static void main(String[] args) {
		//int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
		int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
		System.out.println(new NumberOfEnclaves().numEnclaves(grid));
	}

    public int numEnclaves(int[][] grid) {
    	int count = 0;
    	for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 1) { 
        			int temp = checkEnclaveByDFS(grid, i, j);
        			if(temp != -1) {
            			count = count + temp;
        			}
        		}
        	}    		
    	}
		return count;
    }
    
    public int checkEnclaveByDFS(int[][] grid, int i, int j) {
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return -1;
        
        if(grid[i][j] != 1) return 0;
    	
        grid[i][j] = 2;
        
        boolean isClosed = true;
        int count = 1;
        
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        
        for(int[] dir : directions) {
        	int temp = checkEnclaveByDFS(grid, i + dir[0], j + dir[1]);
        	if(temp == -1)
        		isClosed = false;
        	else if(temp > 0 )
        		count = count + temp;
        }
                
        return isClosed ? count : -1;
    }    
}
