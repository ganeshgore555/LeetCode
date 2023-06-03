package com.algo.graph.dfs;

import java.util.*;

import com.algo.graph.dfs.HeightOfBinaryTreeAfterSubtreeRemovalQueries.TreeNode;

public class DeleteNodesAndReturnForest {

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
		@Override
		public String toString() {
			return val+"";
		}
	}
	
	
	public static void main(String[] args) {
		DeleteNodesAndReturnForest obj = new DeleteNodesAndReturnForest();
		TreeNode node1 = obj.new TreeNode(1);
		TreeNode node2 = obj.new TreeNode(2);
		TreeNode node3 = obj.new TreeNode(3);
		TreeNode node4 = obj.new TreeNode(4);
		TreeNode node5 = obj.new TreeNode(5);
		TreeNode node6 = obj.new TreeNode(6);
		TreeNode node7 = obj.new TreeNode(7);

		/**
		 * 					1
		 * 			2				3
		 * 		4		5		6		7
		 */
		
		node1.left = node2;
		node1.right = node3;		
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		int[] to_delete = {3,5};
		
		//System.out.println(obj.delNodes(node1, to_delete));
		
		
		/**
		 * 					1
		 * 			2				3
		 * 		null	null	null	4
		 */
		
		node1 = obj.new TreeNode(1);
		node2 = obj.new TreeNode(2);
		node3 = obj.new TreeNode(3);
		node4 = obj.new TreeNode(4);
					
		node1.left = node2;
		node1.right = node3;
		node3.right = node4;
		
		int[] to_delete_1 = {2,1};
		
		System.out.println(obj.delNodes(node1, to_delete_1));
	}
	
    HashMap<Integer,Integer> delete_map = new HashMap<>();

	
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Arrays.stream(to_delete).forEach(node -> delete_map.put(node, node));
        List<TreeNode> result = new ArrayList();
        if(root != null) {
        	if(!delete_map.containsKey(root.val)) {
        		result.add(root);
        	}
        	delNodeDFS(root, result);
        }
        return result;
    }


	private void delNodeDFS(TreeNode root, List<TreeNode> result) {
		if(root == null)
			return;
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		if(delete_map.containsKey(root.val)) {
			root.left = null;
			root.right = null;
			if(left != null && !delete_map.containsKey(left.val)) {
				result.add(left);
			}
			if(right != null && !delete_map.containsKey(right.val)) {
				result.add(right);
			}  
		}else {
			if(left != null && delete_map.containsKey(left.val)) {
				root.left = null;
			}
			if(right != null && delete_map.containsKey(right.val)) {
				root.right = null;
			}
		}
		delNodeDFS(left, result);
		delNodeDFS(right, result);	
	}
}
