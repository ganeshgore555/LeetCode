package com.algo.design;

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
	int minf = 1;
	
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
    	LFUValue lfuVal = map.get(key);
		if(lfuVal != null) {
    		incrementFrequency(key);
    		return lfuVal.value;
		}
		return -1;	
    }
    
    public void put(int key, int value) {
    	LFUValue prevVal = map.get(key);
    	if(map.size() >= capacity && prevVal == null) {
    		LinkedHashSet<Integer> lessFrequentlyUsedKeys = frequencyMap.get(minf);
    		if(lessFrequentlyUsedKeys != null && lessFrequentlyUsedKeys.size() > 0) {
    			Integer keyToDelete = lessFrequentlyUsedKeys.iterator().next();
    			map.remove(keyToDelete);
    			lessFrequentlyUsedKeys.remove(keyToDelete);
    			if(lessFrequentlyUsedKeys.size() == 0)
    				frequencyMap.remove(minf);
    		}
    	}
    	if(prevVal == null) {
    		LFUValue lfuVal = new LFUValue(1, value);
    		map.put(key, lfuVal);
    		minf = 1;
    		LinkedHashSet<Integer> lessFrequentlyUsedKeys = frequencyMap.get(minf);
	    	LFUValue lfuValue = new LFUValue(key, 1);
	    	lfuList.offer(newKey);
    	}else {
    		incrementFrequency(key);
    	}
    }
    
    private void incrementFrequency(int key) {
    	LFUValue lfuVal = map.get(key);
    	int oldFrequency = lfuVal.frequency;
    	int newFrequency = oldFrequency++;
    	lfuVal.frequency = newFrequency;
    	LinkedHashSet<Integer> frequencyKeySet = frequencyMap.get(oldFrequency);
    	frequencyKeySet.remove(key);
    	if(frequencyKeySet.size() == 0) {
    		frequencyMap.remove(lfuVal.frequency);
    		if(minf == oldFrequency)
    			minf = newFrequency;
    	}else
    		minf = Math.min(minf, newFrequency);
    	
    	LinkedHashSet<Integer> newFrequencyKeySet = frequencyMap.get(newFrequency);
    	if(newFrequencyKeySet == null) {
    		newFrequencyKeySet = new LinkedHashSet<Integer>();
    		frequencyMap.put(newFrequency, newFrequencyKeySet);
    	}
    	
    	newFrequencyKeySet.add(key);    	
    }
    
}
