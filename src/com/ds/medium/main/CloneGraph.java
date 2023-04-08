package com.ds.medium.main;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {

	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	public static void main(String[] args) {
		CloneGraph inst = new CloneGraph();
		inst.cloneGraph(inst.buildGraph());
	}
	
    public Node buildGraph() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.neighbors.add(node2);
		node2.neighbors.add(node3);
		node3.neighbors.add(node4);
		node4.neighbors.add(node1);
		return node1;
    }
	
    public Node cloneGraph(Node node) {
    	
    	if(node == null)
    		return null;
    	
    	HashMap<Integer,Boolean> visited = new HashMap<>();
    	HashMap<Integer,Node> clone = new HashMap<>();
    	Deque<Node> queue = new LinkedList();    	
    	queue.offer(node);

    	while(!queue.isEmpty()) {
    		Node currentNode = queue.pop();
    		
    		if(visited.get(currentNode.val) != null)
    			continue;
    		
    		visited.put(currentNode.val, true);
    		
    		Node temp = clone.get(currentNode.val);
    		if(temp == null) {
    			temp = new Node(currentNode.val);
    			clone.put(currentNode.val, temp);
    		}
    		
    		for(Node n : currentNode.neighbors) {
    			queue.offer(n);
    			Node tempNeighbour = clone.get(n.val);
    			if(tempNeighbour == null) {
    				tempNeighbour = new Node(n.val);
    				clone.put(tempNeighbour.val, tempNeighbour);
    			}
    			temp.neighbors.add(tempNeighbour);
    		}
    	}
		return clone.get(1);
    }
}
