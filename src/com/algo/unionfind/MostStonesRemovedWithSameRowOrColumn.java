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
    int find(int[] rep, int x) {
        if (x == rep[x]) {
            return x;
        }
        // Uses Path compression
        return rep[x] = find(rep, rep[x]);
    }
    
    // Combine the stone x and y, and returns 1 if they were not connected
    int performUnion(int [] rep, int [] size, int x, int y) {
        x = find(rep, x);
        y = find(rep, y);
        
        if (x == y) {
            return 0;
        }
        
        if (size[x] > size[y]) {
            rep[y] = x;
            size[x] += size[y];
        } else {
            rep[x] = y;
            size[y] += size[x];
        }
        
        return 1;
    }
    
    public int removeStonesUnionFind(int[][] stones) {
        int[] rep = new int[stones.length];
        int[] size = new int[stones.length];
        // Initialize rep to itself and size as 1
        for (int i = 0; i < stones.length; i++) {
            rep[i] = i;
            size[i] = 1;
        }
        
        int componentCount = stones.length;
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (shareSameRowOrColumn(stones[i], stones[j])) {
                    // Decrement the componenets if union invloved merging
                    componentCount -= performUnion(rep, size, i, j);
                }
            }
        }
        
        // Return the maximum stone that can be removed
        return stones.length - componentCount;
    }   
    
    
    
    
}
