package com.ds.medium.main;

public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		System.out.println(new NumberOfIslands().numIslands(grid));

	}

	public int numIslands(char[][] grid) {
    	int count = 0;
		for(int i = 0; i < grid.length; i++ ) {
			for(int j = 0; j < grid[0].length; j++ ) {
				if(grid[i][j] == '1') {
					count = count + 1;
			    	markIslandByDFS(grid, i, j);
				}
			}
		}
		return count;
	}

    public void markIslandByDFS(char[][] grid, int i, int j) {
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1' ) return;
    	grid[i][j] = '2';
    	markIslandByDFS(grid, i - 1, j);
    	markIslandByDFS(grid, i + 1, j);
    	markIslandByDFS(grid, i, j - 1);
    	markIslandByDFS(grid, i, j + 1);
    }
}
