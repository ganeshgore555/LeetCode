package com.algo.topologicalsort;

import java.util.*;

public class CourseScheduleII {

	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		Arrays.stream(new CourseScheduleII().findOrder(numCourses, prerequisites)).forEach(System.out::println);
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
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
		
		
		ArrayList<Integer> courseSchedule = new ArrayList<>();
		while(!queue.isEmpty()){		
			LinkedList<Integer> nextCourses = new LinkedList<Integer>();		
			while(!queue.isEmpty()){
				Integer course = queue.pop();
				courseSchedule.add(course);
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
		
		if(courseSchedule.size() == numCourses) {
			int output[] = new int[courseSchedule.size()];
			int index = 0;
			for(Integer course : courseSchedule) {
				output[index++] = course; 
			}
			return output;
		}
		return new int[0];
	}
	
}
