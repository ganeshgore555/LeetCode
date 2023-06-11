package com.algo.unionfind;

import java.util.*;

public class TheEarliestMomentWhenEveryoneBecomeFriendsHashMap {

	public static void main(String[] args) {
		TheEarliestMomentWhenEveryoneBecomeFriendsHashMap obj = new TheEarliestMomentWhenEveryoneBecomeFriendsHashMap();
		int[][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
		int n = 6;
		System.out.println(obj.earliestAcq(logs, n));
	}
	
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b) -> a[0] - b[0]);
    	HashMap<Integer, Integer> friends = new HashMap<>();   	
    	HashMap<Integer, HashSet<Integer>> groups = new HashMap<>();
    	int earliest = -1;
    	int latest = 0;
    	int setCounter = 0;
    	for(int i = 0; i < logs.length; i++) {
    		int time = logs[i][0];
    		int f1 = logs[i][1];
    		int f2 = logs[i][2];
    		
    		Integer groupNof1 = friends.get(f1);
    		Integer groupNof2 = friends.get(f2);
    		
    		HashSet<Integer> groupf1 = groupNof1 != null ? groups.get(groupNof1) : null;
    		HashSet<Integer> groupf2 = groupNof2 != null ? groups.get(groupNof2) : null;
    		
    		Integer newGroupNo = null;
			HashSet<Integer> newGroup = null;
			Integer oldGroupNo = null;
			HashSet<Integer> oldGroup = null;
			if(groupf1 != null && groupf2 != null) {
				
				if(groupf1 == groupf2)
					continue;
				
				if(groupf1.size() > groupf2.size()) {
					newGroupNo = groupNof1;
					newGroup = groupf1;
					oldGroupNo = groupNof2;
					oldGroup = groupf2;
				}else {
					newGroupNo = groupNof2;
					newGroup = groupf2;
					oldGroupNo = groupNof1;
					oldGroup = groupf1;					
				}
			}else if(groupf1 != null) {
				newGroupNo = groupNof1;
				newGroup = groupf1;
			}else if(groupf2 != null) {
				newGroupNo = groupNof2;
				newGroup = groupf2;
			}else {
				newGroup = new HashSet<>();
				newGroupNo = setCounter;
				groups.put(setCounter, newGroup);
				setCounter++;
			}
			newGroup.add(f1);
			newGroup.add(f2);
			friends.put(f1, newGroupNo);
			friends.put(f2, newGroupNo);
			if(oldGroup != null) {
				for(Integer acquaintance : oldGroup) {
					newGroup.add(acquaintance);
					friends.put(acquaintance, newGroupNo);
				}
				groups.remove(oldGroupNo);
			}
			latest = Math.max(latest, time);
			if(groups.size() == 1 && friends.size() == n && earliest == -1) {
				earliest = time;
			}			
        }
    	return earliest;
    }
}
