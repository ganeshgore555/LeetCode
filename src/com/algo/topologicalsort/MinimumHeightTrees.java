package com.algo.topologicalsort;

import java.util.*;

public class MinimumHeightTrees {

	public static void main(String[] args) {
		int n = 6;
		int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
		System.out.println(new MinimumHeightTrees().findMinHeightTrees(n, edges));
	}
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	ArrayList<Integer> outputList = new ArrayList<Integer>();
    	if(n <= 2) {
            for (int i = 0; i < n; i++)
    			outputList.add(i);
    		return outputList;
    	}
    	
    	ArrayList<Integer>[] adjList = new ArrayList[n];
    	
    	//Initialize adjacency list
    	for(int i = 0; i < n; i++) {
    		adjList[i] = new ArrayList<Integer>();
    	}
    	
    	//Populate adjacency list
    	for(int[] edge : edges) {
    		adjList[edge[0]].add(edge[1]);
    		adjList[edge[1]].add(edge[0]);
    	}
    	
    	//Collect leaf nodes i.e. nodes with 1 adjacent node
    	LinkedList<Integer> leafNodes = new LinkedList<>(); 
    	for(int i = 0; i < n; i++) {
    		if(adjList[i].size() == 1) {
    			leafNodes.offer(i);
    		}
    	}
    	
    	int nodeVisited = 0;
    	
    	while(n - nodeVisited > 2) {
    		LinkedList<Integer> nextLeaves = new LinkedList<>();
    		// Visit each leaf node and find next leaf nodes from adjacency list of current leaf node
    		while(!leafNodes.isEmpty()) {
    			Integer node = leafNodes.poll();
    			nodeVisited++;
    			Integer neighbour = adjList[node].get(0);
    			adjList[neighbour].remove(node);
    			if(adjList[neighbour].size() == 1) {
    				nextLeaves.offer(neighbour);
    			}
    		}
    		leafNodes = nextLeaves;
    	}
    	
    	return leafNodes;
    	
    }
}
