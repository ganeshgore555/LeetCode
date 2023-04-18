package com.algo.dp;

import java.util.HashMap;

public class MinimumFallingPathSumII {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		//int[][] matrix = {{7}};
		System.out.println(new MinimumFallingPathSum().minFallingPathSum(matrix));
	}

	int[][] matrix;
	HashMap<String,Integer> map = new HashMap<>();
	
    public int minFallingPathSum(int[][] matrix) {
    	int min = Integer.MAX_VALUE;
    	this.matrix = matrix;
    	for(int i = 0; i < matrix[0].length; i++)
    		min = Math.min(min, minFallingPathSumRecursive(matrix.length-1,i));
		return min;
    }

	private int minFallingPathSumRecursive(int n, int i) {
		if(n < 0)
			return 0;
		
		if(map.containsKey(n+"-"+i))
			return map.get(n+"-"+i);
		
		int prevMin = Integer.MAX_VALUE;
		
		for(int col = 0; col < matrix[0].length; col++) {
			if(i != col)
				prevMin = Math.min(prevMin, minFallingPathSumRecursive(n-1, col));
		}
		int result = matrix[n][i] + prevMin;
		
		map.put(n+"-"+i, result);
		return result;
	}

}
