package com.algo.graph.dfs;

import java.util.HashMap;

public class MaximumLevelSumOfABinaryTree {

	public static void main(String[] args) {
		
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
	
	HashMap<Integer, Integer> map = new HashMap<>();
	
    public int maxLevelSum(TreeNode root) {
    	if(root != null) {
    		map.put(1, root.val);
    		maxLevelSumDFS(root,1);
    	}
    	int maxLevel = Integer.MAX_VALUE;
    	int maxSum = Integer.MIN_VALUE;
    	for(Integer level : map.keySet()) {
    		if(maxSum < map.get(level) || (maxSum == map.get(level) && maxLevel > level)) {
    			maxSum = map.get(level);
    			maxLevel = level;
    		}    			
    	}
    	return maxLevel;
    }

	private void maxLevelSumDFS(TreeNode root, int level) {
		if(root == null)
			return;
		if(root != null)
			map.put(level, map.getOrDefault(level, 0) + root.val);
		
		maxLevelSumDFS(root.left,level+1);
		maxLevelSumDFS(root.right,level+1);
	}
}
