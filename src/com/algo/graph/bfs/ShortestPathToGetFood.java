package com.algo.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;

public class ShortestPathToGetFood {

	public static void main(String[] args) {
		char[][] grid = {{'X','X','X','X','X','X','X','X'},{'X','*','O','X','O','#','O','X'},{'X','O','O','X','O','O','X','X'},{'X','O','O','O','O','#','O','X'},{'X','X','X','X','X','X','X','X'}};
		//char[][] grid = {{'X','X','X','X','X'},{'X','*','X','O','X'},{'X','O','X','#','X'},{'X','X','X','X','X'}};
		System.out.println(new ShortestPathToGetFood().getFood(grid));
	}
	
	int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
	int rows = 0;
	int cols = 0;
	
    public int getFood(char[][] grid) {
    	rows = grid.length;
    	cols = grid[0].length;
    	LinkedList<int[]> queue = new LinkedList();
    	int[][] visited = new int[rows][cols];
    	for(int m = 0; m < rows; m++) {
    		for(int n = 0; n < cols; n++) {
    			if(grid[m][n] == '*') {
    				int[] start = {m,n,0};
    				queue.push(start);
    			}
    		}
    		if(!queue.isEmpty())
    			break;
    	}
    	
    	while(!queue.isEmpty()) {
    		int[] pos = queue.poll();
    		
    		if(grid[pos[0]][pos[1]] == '#') {
    			return pos[2];
    		}
    		
			if(visited[pos[0]][pos[1]] == 1) {
				continue;
			}else {
				visited[pos[0]][pos[1]] = 1;
	    		for(int[] dir : dirs) {
	    			int nextRow = pos[0] + dir[0];
	    			int nextCol = pos[1] + dir[1];
	    			if(isValid(nextRow,nextCol)){
	    				if(grid[nextRow][nextCol] != 'X') {
    						int[] nextStep = {nextRow,nextCol,pos[2]+1};
    						queue.offer(nextStep);
	    				}
	    			}
	    		}
			}    		
    	}
    	return -1;
    }
    
	private boolean isValid(int nextRow, int nextCol) {
		if(nextRow >= 0 && nextRow < rows && nextCol >=0 && nextCol < cols) {
			return true;
		}
		return false;
	}    
}
