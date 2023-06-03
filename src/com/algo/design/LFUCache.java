package com.algo.design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class LFUCache {
	
	public static void main(String[] args) {
		
		/*
		LFUCache cache = new LFUCache(2);
		cache.put(2, 1);
		cache.put(2, 2);
		cache.get(2);
		cache.put(1, 1);
		cache.put(4, 1);		
		System.out.println(cache.get(2)); // 2
		*/
		
		/*
		LFUCache cache = new LFUCache(2);
		cache.get(2);
		cache.put(2, 6);
		cache.get(1);
		cache.put(1, 5);
		cache.put(1, 2);		
		System.out.println(cache.get(1)); // 2
		System.out.println(cache.get(2)); // 6
		*/
		
		/*
		LFUCache cache = new LFUCache(2);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
		System.out.println(cache.get(1)); // -1
		System.out.println(cache.get(2)); // 3
		*/
		
		
		
		LFUCache cache = new LFUCache(3);
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
	
	
	HashMap<Integer, Integer> map;
	HashMap<Integer, Integer> frequencyMap;
	int capacity;
	PriorityQueue<LFUKey> lfuList;
	
	final class LFUKey{
		Integer key;
		Integer frequency;
		Long time;
		
		private LFUKey(Integer key, Integer frequency, Long time) {
			super();
			this.key = key;
			this.frequency = frequency;
			this.time = time;
		}

		
		public Long getTime() {
			return time;
		}

		public Integer getKey() {
			return key;
		}

		public Integer getFrequency() {
			return frequency;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(key);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LFUKey other = (LFUKey) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(key, other.key);
		}
		private LFUCache getEnclosingInstance() {
			return LFUCache.this;
		}
	}
		
    public LFUCache(int capacity) {
    	Comparator<LFUKey> comparator = Comparator.comparing(LFUKey::getFrequency).thenComparing(LFUKey::getTime);
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        frequencyMap = new HashMap<>(capacity);
        lfuList = new PriorityQueue<>(comparator);
    }
    
    public int get(int key) {
		int val = map.getOrDefault(key,-1);
		if(val != -1) {
    		incrementFrequency(key);
		}
		return val;	
    }
    
    public void put(int key, int value) {
    	Integer prevVal = map.get(key);
    	if(map.size() >= capacity && prevVal == null) {
    		LFUKey lfuKey = lfuList.poll();
    		map.remove(lfuKey.getKey());
    		frequencyMap.remove(lfuKey.getKey());    		
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
