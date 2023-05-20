package com.algo.twopointer;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsII {

	public static void main(String[] args) {
		int[][] intervals1 = {{1,6},{2,4},{1,5},{3,4}};
		System.out.println(new MeetingRoomsII().minMeetingRooms(intervals1));
		int[][] intervals2 = {{0,30},{5,10},{15,20}};
		System.out.println(new MeetingRoomsII().minMeetingRooms(intervals2));
	}

    public int minMeetingRooms(int[][] intervals) {
    	int[] start = new int[intervals.length];
    	int[] end = new int[intervals.length];
        int i = 0;
        for(int[] interval : intervals) {
        	start[i] = interval[0];
        	end[i] = interval[1];
        	i++;
        }     	
        Arrays.sort(start);
        Arrays.sort(end);        
        int startPtr = 0;
        int endPtr = 0;
        int room = 0;
        int max = 0;
        while(startPtr < start.length) {
        	if(start[startPtr] < end[endPtr] ) {
        		room++;
        		startPtr++;
        	}
        	else {
        		room--;
        		endPtr++;
        	}
        	max = Math.max(room, max);
        }
		return max;
    }
	
	
}
