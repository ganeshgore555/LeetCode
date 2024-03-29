package com.algo.unionfind;

import java.util.*;

public class MostStonesRemovedWithSameRowOrColumn {

	public static void main(String[] args) {
		//int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		int[][] stones = {{0,0},{0,1},{1,0},{3,4},{5,4},{3,6}};
		System.out.println(new MostStonesRemovedWithSameRowOrColumn().removeStonesUnionFind(stones));
	}

	
    // Return true if stone a and b shares row or column
    boolean shareSameRowOrColumn(int[] a, int[] b) {
        return a[0] == b[0] || a[1] == b[1];
    }
    
    
    // DFS
    
    int removeStonesDFS(int[][] stones) {
        // Adjacency list to store edges
        List<Integer>[] adj = new ArrayList[stones.length]; 
        for (int i = 0; i < stones.length; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (shareSameRowOrColumn(stones[i], stones[j])) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        
        // Array to mark visited stones
        int[] visited = new int[stones.length];
        // Counter for connected components
        int componentCount = 0;
        for (int i = 0; i < stones.length; i++) {
            if (visited[i] == 0) {
                // If the stone is not visited yet,
                // Start the DFS and increment the counter
                componentCount++;
                dfs(stones, adj, visited, i);
            }
        }
        
        // Return the maximum stone that can be removed
        return stones.length - componentCount;
    }
    
    void dfs(int[][] stones, List<Integer>[] adj, int[] visited, int src) {
        // Mark the stone as visited
        visited[src] = 1;
        
        // Iterate over the adjacent, and iterate over it if not visited yet
        for (int adjacent : adj[src]) {
            if (visited[adjacent] == 0) {
                dfs(stones, adj, visited, adjacent);
            }
        }
    }    
    
    
    // Union Find
    
    // Returns the representative of vertex x
    int find(int[] group, int x) {
        if (x == group[x]) {
            return x;
        }
        // Uses Path compression
        return group[x] = find(group, group[x]);
    }
    
    // Combine the stone x and y, and returns 1 if they were not connected
    int performUnion(int [] group, int [] rank, int x, int y) {
        x = find(group, x);
        y = find(group, y);
        
        if (x == y) {
            return 0;
        }
        
        if (rank[x] > rank[y]) {
            group[y] = x;
            rank[x] += rank[y];
        } else {
            group[x] = y;
            rank[y] += rank[x];
        }
        
        return 1;
    }
    
    public int removeStonesUnionFind(int[][] stones) {
        int[] group = new int[stones.length];
        int[] rank = new int[stones.length];
        // Initialize group to itself and rank as 1
        for (int i = 0; i < stones.length; i++) {
            group[i] = i;
            rank[i] = 1;
        }
        
        int componentCount = stones.length;
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (shareSameRowOrColumn(stones[i], stones[j])) {
                    // Decrement the componenets if union invloved merging
                    componentCount -= performUnion(group, rank, i, j);
                }
            }
        }
        
        // Return the maximum stone that can be removed
        return stones.length - componentCount;
    }   
    
    
    
    
}
