package com.algo.graph;

import java.util.*;

public class MaximumNumberOfAcceptedInvitations {

	public static void main(String[] args) {
		int[][] grid = {{1,0,1,0},
						{1,0,0,0},
						{0,0,1,0},
						{1,1,1,0}};
		System.out.println(new MaximumNumberOfAcceptedInvitations().maximumInvitations(grid));
	}

	// DFS 
	
    int boysCount;
    int girlsCount;
    
    public int maximumInvitations(int[][] grid) {
        boysCount = grid.length;
        girlsCount = grid[0].length;
        int [] match = new int [girlsCount];
        Arrays.fill(match, -1);
        int res = 0;
        for (int i = 0; i < boysCount; i++) {
            boolean [] visited = new boolean [girlsCount];
            if (dfs(grid, i, visited, match)) {
                res++;
            }
        }
        return res;        
    }
    
    public boolean dfs(int [][] grid, int node, boolean [] visited, int [] match) {
        for (int j = 0; j < girlsCount; j++) {
            if (grid[node][j] == 1 && !visited[j]) {
                visited[j] = true;
                if (match[j] == -1 || dfs(grid, match[j], visited, match)) {
                    match[j] = node;
                    return true;
                }
            }
        }
        return false;
    }	
	
    
    // Backtrack - TLE
    
	int max = 0;	
    public int maximumInvitationsBacktrack(int[][] grid) {
    	maximumInvitationsBacktrack(grid, new HashSet<Integer>(), 0, 0);
    	return max;
    }
    
    
	private void maximumInvitationsBacktrack(int[][] grid, HashSet<Integer> girl, int i, int count) {
		if(i==grid.length) {
			max = Math.max(max, count);
			return;
		}

		for(int j = 0; j < grid[0].length; j++) {
			if(grid[i][j] == 1 && !girl.contains(j)) {
				girl.add(j);
				maximumInvitationsBacktrack(grid, girl, i+1, count+1);
				girl.remove(j);
			}
			maximumInvitationsBacktrack(grid, girl, i+1, count);
		}
	}    
    
}
