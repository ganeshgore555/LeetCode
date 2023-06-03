package com.algo.graph.dfs;

import java.util.*;

public class FindLeavesOfBinaryTree {

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
	
	public static void main(String[] args) {
		FindLeavesOfBinaryTree obj = new FindLeavesOfBinaryTree();
		TreeNode node1 = obj.new TreeNode(1);
		TreeNode node2 = obj.new TreeNode(2);
		TreeNode node3 = obj.new TreeNode(3);
		TreeNode node4 = obj.new TreeNode(4);
		TreeNode node5 = obj.new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		System.out.println(obj.findLeaves(node1));		
	}

    public List<List<Integer>> findLeaves(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	while(root.left != null || root.right != null) {
    		List<Integer> tempResult = new ArrayList<>(); 
    		removeLeavesByDFS(root, null, -1, tempResult);
    		result.add(tempResult);
    	}
		if(root != null){
			List<Integer> tempResult = new ArrayList<>();
			tempResult.add(root.val);
			result.add(tempResult);
		}
        return result;
    }
	private void removeLeavesByDFS(TreeNode root, TreeNode parent, int left, List<Integer> tempResult) {
		if(root != null) {
			boolean childPresent = false;
			if(root.left != null) {
				childPresent = true;
				removeLeavesByDFS(root.left, root, 1, tempResult);
			}
			
			if(root.right != null) {
				childPresent = true;
				removeLeavesByDFS(root.right, root, 0, tempResult);
			}
			
			if(root.left == null && root.right == null && !childPresent) {
				tempResult.add(root.val);
				if(left == 1) {
					parent.left = null;
				}else {
					parent.right = null;
				}
			}
		}
	}
}
