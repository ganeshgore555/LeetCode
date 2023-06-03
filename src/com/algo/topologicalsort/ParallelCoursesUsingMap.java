package com.algo.topologicalsort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class ParallelCoursesUsingMap {

	public static void main(String[] args) {
		int n = 4;
		int[][] relations = {{1,2},{3,4}};
		System.out.println(new ParallelCoursesUsingMap().minimumSemesters(n, relations));
	}

    public int minimumSemesters(int n, int[][] relations) {
    	
    	HashMap<Integer, Integer> inDegreeMap = new HashMap<>();
    	HashMap<Integer, ArrayList<Integer>> adjNodeMap = new HashMap<>();
  	    	    	
    	for(int[] relation : relations) {
    		if(!inDegreeMap.containsKey(relation[0])) {
    			inDegreeMap.put(relation[0], 0);
    		}    		
    		inDegreeMap.put(relation[1], inDegreeMap.getOrDefault(relation[1],0)+1);
    		 		
    		if(adjNodeMap.containsKey(relation[0])) {
    			adjNodeMap.get(relation[0]).add(relation[1]);
    		}else {
    			ArrayList<Integer> adjNodes = new ArrayList();
    			adjNodes.add(relation[1]);
    			adjNodeMap.put(relation[0], adjNodes);
    		}
    	}
    	
    	LinkedList<Integer> queue = new LinkedList<Integer>();  
    	
    	for(Integer course : inDegreeMap.keySet()) {
    		if(inDegreeMap.getOrDefault(course, 0) == 0) {
    			queue.offer(course);
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
    					int inDegree = inDegreeMap.getOrDefault(nextCourse,0) - 1;
    					inDegreeMap.put(nextCourse, inDegree);
    					if(inDegree == 0) {
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
