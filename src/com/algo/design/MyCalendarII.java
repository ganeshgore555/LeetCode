package com.algo.design;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarII {

	public static void main(String[] args) {
		MyCalendarII obj = new MyCalendarII();
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
	
    public boolean book(int start, int end) {
    	calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d: calendar.values()) {
            active += d;
            if (active >= 3) {
                calendar.put(start, calendar.get(start) - 1);
                calendar.put(end, calendar.get(end) + 1);
                if (calendar.get(start) == 0)
                    calendar.remove(start);
                return false;
            }
        }
        return true;
    }
}
