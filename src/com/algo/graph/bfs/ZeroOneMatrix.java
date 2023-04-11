package com.algo.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

	public static void main(String[] args) {
		int[][] mat = new int[3][3];
		mat[1][1] = 1;
		mat[2][0] = 1;
		mat[2][1] = 1;
		mat[2][2] = 1;
		new ZeroOneMatrix().updateMatrix(mat);		
	}
	
    public int[][] updateMatrix(int[][] matrix) {
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	
    	LinkedList<int[]> queue =  new LinkedList<>();
    	boolean[][] visited = new boolean[rows][cols];
    	
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    	
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while(!queue.isEmpty()) {
        	int[] cell = queue.poll();
        	for(int[] dir : dirs) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                matrix[row][col] = matrix[cell[0]][cell[1]] + 1;
                queue.offer(new int[]{row, col});
        	}
        }
        	
    	return matrix;
    }	    
}
