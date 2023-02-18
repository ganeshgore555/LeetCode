package com.ds.medium.main;

import java.util.Collection;
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {

	
	public class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode inst = new PopulatingNextRightPointersInEachNode();
		Node node1 = inst.new Node(1);
		
		Node node2 = inst.new Node(2);
		Node node3= inst.new Node(3);
		node1.left = node2;
		node1.right= node3;
		
		Node node4 = inst.new Node(4);
		Node node5 = inst.new Node(5);
		node2.left = node4;
		node2.right= node5;
		Node node6 = inst.new Node(6);
		Node node7 = inst.new Node(7);
		node3.left = node6;
		node3.right= node7;
		inst.connect(node1);
	}
	
	public Node connect(Node root) {
	    if(root == null)
	        return root;
	        
	    if(root.left != null){
	        root.left.next = root.right;
	        if(root.next != null)
	            root.right.next = root.next.left;
	    }
	    
	    connect(root.left);
	    connect(root.right);
	    return root;
	}
        
}
