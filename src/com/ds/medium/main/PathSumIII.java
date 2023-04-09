package com.ds.medium.main;

public class PathSumIII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {	this.val = val;	}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		PathSumIII inst = new PathSumIII();
	}

	public int pathSum(TreeNode root, int targetSum) {
		
		return targetSum;
	}
}
