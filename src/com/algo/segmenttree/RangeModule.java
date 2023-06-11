package com.algo.segmenttree;

import java.util.*;

public class RangeModule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	TreeMap<Integer,Integer> map; 
	
    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        int start = left;
        int end = right;

        while(map.floorKey(end) != null) {
        	int prevStart = map.floorKey(end);
        	int prevEnd = map.get(prevStart);
        	if(start >= prevEnd)
        		break;
        	
        	start = Math.min(start, prevStart);
        	end = Math.max(end, prevEnd);
        	map.remove(prevStart);
        }
        map.put(start, end);        
    }
    
    public boolean queryRange(int left, int right) {
        int start = left;
        int end = right;
        
        while(map.floorKey(end) != null) {
        	int prevStart = map.floorKey(end);
        	int prevEnd = map.get(prevStart);
        	
        	if(prevEnd < end)
        		break;
        	
        	if(prevStart < start)
        		return true;
        	
        	end = prevStart;        	
        }        
        return false;
    }
    
    public void removeRange(int left, int right) {
        
    }
}
