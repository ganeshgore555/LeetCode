package com.algo.design;

import java.util.HashMap;

public class LoggerRateLimiter {

	public static void main(String[] args) {
		LoggerRateLimiter obj = new LoggerRateLimiter();
		System.out.println(obj.shouldPrintMessage(1, "foo"));
		System.out.println(obj.shouldPrintMessage(2, "bar"));
		System.out.println(obj.shouldPrintMessage(3, "foo"));
		System.out.println(obj.shouldPrintMessage(8, "bar"));
		System.out.println(obj.shouldPrintMessage(10, "foo"));
		System.out.println(obj.shouldPrintMessage(11, "foo"));
		
	}

	
	HashMap<String,Integer> map; 
	
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
    	Integer lastTime = map.get(message);
    	if(lastTime != null && timestamp < lastTime + 10)
    		return false;

    	map.put(message, timestamp);
		return true;
    }
	
}
