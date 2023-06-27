package com.algo.graph.dfs;

public class LongestZigZagPathInABinaryTree {

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
		LongestZigZagPathInABinaryTree inst = new LongestZigZagPathInABinaryTree();
		Integer[] tree = {6,9,7,3,null,2,8,5,8,9,7,3,9,9,4,2,10,null,5,4,3,10,10,9,4,1,2,null,null,6,5,null,null,null,null,9,null,9,6,5,null,5,null,null,7,7,4,null,1,null,null,3,7,null,9,null,null,null,null,null,null,null,null,9,9,null,null,null,7,null,null,null,null,null,null,null,null,null,6,8,7,null,null,null,3,10,null,null,null,null,null,1,null,1,2};
		TreeNode root =  inst.insertLevelOrder(tree, 0);
		System.out.println(inst.longestZigZag(root));
	}
	
    public TreeNode insertLevelOrder(Integer[] arr, int i)
    {
    	TreeNode root = null;
        // Base case for recursion
        if (i < arr.length && arr[i] != null) {
            root = new TreeNode(arr[i]);

            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);
 
            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }
	
	
    int pathLength = 0;
    private void dfs(TreeNode node, boolean goLeft, int steps) {
        if (node == null) {
            return;
        }
        pathLength = Math.max(pathLength, steps);
        if (goLeft) {
            dfs(node.left, false, steps + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.left, false, 1);
            dfs(node.right, true, steps + 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        dfs(root, false, 0);
        dfs(root, true, 0);
        return pathLength;
    }
	
	
}
