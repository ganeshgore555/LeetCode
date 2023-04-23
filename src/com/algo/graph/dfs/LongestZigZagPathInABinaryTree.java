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
	
	
    public int longestZigZag(TreeNode root) {
    	//return Math.max(longestZigZagDFS(root.left,true),longestZigZagDFS(root.right,false));
    	return longestZigZagDFS(root)[2];
    }

	private int longestZigZagDFS(TreeNode node, boolean isLeft) {
		if(node == null)
			return 0;
		else if(isLeft){
			return Math.max(1 + longestZigZagDFS(node.right, false), longestZigZagDFS(node.left, true));
		}else {
			return Math.max(1 + longestZigZagDFS(node.left, true), longestZigZagDFS(node.right, false));
		}
	}
	
    private int[] longestZigZagDFS(TreeNode root) {
        if (root == null)
        	return new int[]{-1, -1, -1};
        int[] leftSubTree = longestZigZagDFS(root.left);
        int[] rightSubTree = longestZigZagDFS(root.right);
        int res = Math.max(Math.max(leftSubTree[1], rightSubTree[0]) + 1, Math.max(leftSubTree[2], rightSubTree[2]));
        return new int[]{leftSubTree[1] + 1, rightSubTree[0] + 1, res};
    }
	
	
}
