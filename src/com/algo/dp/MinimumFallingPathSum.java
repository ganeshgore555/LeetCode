package com.algo.dp;

import java.util.HashMap;

public class MinimumFallingPathSum {

	public static void main(String[] args) {
		int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
		//int[][] matrix = {{-19,57},{-40,-5}};
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
		
		if(i >= matrix[0].length || i < 0)
			return Integer.MAX_VALUE;
		
		if(map.containsKey(n+"-"+i))
			return map.get(n+"-"+i);
		
		int result = matrix[n][i] + Math.min(minFallingPathSumRecursive(n-1, i), Math.min(minFallingPathSumRecursive(n-1, i-1),minFallingPathSumRecursive(n-1, i+1)));
		
		map.put(n+"-"+i, result);
		return result;
	}
    
    
}
