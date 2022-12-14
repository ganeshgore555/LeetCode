package com.ds.easy.main;

public class RangeSumOfBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		
	}

    public static int rangeSumBST(TreeNode root, int low, int high) {
    	if(root == null) {
    		return 0;
    	}
    	int sum = 0;
		if(root.val >= low && root.val <= high) {
			sum = root.val;
		}
		sum = sum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
		return sum;
    }
}
