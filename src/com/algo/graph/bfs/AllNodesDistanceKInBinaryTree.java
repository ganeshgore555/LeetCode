package com.algo.graph.bfs;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
	    }
	}
	
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap();
        populateAdjListByDFS(adjList,root, null);
        ArrayList<Integer> result = new ArrayList<>();
        getKthNodesByBFS(result, adjList, target.val, k);
        return result;
    }

    private void getKthNodesByBFS(ArrayList<Integer> result, HashMap<Integer, ArrayList<Integer>> adjList, int target, int k) {
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        int count = 0;
        while(!queue.isEmpty() && count <= k){
        	int size = queue.size();        	
        	for(int i = 0; i < size; i++) {
        		int node = queue.pop();
        		if(count == k) {
        			result.add(node);
        		}
        		if(adjList.containsKey(node)) {
        			for(Integer neighbour : adjList.get(node)) {
        				if(!visited.contains(neighbour)) {
        					visited.add(neighbour);
        					queue.add(neighbour);
        				}        					
        			}
        		}
        	}
        	count++;
        }
	}

	// Convert tree to graph
	private void populateAdjListByDFS(HashMap<Integer, ArrayList<Integer>> adjList, TreeNode node, TreeNode parent) {
		if(node != null) {
			if(parent != null) {
				adjList.computeIfAbsent(node.val, value -> new ArrayList<Integer>()).add(parent.val);
				adjList.computeIfAbsent(parent.val, value -> new ArrayList<Integer>()).add(node.val);
			}
			populateAdjListByDFS(adjList, node.left, node);
			populateAdjListByDFS(adjList, node.right, node);
		}
	}
}
