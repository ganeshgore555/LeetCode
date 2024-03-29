package com.algo.graph.dfs;


public class MaximumDepthOfBinaryTree {

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
	
    public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        else
        	return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
