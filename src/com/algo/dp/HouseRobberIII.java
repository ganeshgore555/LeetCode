package com.algo.dp;

import java.util.HashMap;

import com.algo.graph.dfs.HeightOfBinaryTreeAfterSubtreeRemovalQueries.TreeNode;

public class HouseRobberIII {

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
	
    private HashMap<TreeNode, Integer> dp = new HashMap<>();  // Line 1
    
    public int rob(TreeNode root) {
        if (root == null)
            return 0;   
        
        if (dp.containsKey(root))    // Line 2
            return dp.get(root);    // Line 3
                
        int robCurrent = root.val;
        if (root.left != null)
            robCurrent += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            robCurrent += rob(root.right.left) + rob(root.right.right);
        
        int doNotRobCurrent = 0;
        doNotRobCurrent += rob(root.left) + rob(root.right);
        
        int res = Math.max(robCurrent, doNotRobCurrent);
        dp.put(root, res);   // Line 4
        return res;
    }

}
