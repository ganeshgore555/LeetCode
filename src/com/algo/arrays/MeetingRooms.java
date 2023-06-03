package com.algo.arrays;

import java.util.Arrays;

public class MeetingRooms {

	public static void main(String[] args) {
		int[][] intervals = {{0,30},{5,10},{15,20}};
		int[][] intervals2 = {{0,2},{5,10},{15,20}};
		System.out.println(new MeetingRooms().canAttendMeetings(intervals));
		System.out.println(new MeetingRooms().canAttendMeetings(intervals2));
	}
    public boolean canAttendMeetings(int[][] intervals) {
    	//Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
    	Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;    	
    }
}
