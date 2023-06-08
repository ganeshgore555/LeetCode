package com.algo.design;

import java.util.HashMap;
import java.util.LinkedHashSet;

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
    		if(lessFrequentlyUsedKeys == null) {
    			lessFrequentlyUsedKeys = new LinkedHashSet<Integer>();
    			frequencyMap.put(minf, lessFrequentlyUsedKeys);
    		}
    		lessFrequentlyUsedKeys.add(key);
    	}else {
    		prevVal.value = value;
    		incrementFrequency(key);
    	}
    }
    
    private void incrementFrequency(int key) {
    	LFUValue lfuVal = map.get(key);
    	int oldFrequency = lfuVal.frequency;
    	int newFrequency = oldFrequency + 1;
    	lfuVal.frequency = newFrequency;
    	LinkedHashSet<Integer> frequencyKeySet = frequencyMap.get(oldFrequency);
    	if(frequencyKeySet != null) { 
    		frequencyKeySet.remove(key);
	    	if(frequencyKeySet.size() == 0) {
	    		frequencyMap.remove(oldFrequency);
	    		if(minf == oldFrequency)
	    			minf = newFrequency;
	    	}else
	    		minf = Math.min(minf, newFrequency);
    	}
    	LinkedHashSet<Integer> newFrequencyKeySet = frequencyMap.get(newFrequency);
    	if(newFrequencyKeySet == null) {
    		newFrequencyKeySet = new LinkedHashSet<Integer>();
    		frequencyMap.put(newFrequency, newFrequencyKeySet);
    	}
    	
    	newFrequencyKeySet.add(key);    	
    }    
}
