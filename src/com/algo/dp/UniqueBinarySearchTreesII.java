package com.algo.dp;

import java.util.*;

public class UniqueBinarySearchTreesII {

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
		
	}

	
	
	public List<TreeNode> generateTrees(int n) {
		return generateSubtrees(1, n);
	}
	
	HashMap<String, List<TreeNode>> memo = new HashMap<>();
	
	private List<TreeNode> generateSubtrees(int s, int e) {
		List<TreeNode> res = new LinkedList<TreeNode>();
		if (s > e) {
			res.add(null); // empty tree
			return res;
		}
		String key = s + "-" + e;
		if(memo.containsKey(key))
			return memo.get(key);
		
		for (int i = s; i <= e; ++i) {
			List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
			List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);

			for (TreeNode left : leftSubtrees) {
				for (TreeNode right : rightSubtrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		memo.put(key, res);
		return res;
	}	
}
