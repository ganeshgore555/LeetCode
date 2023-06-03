package com.algo.twopointer;

import java.util.*;

public class TheLatestTimeToCatchABus {

	public static void main(String[] args) {
		TheLatestTimeToCatchABus obj = new TheLatestTimeToCatchABus();
		int[] buses1 = {10,20};
		int[] passenger1 = {2,17,18,19};
		int capacity1 = 2;
		//System.out.println(obj.latestTimeCatchTheBus(buses1, passenger1, capacity1));
		
		int[] buses2 = {20,30,10};
		int[] passenger2 = {19,13,26,4,25,11,21};
		int capacity2 = 2;
		//System.out.println(obj.latestTimeCatchTheBus(buses2, passenger2, capacity2));

		int[] buses3 = {3};
		int[] passenger3 = {2,3};
		int capacity3 = 2;
		//System.out.println(obj.latestTimeCatchTheBus(buses3, passenger3, capacity3));
		
		int[] buses4 = {2};
		int[] passenger4 = {2};
		int capacity4 = 2;
		//System.out.println(obj.latestTimeCatchTheBus(buses4, passenger4, capacity4));
		
		int[] buses5 = {15,16,17,7,10,20,13,12};
		int[] passenger5 = {18,15,11,17,12,13,14,10,19,16};
		int capacity5 = 2;
		System.out.println(obj.latestTimeCatchTheBus(buses5, passenger5, capacity5));
	}

	public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
		Arrays.sort(buses);	
		Arrays.sort(passengers);
		
		int p=0;
		int b=0;
		
		HashSet<Integer> set = new HashSet<>(); 
		Arrays.stream(passengers).forEach(passenger -> set.add(passenger));
		
		int currentCap = 0;
		int latest = 1;
		while(b < buses.length && p < passengers.length){
			int pTime = passengers[p];
			int bTime = buses[b];
			
			if(pTime <= bTime && currentCap < capacity){
				if(p != 0 || pTime != 2){
					latest = findLatestTimeSlot(pTime-1,latest,set);
				}
				currentCap++;
				p++;
			}else{
				if(currentCap < capacity){
					latest = findLatestTimeSlot(bTime,latest,set);
				}	
				b++;
				currentCap = 0;
			}
		}

		if((b < buses.length-1) || (b == buses.length-1 && currentCap < capacity)){
			int bTime = buses[buses.length-1];
			latest = findLatestTimeSlot(bTime,latest,set);
		}		
		
		return latest;
	}

	private int findLatestTimeSlot(int bTime, int latest, HashSet<Integer> set) {
		for(int i = bTime; i > latest; i--) {
			if(!set.contains(i)) {
				latest = i;
				break;
			}
		}
		return latest;
	}
}
