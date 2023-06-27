package com.algo.graph.bfs;

import java.util.*;

public class ShortestPathVisitingAllNodes {

	public static void main(String[] args) {
		int[][] graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
		System.out.println(new ShortestPathVisitingAllNodes().shortestPathLength(graph));
	}
	
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1) {
            return 0;
        }
        
        int n = graph.length;
        int endingMask = (1 << n) - 1;
        boolean[][] seen = new boolean[n][endingMask];
        LinkedList<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] {i, 1 << i});
            seen[i][1 << i] = true;
        }
        
        int steps = 0;
        while (!queue.isEmpty()) {
        	LinkedList<int[]> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] currentPair = queue.poll();
                int node = currentPair[0];
                int mask = currentPair[1];
                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    if (nextMask == endingMask) {
                        return 1 + steps;
                    }
                    
                    if (!seen[neighbor][nextMask]) {
                        seen[neighbor][nextMask] = true;
                        nextQueue.offer(new int[] {neighbor, nextMask});
                    }
                }
            }
            steps++;
            queue = nextQueue;
        }
        
        return -1;
    }
}
