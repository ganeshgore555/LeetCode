package com.algo.dp;

import java.util.Arrays;

public class MaximumNumberOfEventsThatCanBeAttendedII {

	public static void main(String[] args) {
		int[][] events = {{1,2,4},{3,4,3},{2,3,10}};
		int k = 2;
		//int[][] events = {{30,40,34},{6,11,6},{60,81,36}};
		//int k = 1;
		System.out.println(new MaximumNumberOfEventsThatCanBeAttendedII().maxValue(events, k));
	}

	Integer [][] dp;
	
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;        
        dp = new Integer[k + 1][n];       
        return maxValueDp(0, k, events);
    }    
    
    private int maxValueDp(int curIndex, int count, int[][] events) {
        if (count == 0 || curIndex == events.length) {
            return 0;
        }
        if (dp[count][curIndex] != null) {
            return dp[count][curIndex];
        }
        int nextIndex = getNextIndex(events, events[curIndex][1]);
        dp[count][curIndex] = Math.max(maxValueDp(curIndex + 1, count, events), events[curIndex][2] + maxValueDp(nextIndex, count - 1, events));
        return dp[count][curIndex];
    }
    
    public static int getNextIndex(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }   
}
