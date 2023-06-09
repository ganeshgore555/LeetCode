package com.algo.graph.dfs;

import com.algo.graph.dfs.FindLeavesOfBinaryTree.TreeNode;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

	public static void main(String[] args) {
		StepByStepDirectionsFromABinaryTreeNodeToAnother obj = new StepByStepDirectionsFromABinaryTreeNodeToAnother();
		TreeNode node1 = obj.new TreeNode(1);
		TreeNode node2 = obj.new TreeNode(2);
		TreeNode node3 = obj.new TreeNode(3);
		TreeNode node4 = obj.new TreeNode(4);
		TreeNode node5 = obj.new TreeNode(5);
		TreeNode node6 = obj.new TreeNode(6);
		TreeNode node7 = obj.new TreeNode(7);
		TreeNode node8 = obj.new TreeNode(8);
		TreeNode node9 = obj.new TreeNode(9);
		TreeNode node10 = obj.new TreeNode(10);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;

		node4.left = node8;

		node6.left = node9;
		node6.right = node10;
		
		System.out.println(obj.getDirections(node1, 10, 9));		
	}

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
	
	private boolean find(TreeNode n, int val, StringBuilder sb) {
	    if (n.val == val) 
	        return true;
	    if (n.left != null && find(n.left, val, sb))
	        sb.append("L");
	    else if (n.right != null && find(n.right, val, sb))
	        sb.append("R");
	    return sb.length() > 0;
	}
	public String getDirections(TreeNode root, int startValue, int destValue) {
	    StringBuilder s = new StringBuilder();
	    StringBuilder d = new StringBuilder();
	    find(root, startValue, s);
	    find(root, destValue, d);
	    int i = 0;
	    int max_i = Math.min(d.length(), s.length());
	    while (i < max_i && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
	        i++;
	    return "U".repeat(s.length() - i) + d.reverse().toString().substring(i);
	}
}
