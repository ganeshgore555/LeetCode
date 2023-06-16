package com.algo.segmenttree;

import java.util.*;

public class RangeModule {

	public static void main(String[] args) {
		RangeModule rm = new RangeModule();
		rm.addRange(10,180);
		rm.addRange(150,200);
		rm.addRange(250,500);
		rm.queryRange(50,100);
		rm.queryRange(180,300);
		rm.queryRange(600,1000);
		rm.removeRange(50,150);
		rm.queryRange(50,100);
	}

	TreeMap<Integer,Integer> map; 
	
    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        int start = left;
        int end = right;

        while(map.floorKey(end-1) != null) {
        	int prevStart = map.floorKey(end-1);
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
        
        while(map.floorKey(end-1) != null) {
        	int prevStart = map.floorKey(end-1);
        	int prevEnd = map.get(prevStart);
        	
        	if(prevEnd < end)
        		break;
        	
        	if(prevStart <= start)
        		return true;
        	
        	end = prevStart;        	
        }        
        return false;
    }
    
    public void removeRange(int left, int right) {
        int start = left;
        int end = right;
        
        while(map.floorKey(end-1) != null) {
        	int prevStart = map.floorKey(end-1);
        	int prevEnd = map.get(prevStart);
        	
        	if(prevEnd < start)
        		break;
        	
        	if(prevEnd <= end) {
        		if(prevStart >= start) {
        			map.remove(prevStart);
        			end = prevStart;
        		}else {
        			map.remove(prevStart);
        			map.put(prevStart, start);
        			break;
        		}
        	}else {
        		if(prevStart >= start) {
        			map.remove(prevStart);
        			map.put(end, prevEnd);
        			end = prevStart;
        		}else {
        			map.remove(prevStart);
        			map.put(prevStart, start);
        			map.put(end, prevEnd);
        			break;
        		}
        		
        	}
        }
    }
}
