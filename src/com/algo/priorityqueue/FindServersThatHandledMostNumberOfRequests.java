package com.algo.priorityqueue;

import java.util.*;

public class FindServersThatHandledMostNumberOfRequests {

	public static void main(String[] args) {
		int k = 3;
		int[] arrival = {1,2,3,4,8,9,10}, load = {5,2,10,3,1,2,2};
		System.out.println(new FindServersThatHandledMostNumberOfRequests().busiestServers(k, arrival, load));
	}

	
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
    	TreeSet<Integer> server = new TreeSet<Integer>();
        PriorityQueue<Integer[]> allocatedServer = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[] usage = new int[k];
        for(int i = 0; i < k; i++)
        	server.add(i);
        
        for(int i = 0; i < arrival.length; i++) {
        	int iTime = arrival[i];
        	int iLoad = load[i];
        	
        	while(!allocatedServer.isEmpty() && allocatedServer.peek()[0] <= iTime) {
        		server.add(allocatedServer.poll()[1]);        		
        	}
        	
        	if(!server.isEmpty()) {
                Integer freeServer = server.ceiling(i % k);
                if (freeServer == null) {
                	freeServer = server.first();
                } 
                server.remove(freeServer);	        		
        		int compltetionTime = iTime+iLoad;
        		Integer[] scheduleRequest = {compltetionTime, freeServer};
        		allocatedServer.offer(scheduleRequest);
        		usage[freeServer]++;
        	}        	
        }
        
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < k ; i++) {
        	max = Math.max(max, usage[i]);
        }
        for(int i = 0; i < k ; i++) {
        	if(usage[i] == max)
        		list.add(i);
        }        
        return list;
    }
}
