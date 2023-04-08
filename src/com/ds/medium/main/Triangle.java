package com.ds.medium.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
		List<List<Integer>> triangleList = new ArrayList();
		for(int[] row : triangle) {
			List<Integer> list = new ArrayList();
			for(int i : row) {
				list.add(i);
			}
			triangleList.add(list);
		}
		System.out.println(new Triangle().minimumTotalIterative(triangleList));
	}

    public int minimumTotal(List<List<Integer>> triangle) {
		int[][] memory = new int[triangle.size()-1][triangle.get(triangle.size()-1).size()];
		for(int i = 0; i < memory.length; i++) {
			for(int j = 0; j < memory[0].length; j++) {
				memory[i][j] = Integer.MAX_VALUE;
			}
		}
		
    	if(triangle.size() == 1) {
    		return triangle.get(0).get(0);
    	}
    	
    	return triangle.get(0).get(0) + 
    			Math.min(
    					minimumTotalByRecursion(triangle, memory, 0, 1),
    					minimumTotalByRecursion(triangle, memory, 1, 1));
    }

	private int minimumTotalByRecursion(List<List<Integer>> triangle, int[][] memory, int index, int row) {
		if(triangle.size()-1 == row)
			return triangle.get(row).get(index);
		
		if(index > triangle.get(row).size()-1)
			return Integer.MAX_VALUE;
		
		if(memory[row][index] == Integer.MAX_VALUE) {
			memory[row][index] = triangle.get(row).get(index) + 
	    			Math.min(
	    					minimumTotalByRecursion(triangle, memory, index, row+1),
	    					minimumTotalByRecursion(triangle, memory, index+1, row+1));
		}
		return memory[row][index];
	}
	
	
    public int minimumTotalIterative(List<List<Integer>> triangle) {
        for (int row = 1; row < triangle.size(); row++) {
            for (int col = 0; col <= row; col++) {
                int smallestAbove = Integer.MAX_VALUE;           
                if (col > 0) {
                    smallestAbove = triangle.get(row - 1).get(col - 1);
                } 
                if (col < row) {
                    smallestAbove = Math.min(smallestAbove, triangle.get(row - 1).get(col));
                }
                int path = smallestAbove + triangle.get(row).get(col);
                triangle.get(row).set(col, path);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
	
}
