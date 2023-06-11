package com.algo.simulation;

import java.util.*;

public class MinimumTimeDifference {

	public static void main(String[] args) {
		String[] list = { "00:00", "23:59", "00:01", "01:02", "02:34" };
		List<String> timePoints = Arrays.asList(list);
		System.out.println(new MinimumTimeDifference().findMinDifference(timePoints));
	}

	public int findMinDifference(List<String> timePoints) {
		List<Integer[]> timeList = timePoints.stream()
		.map(
			t -> {
				Integer[] time = new Integer[2];
				time[0] = Integer.parseInt(t.split(":")[0]);
				time[1] = Integer.parseInt(t.split(":")[1]);
				return time;
			})
		.sorted((t1, t2) -> t1[0] == t2[0] ? t1[1] - t2[1] : t1[0] - t2[0])
		.toList();

		int diff = Integer.MAX_VALUE;
		int n = timeList.size();
		for (int i = 0; i < n-1 ; i++) {
			int diff1 = ((timeList.get(i+1)[0] * 60) + timeList.get(i+1)[1]) - ((timeList.get(i)[0] * 60) + timeList.get(i)[1]);
			int diff2 = 1440 - diff1;
			diff = Math.min(diff, Math.min(diff1, diff2)); 
		}
		
		if(n > 2) {
			int diff1 = ((timeList.get(n-1)[0] * 60) + timeList.get(n-1)[1]) - ((timeList.get(0)[0] * 60) + timeList.get(0)[1]);
			int diff2 = 1440 - diff1;
			diff = Math.min(diff, Math.min(diff1, diff2)); 
		}
		
		return diff;
	}
}
