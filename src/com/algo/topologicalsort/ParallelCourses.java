package com.algo.topologicalsort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class ParallelCourses {

	public static void main(String[] args) {
		int n = 4;
		int[][] relations = {{1,2},{3,4}};
		System.out.println(new ParallelCourses().minimumSemesters(n, relations));
	}

    public int minimumSemesters(int n, int[][] relations) {
    	
    	int[] inDegreeMap = new int[n+1];
    	HashMap<Integer, ArrayList<Integer>> adjNodeMap = new HashMap<>();
  	    	    	
    	for(int[] relation : relations) {
    		inDegreeMap[relation[1]]++;
    		
    		if(adjNodeMap.containsKey(relation[0])) {
    			adjNodeMap.get(relation[0]).add(relation[1]);
    		}else {
    			ArrayList<Integer> adjNodes = new ArrayList();
    			adjNodes.add(relation[1]);
    			adjNodeMap.put(relation[0], adjNodes);
    		}
    	}
    	
    	LinkedList<Integer> queue = new LinkedList<Integer>();  
    	
    	for(int i = 1; i < inDegreeMap.length; i++) {
    		if(inDegreeMap[i] == 0) {
    			queue.offer(i);
    		}
    	}
    	
    	if(queue.isEmpty()) {
    		return -1;
    	}
    	
    	int semester = 0;
    	int courseDone = 0;
    	while(!queue.isEmpty()) {
    		semester++;
			LinkedList<Integer> nextCourses = new LinkedList<>();
    		while(!queue.isEmpty()) {
    			Integer course = queue.poll();
    			courseDone++;
    			ArrayList<Integer> adjList = adjNodeMap.get(course);
    			if(adjList != null && !adjList.isEmpty()) {
    				for(Integer nextCourse : adjList) {
    					inDegreeMap[nextCourse]--;
    					if(inDegreeMap[nextCourse] == 0) {
    						nextCourses.add(nextCourse);
    					}
    				}
    			}
    		}
    		queue.addAll(nextCourses);
    	}
		return courseDone == n ? semester : -1;
    }
	
}
