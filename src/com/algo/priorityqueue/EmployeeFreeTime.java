package com.algo.priorityqueue;

import java.util.*;

public class EmployeeFreeTime {

	public static void main(String[] args) {
		EmployeeFreeTime inst = new EmployeeFreeTime();
		int [][][] scheduleArr = {{{1,2},{5,6}},{{1,3}},{{4,10}}};
		List<List<Interval>> schedule = new ArrayList<>();
		for(int[][] empSchedules : scheduleArr) {
			ArrayList<Interval> list = new ArrayList<>();
			for(int[] s : empSchedules) {
				Interval i = inst.new Interval(s[0], s[1]);
				list.add(i);
			}
			schedule.add(list);
		}
		inst.employeeFreeTime(schedule).stream().forEach(System.out::println);
	}

	class Interval {
	    public int start;
	    public int end;

	    public Interval() {}

	    public Interval(int _start, int _end) {
	        start = _start;
	        end = _end;
	    }

		@Override
		public String toString() {
			return "["+ start + ", " + end + "]";
		}
	    
	};
	
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		PriorityQueue<Interval> queue = new PriorityQueue<Interval>((a,b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
		for(List<Interval> empSchedule : schedule){
			for(Interval i : empSchedule){
				queue.offer(i);
			}
		}		
		
		int lastEnd = queue.poll().end;
		List<Interval> result = new ArrayList();
		while(!queue.isEmpty()){
			Interval now = queue.poll();
			if(lastEnd < now.start){
				result.add(new Interval(lastEnd, now.start));
			}
			lastEnd = Math.max(lastEnd, now.end);			
		}
		return result;        
    }
}
