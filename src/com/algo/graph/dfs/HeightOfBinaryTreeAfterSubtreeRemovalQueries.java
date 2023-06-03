package com.algo.graph.dfs;

import java.util.*;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {

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
		HeightOfBinaryTreeAfterSubtreeRemovalQueries obj = new HeightOfBinaryTreeAfterSubtreeRemovalQueries();
		TreeNode node1 = obj.new TreeNode(1);
		TreeNode node2 = obj.new TreeNode(2);
		TreeNode node3 = obj.new TreeNode(3);
		TreeNode node4 = obj.new TreeNode(4);
		TreeNode node5 = obj.new TreeNode(5);
		TreeNode node6 = obj.new TreeNode(6);
		TreeNode node7 = obj.new TreeNode(7);
		TreeNode node8 = obj.new TreeNode(8);
		TreeNode node9 = obj.new TreeNode(9);
		
		node5.left = node8;
		node5.right = node9;
		node8.left = node2;
		node8.right = node1;
		node2.left = node4;
		node2.right = node6;
		node9.left = node3;
		node9.right = node7;
		
		int[] queries = {3,2,4,8};
		
		Arrays.stream(obj.treeQueries(node5, queries)).forEach(System.out::println);
	}

	
    private Map<Integer, Integer> leftMap = new HashMap<>();
    private Map<Integer, Integer> rightMap = new HashMap<>();
    private Map<Integer, Integer> removed = new HashMap<>();
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        populateHeights(root, 0);
        calculateRemovedHeights(root, 0);
        
        int[] output = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            output[i] = removed.get(queries[i]);
        }
        return output;
    }
    
	// height is the max tree height with this node removed
    private void calculateRemovedHeights(TreeNode node, int height) {
        if (node == null) {
            return;
        }
        removed.put(node.val, height);
		
		// for each child, the height when removed is the max of the the height following
		// the opposite child, or the passed-in height with this node removed
        calculateRemovedHeights(node.left, Math.max(height, rightMap.get(node.val)));
        calculateRemovedHeights(node.right, Math.max(height, leftMap.get(node.val)));
    }
    
	// populate the maps with the total height of the left and right subtree of
	// each node, and return the larger of the two values
    private int populateHeights(TreeNode node, int height) {
        if (node == null) {
            return height - 1;
        }
        
        leftMap.put(node.val, populateHeights(node.left, height + 1));
        rightMap.put(node.val, populateHeights(node.right, height + 1));
        
        return Math.max(leftMap.get(node.val), rightMap.get(node.val));
    }
    
}
