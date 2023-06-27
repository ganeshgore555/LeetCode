package com.algo.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CourseSchedule {

	public static void main(String[] args) {
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		int numCourses = 4;
		System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));		
	}

    public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] inDegree = new int[numCourses];
		HashMap<Integer,ArrayList<Integer>> adjNodesMap = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int[] prerequisite : prerequisites){
			inDegree[prerequisite[0]]++;
			
			if(adjNodesMap.containsKey(prerequisite[1])){
				adjNodesMap.get(prerequisite[1]).add(prerequisite[0]);
			}else{
				ArrayList<Integer> adjList = new ArrayList<Integer>();
				adjList.add(prerequisite[0]);
				adjNodesMap.put(prerequisite[1],adjList);
			}
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < numCourses; i++){
			if(inDegree[i] == 0){
				queue.offer(i);
			}
		}
		
		int courseTaken = 0;
		while(!queue.isEmpty()){		
			LinkedList<Integer> nextCourses = new LinkedList<Integer>();		
			while(!queue.isEmpty()){
				Integer course = queue.pop();
				courseTaken++;
				ArrayList<Integer> adjList = adjNodesMap.get(course);
				if(adjList != null && !adjList.isEmpty()){
					for(Integer adjNode : adjList){
						inDegree[adjNode]--;
						if(inDegree[adjNode] == 0){
							nextCourses.offer(adjNode);
						}
					}
				}
			}
			queue.addAll(nextCourses);
		}
		
		return courseTaken == numCourses ? true : false;        
    }
}
