package com.algo.segmenttree;

import java.util.Arrays;
import java.util.TreeMap;

public class AmountOfNewAreaPaintedEachDay {

	public static void main(String[] args) {
		int[][] paint = { { 2, 4 }, { 1, 7 }, { 5, 8 } };
		Arrays.stream(new AmountOfNewAreaPaintedEachDay().amountPainted(paint)).forEach(System.out::println);
	}

	public int[] amountPainted(int[][] paint) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int[] res = new int[paint.length];
		
		for(int i = 0; i < paint.length; i++) {
			int start = paint[i][0];
			int end = paint[i][1];
			int area = end - start;
			while(map.floorKey(end) != null) {
				int prevstart = map.floorKey(end);
				int prevEnd = map.get(prevstart);
				if(start >= prevEnd) // start of new area comes after end of prev area, so no overlap  
					break;
				
				area = area - (Math.min(prevEnd, end) - Math.max(prevstart, start));
				start = Math.min(prevstart, start);
				end = Math.max(prevEnd, end);
				map.remove(prevstart);
			}
			res[i] = area;
			map.put(start, end);	
		}
		
		return res;
	}
}
