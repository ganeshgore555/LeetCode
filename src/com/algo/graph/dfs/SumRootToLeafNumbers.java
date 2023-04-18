package com.algo.graph.dfs;

import java.util.ArrayList;

import com.algo.prefixsum.array.PathSumIII.TreeNode;

public class SumRootToLeafNumbers {

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
		
	}


    public int sumNumbers(TreeNode root) {
    	ArrayList<String> subTreelist = sumNumbersDFS(root);;
    	int sum = 0;
    	for(String treeNodeVal : subTreelist) {
    		sum += Integer.parseInt(treeNodeVal);
    	}
		return sum;
    }


	private ArrayList<String> sumNumbersDFS(TreeNode root) {
		ArrayList<String> subTreelist = new ArrayList<String>();
		if(root == null)
			return subTreelist;		
		else if(root.left == null && root.right == null)
			subTreelist.add(Integer.toString(root.val));
		else {
			ArrayList<String> templist = new ArrayList<String>();
			templist.addAll(sumNumbersDFS(root.left));
			templist.addAll(sumNumbersDFS(root.right));
	    	for(String subTreeNodeVal : templist) {
	    		subTreelist.add(root.val + subTreeNodeVal);
	    	}
		}
		return subTreelist;
	}
}
