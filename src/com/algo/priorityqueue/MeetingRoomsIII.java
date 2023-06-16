package com.algo.priorityqueue;

import java.util.*;

public class MeetingRoomsIII {

	public static void main(String[] args) {
		int n = 2;
		int[][] meetings = { { 0, 10 }, { 1, 2 }, { 12, 14 }, { 13, 15 } };
		int[][] meetingsTestCase1 = { { 0, 10 }, { 1, 2 }, { 8, 16 }, { 9, 20 }, { 12, 14 }, { 13, 15 } };
		System.out.println(new MeetingRoomsIII().mostBookedOld(n, meetings));
		System.out.println(new MeetingRoomsIII().mostBookedOld(n, meetingsTestCase1));
		System.out.println(new MeetingRoomsIII().mostBooked(n, meetings));
		System.out.println(new MeetingRoomsIII().mostBooked(n, meetingsTestCase1));
	}

	public int mostBookedOld(int n, int[][] meetings) {
		Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
		PriorityQueue<Integer> rooms = new PriorityQueue<>();
		PriorityQueue<Integer[]> roomAlloted = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		int[] usage = new int[n];

		for (int i = 0; i < n; i++)
			rooms.offer(i);

		int meetingNo = 0;
		int time = 0;
		while (meetingNo < meetings.length) {
			if (!roomAlloted.isEmpty() && roomAlloted.peek()[0] <= time) {
				rooms.offer(roomAlloted.poll()[2]);
			}
			if (meetings[meetingNo][0] <= time && !rooms.isEmpty()) {
				Integer roomAvail = rooms.poll();
				Integer endTime = (meetings[meetingNo][1] - meetings[meetingNo][0]) + time;
				usage[roomAvail]++;
				Integer[] allotRoom = { endTime, meetingNo, roomAvail };
				roomAlloted.offer(allotRoom);
				meetingNo++;
			}
			time++;
		}

		int max = 0;
		int maxRoom = 0;
		for (int i = 0; i < n; i++) {
			if (usage[i] > max) {
				max = usage[i];
				maxRoom = i;
			}

		}
		return maxRoom;
	}

	public int mostBooked(int n, int[][] meetings) {
		Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
		// available rooms
		var rooms = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++)
			rooms.add(i);

		// { meeting end, room taken } -> sort by end time and by room number
		var runningMeetings = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		// room usage count
		var count = new int[n];
		for (int[] meeting : meetings) {
			// return room to available if meeting has ended
			while (!runningMeetings.isEmpty() && runningMeetings.peek()[0] <= meeting[0])
				rooms.add(runningMeetings.poll()[1]);

			var delayedStart = meeting[0];
			if (rooms.isEmpty()) { // no available rooms, adjust the next meeting start time with delay
				var await = runningMeetings.poll();
				delayedStart = await[0];
				rooms.add(await[1]);
			}

			// schedule the next meeting
			var room = rooms.poll();
			count[room]++;
			runningMeetings.add(new int[] { delayedStart + meeting[1] - meeting[0], room });
		}

		// find the most used room
		var maxIdx = 0;
		for (int r = 0; r < count.length; r++)
			if (count[maxIdx] < count[r])
				maxIdx = r;

		return maxIdx;
	}
}
