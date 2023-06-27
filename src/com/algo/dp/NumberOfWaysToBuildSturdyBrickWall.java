package com.algo.dp;

import java.util.*;

public class NumberOfWaysToBuildSturdyBrickWall {

	public static void main(String[] args) {
		int height = 2, width = 3; int[] bricks = {1,2};
		System.out.println(new NumberOfWaysToBuildSturdyBrickWall().buildWall(height, width, bricks));
	}
	/*
    public int buildWall(int height, int width, int[] bricks) {
        return solve(height, width, bricks, new Integer[height + 1][1 << width], 0, 0, 0);
    }

    private int solve(int h, int w, int[] brick, Integer[][] dp, int config, int curWidth, int prev){
        if (dp[h][prev] != null)
            return dp[h][prev];
        if (h == 0)
            return 1;
        if (curWidth == w)
            return solve(h - 1, w, brick, dp, 0, 0, config);

        int ans = 0;
        for (int b : brick){
            int sz = curWidth + b, nc = sz < w? config | (1 << sz) : config;
            if (sz > w || (nc & prev) > 0)
                continue;
            ans = (ans + solve(h, w, brick, dp, nc, sz, prev)) % 1000000007;
        }

        return config == 0? dp[h][prev] = ans : ans; // save the result to dp when the whole layer returns
    }
    */
    
    public int buildWall(int height, int width, int[] bricks) {
        Arrays.sort(bricks);    // Sort so that we can stop early while placing bricks.
        return helper(new Integer[height + 1][1 << width], bricks, height, width, 1, 0, 0, 0);
    }

    private int helper(Integer cache[][], int[] bricks, int targetHeight, int targetWidth, int currHeight, int currWidth, int prevJoins, int currJoins) {
        if (currHeight == targetHeight && currWidth == targetWidth) return 1;
        
        // Start with the next row if we are done with the current one.
        if (currWidth == targetWidth) {
            return helper(cache, bricks, targetHeight, targetWidth, currHeight + 1, 0, currJoins, 0);
        }
        // Use a cached solution if avaialble.
        if (currWidth == 0 && cache[currHeight][prevJoins] != null) {
            return cache[currHeight][prevJoins];
        }
        
        int result = 0;
        for (int i = 0; i < bricks.length; ++i) {
            int endOfCurrentBrick = currWidth + bricks[i];
            if (targetWidth < endOfCurrentBrick) break;  // We can stop early if the current brick doesn't fit.
            if ((prevJoins & (1 << endOfCurrentBrick)) == 0) {            	
                if (endOfCurrentBrick < targetWidth) currJoins |= (1 << endOfCurrentBrick);     // Set i-th bit to 1.
                result += helper(cache, bricks, targetHeight, targetWidth, currHeight, endOfCurrentBrick, prevJoins, currJoins) % 1_000_000_007;
                result %= 1_000_000_007;        
                if (endOfCurrentBrick < targetWidth) currJoins &= ~(1 << endOfCurrentBrick);    // Backtrack. Set i-th bit to 0.
                
            }
        }
        return currWidth == 0 ? cache[currHeight][prevJoins] = result : result;
    }    
    
    
}
