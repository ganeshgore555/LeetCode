package com.algo.dp;

import java.util.Arrays;
import java.util.HashMap;

public class MaximumNumberOfPointsWithCost {

	public static void main(String[] args) {
		int[][] points = {{1,2,3},{1,5,1},{3,1,1}};
		System.out.println(new MaximumNumberOfPointsWithCost().maxPoints(points));
	}
	
	
    public long maxPoints(int[][] points) {
		int rows = points.length;
		int cols = points[0].length;
		//return maxPointsDP(points, 0, 0, rows, cols);
		return maxPointsOptimizedBottomUp(points);
    }

	HashMap<String,Integer> memo = new HashMap<>();
	
	private int maxPointsDP(int[][] points, int row, int col, int rows, int cols) {
		if(row > rows-1)
			return 0;		
		String key = row + "-" + col;
		if(memo.containsKey(key)){
			return memo.get(key);
		}
		int max = 0;
		for(int n = 0; n < cols; n++) {
			int sum = maxPointsDP(points, row+1, n, rows, cols) + points[row][n] - ((row > 0) ? Math.abs(col - n) : 0);
			max = Math.max(max, sum);
		}
		memo.put(key, max);
		return max;
	}

    public long maxPointsOptimizedBottomUp(int[][] points) {
        final int n = points[0].length;
        long[] lastDp = Arrays.stream(points[0]).mapToLong(x -> x).toArray();
        for (int i = 1; i < points.length; ++i) {
            long[] currentDp = new long[n];
            long temp = 0;
            for (int j = 0; j < n; ++j) {
                temp = Math.max(temp, lastDp[j] + j);
                currentDp[j] = temp - j + points[i][j];
            }
            temp = -n;
            for (int j = n - 1; j >= 0; --j) {
                temp = Math.max(temp, lastDp[j] - j);
                currentDp[j] = Math.max(currentDp[j], temp + j + points[i][j]);
            }
            lastDp = currentDp;
        }
        long ans = lastDp[0];
        for (long x : lastDp) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
	
}
