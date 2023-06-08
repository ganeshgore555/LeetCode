package com.algo.design;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarI {

	public static void main(String[] args) {
		MyCalendarI obj = new MyCalendarI();
		System.out.println(obj.book(23,32));//true
		System.out.println(obj.book(42,50));//true
		System.out.println(obj.book(6,14));//true
		System.out.println(obj.book(0,7));//false
		System.out.println(obj.book(21,30));//false
		System.out.println(obj.book(26,31));//false
		System.out.println(obj.book(46,50));//false
		System.out.println(obj.book(28,36));//false
		System.out.println(obj.book(0,6));//true
		System.out.println(obj.book(27,36));//false
	}
	
	TreeMap<Integer,Integer> calendar = new TreeMap<>();
	
    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
