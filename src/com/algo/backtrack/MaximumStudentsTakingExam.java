package com.algo.backtrack;

import java.util.HashSet;

public class MaximumStudentsTakingExam {

	public static void main(String[] args) {
		char[][]seats = {{'#','.','#','#','.','#'},
						 {'.','#','#','#','#','.'},
						 {'#','.','#','#','.','#'}};
		
		System.out.println(new MaximumStudentsTakingExam().maxStudents(seats));
	}

	int max = 0;
	int rows;
	int cols;
	int count = 0;
	HashSet<String> occupied; 
    public int maxStudents(char[][] seats) {
    	rows = seats.length;
    	cols = seats[0].length;
    	occupied = new HashSet<>();
    	maxStudentsBacktrack(seats,0, 0);
		return max;
    }
    
    public void maxStudentsBacktrack(char[][] seats, int row, int col) {
    	for(int i = row; i < rows; i++) {
        	for(int j = 0; j < cols; j++) {
        		
        		if(i == row && j == 0)
        			j = col;
        			
        		if(seats[i][j] != '#' && safe(i,j) && !occupied.contains(i + "-" + j)) {
        			occupied.add(i + "-" + j);
        			count++;
        			max = Math.max(max, count);
        			maxStudentsBacktrack(seats,i,j);
        			count--;
        			occupied.remove(i + "-" + j);
        		}
        	}    		
    	}
    }

	private boolean safe(int i, int j) {
		if(occupied.contains((i) + "-" + (j-1)) || occupied.contains((i) + "-" + (j+1)) || occupied.contains((i-1) + "-" + (j-1)) || occupied.contains((i-1) + "-" + (j+1))) {
			return false;
		}
		return true;
	}
}
