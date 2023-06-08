package com.algo.design;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarIII {

	public static void main(String[] args) {
		MyCalendarIII obj = new MyCalendarIII();
		System.out.println(obj.book(23,32));//true
		System.out.println(obj.book(42,50));//true
		System.out.println(obj.book(6,14));//true
		System.out.println(obj.book(0,7));//true
		System.out.println(obj.book(21,30));//true
		System.out.println(obj.book(26,31));//false
		System.out.println(obj.book(46,50));//true
		System.out.println(obj.book(28,36));//false
		System.out.println(obj.book(0,6));//true
		System.out.println(obj.book(27,36));//false
	}
	
	TreeMap<Integer,Integer> calendar = new TreeMap<>();
	int max = 0;
    public int book(int start, int end) {
    	calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d: calendar.values()) {
            active += d;
            max = Math.max(max, active);
        }
        return max;
    }
}
