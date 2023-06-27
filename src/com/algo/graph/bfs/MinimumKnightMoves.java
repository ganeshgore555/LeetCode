package com.algo.graph.bfs;

import java.util.LinkedList;

public class MinimumKnightMoves {

	public static void main(String[] args) {
		int x = 1, y = 1;
		System.out.println(new MinimumKnightMoves().minKnightMoves(x, y));
	}

	
	int[][] dirs = {{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1},{1,2},{2,1}};
	int rows = 2000;
	int cols = 2000;
	
    public int minKnightMoves(int x, int y) {
    	boolean[][] visited = new boolean [rows][cols];	
    	LinkedList<int[]> queue =  new LinkedList();
    	int[] start = {600,600,0};
    	visited[600][600] = true;
    	queue.add(start);
    	while(!queue.isEmpty()) {
    		int[] pos = queue.poll();
    		int row = pos[0];
    		int col = pos[1];
    		int steps = pos[2];
    		if(row == 600+x && col == 600+y)
    			return steps;
        	
        	for(int[] dir : dirs) {
        		int nextRow = row + dir[0];
        		int nextCol = col + dir[1];
        		int nextSteps = steps + 1;
        		if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && !visited[nextRow][nextCol]) {
        			int[] nextPos = {nextRow, nextCol, nextSteps};
        			queue.add(nextPos);
        			visited[nextRow][nextCol] = true;
        		}
        	}
    	}
		return -1;
    }	
	
}
