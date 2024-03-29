package com.algo.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ParallelCoursesII {

	public static void main(String[] args) {
		int n = 12;
		//int[][] relations = {{1,2},{1,3},{7,5},{7,6},{4,8},{8,9},{9,10},{10,11},{11,12}};
		int[][] relations = {{11,10},{6,3},{2,5},{9,2},{4,12},{8,7},{9,5},{6,2},{7,2},{7,4},{9,3},{11,1},{4,3}};
		int k = 3;
		System.out.println(new ParallelCoursesII().minNumberOfSemesters(n, relations, k));
	}
	
	class Node {
		Integer node;
		Integer outDegree;
		Integer depth;
		private Node(Integer node, Integer outDegree, Integer depth) {
			super();
			this.node = node;
			this.outDegree = outDegree;
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "[node=" + node + ", outDegree=" + outDegree + ", depth=" + depth + "]";
		}
	}
	
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
    	
    	int[] inDegreeMap = new int[n+1];
    	int[] outDegreeMap = new int[n+1];
    	
    	HashMap<Integer, ArrayList<Integer>> adjNodeMap = new HashMap<>();
  	    	    	
    	for(int[] relation : relations) {
    		inDegreeMap[relation[1]]++;
    		outDegreeMap[relation[0]]++;
    		
    		if(adjNodeMap.containsKey(relation[0])) {
    			adjNodeMap.get(relation[0]).add(relation[1]);
    		}else {
    			ArrayList<Integer> adjNodes = new ArrayList();
    			adjNodes.add(relation[1]);
    			adjNodeMap.put(relation[0], adjNodes);
    		}
    	}
    	
    	PriorityQueue<Node> queue = new PriorityQueue<Node>((n1,n2) -> n1.depth == n2.depth ? (n2.outDegree - n1.outDegree) : (n2.depth - n1.depth));  
    	
    	HashMap<Integer,Integer> depthMap = new HashMap<>();
    	    	
    	for(int i = 1; i < inDegreeMap.length; i++) {
    		if(inDegreeMap[i] == 0) {
    			maxDepth(i,adjNodeMap,depthMap);    			
    			queue.offer(new Node(i, outDegreeMap[i], depthMap.get(i)));
    		}
    	}
    	
    	int semester = 0;
    	int courseDone = 0;
    	while(!queue.isEmpty()) {
    		semester++;
			LinkedList<Integer> nextCourses = new LinkedList<>();
			int courseDoneInSem = 0;
    		while(!queue.isEmpty()) {
    			Node course = queue.poll();
    			courseDone++;
    			courseDoneInSem++;
    			ArrayList<Integer> adjList = adjNodeMap.get(course.node);
    			if(adjList != null && !adjList.isEmpty()) {
    				for(Integer nextCourse : adjList) {
    					inDegreeMap[nextCourse]--;
    					if(inDegreeMap[nextCourse] == 0) {
    						nextCourses.add(nextCourse);
    					}
    				}
    			}
    			if(courseDoneInSem == k) {
    	    		break;
    			}
    		}
    		for(Integer nextCourse : nextCourses)
    			queue.add(new Node(nextCourse, outDegreeMap[nextCourse],depthMap.get(nextCourse)));
    	}
		return courseDone == n ? semester : -1;
        
    }

	private int maxDepth(int i, HashMap<Integer, ArrayList<Integer>> adjNodeMap, HashMap<Integer, Integer> depthMap) {
		ArrayList<Integer> adjNodes = adjNodeMap.get(i);
		if(adjNodes == null || adjNodes.size() == 0) {
			depthMap.put(i, 1);
			return 1;
		}
		if(depthMap.containsKey(i))
			return depthMap.get(i);
		
		int max = 0;
		for(Integer adjNode : adjNodes) {
			int depth = 1 + maxDepth(adjNode,adjNodeMap,depthMap);
			max = Math.max(max, depth);
		}
		depthMap.put(i, max);
		return depthMap.get(i);
	}
}
