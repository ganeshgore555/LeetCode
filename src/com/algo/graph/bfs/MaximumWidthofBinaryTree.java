package com.algo.graph.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.algo.graph.FindLeavesOfBinaryTree.TreeNode;

public class MaximumWidthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	/*------------------------------------------------------------------------------------*/
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
    
    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
	
	/*------------------------------------------------------------------------------------*/
    
    public int widthOfBinaryTreeBFS(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        queue.offer(root);
        map.put(root, 1);
        int curWidth = 0;
        int maxWidth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int start = 0;
            int end = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == 0) start = map.get(node);
                if(i == size - 1) end = map.get(node);
                if(node.left != null){
                    map.put(node.left, map.get(node) * 2);
                    queue.offer(node.left);
                }
                if(node.right != null){
                    map.put(node.right, map.get(node) * 2 + 1);
                    queue.offer(node.right);
                }
            }
            curWidth = end - start + 1;
            maxWidth = Math.max(curWidth, maxWidth);
        }
        return maxWidth;
    }
    
	/*------------------------------------------------------------------------------------*/
    
    private Integer maxWidth = 0;
    private HashMap<Integer, Integer> firstColIndexTable;

    protected void DFS(TreeNode node, Integer depth, Integer colIndex) {
        if (node == null)
            return;
        // initialize the value, for the first seen colIndex per level
        if (!firstColIndexTable.containsKey(depth)) {
            firstColIndexTable.put(depth, colIndex);
        }
        Integer firstColIndex = firstColIndexTable.get(depth);

        maxWidth = Math.max(this.maxWidth, colIndex - firstColIndex + 1);

        // Preorder DFS. Note: it is important to put the priority on the left child
        DFS(node.left, depth + 1, 2 * colIndex);
        DFS(node.right, depth + 1, 2 * colIndex + 1);
    }

    public int widthOfBinaryTreeDFS(TreeNode root) {
        // table contains the first col_index for each level
        this.firstColIndexTable = new HashMap<Integer, Integer>();

        // start from depth = 0, and colIndex = 0
        DFS(root, 0, 0);

        return this.maxWidth;
    }    
}
