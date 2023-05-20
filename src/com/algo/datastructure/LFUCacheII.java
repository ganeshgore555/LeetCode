package com.algo.datastructure;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class LFUCacheII {
	
	public static void main(String[] args) {
		
		/*
		LFUCacheII cache = new LFUCacheII(2);
		cache.put(2, 1);
		cache.put(2, 2);
		cache.get(2);
		cache.put(1, 1);
		cache.put(4, 1);		
		System.out.println(cache.get(2)); // 2
		*/
		
		/*
		LFUCacheII cache = new LFUCacheII(2);
		cache.get(2);
		cache.put(2, 6);
		cache.get(1);
		cache.put(1, 5);
		cache.put(1, 2);		
		System.out.println(cache.get(1)); // 2
		System.out.println(cache.get(2)); // 6
		*/
		
		/*
		LFUCacheII cache = new LFUCacheII(2);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
		System.out.println(cache.get(1)); // -1
		System.out.println(cache.get(2)); // 3
		*/
		
		
		
		LFUCacheII cache = new LFUCacheII(3);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.get(4);
		cache.get(3);
		cache.get(2);
		cache.get(1);
		cache.put(5, 5);
		System.out.println(cache.get(1)); //-1
		System.out.println(cache.get(2)); // 2
		System.out.println(cache.get(3)); // 3
		System.out.println(cache.get(4)); //-1
		System.out.println(cache.get(5)); // 5
	}
	
	
	HashMap<Integer, LFUValue> map;
	HashMap<Integer, LinkedHashSet<Integer>> frequencyMap;
	int capacity;
	int minf = 0;
	
	final class LFUValue{
		Integer frequency;
		Integer value;
		private LFUValue(Integer frequency, Integer value) {
			super();
			this.frequency = frequency;
			this.value = value;
		}
	}
		
    public LFUCacheII(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        frequencyMap = new HashMap<>(capacity);
    }
    
    public int get(int key) {
		int val = map.getOrDefault(key,-1);
		if(val != -1) {
    		incrementFrequency(key);
		}
		return val;	
    }
    
    public void put(int key, int value) {
    	LFUValue prevVal = map.get(key);
    	if(map.size() >= capacity && prevVal == null) {
    		LinkedHashSet<Integer> keys = frequencyMap.get(minf);
    		keys.iterator().next();
    	}
    	map.put(key, value);
    	if(prevVal == null) {
	    	frequencyMap.put(key, 1);
	    	LFUKey newKey = new LFUKey(key, 1, System.nanoTime());
	    	lfuList.offer(newKey);
    	}else {
    		incrementFrequency(key);
    	}
    }
    
    private void incrementFrequency(int key) {
		Integer frequency = frequencyMap.get(key);
		LFUKey tempKey = new LFUKey(key, frequency, System.nanoTime());
		lfuList.remove(tempKey);
		LFUKey newKey = new LFUKey(key, frequency+1, System.nanoTime());
		lfuList.offer(newKey);
		frequencyMap.put(key, frequency+1);
    }
    
}
