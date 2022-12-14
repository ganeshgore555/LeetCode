package com.ds.easy.main;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBinaryTrees {

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

	
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return null;
        }else if(root1==null){
            return root2;
        }else if(root2==null){
            return root1;
        }else{
            TreeNode node = new TreeNode(root1.val+root2.val);
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
            return node;
        }
    }
}
