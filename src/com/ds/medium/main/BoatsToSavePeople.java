package com.ds.medium.main;

import java.util.Arrays;

public class BoatsToSavePeople {

	public static void main(String[] args) {
		int[] people = {2,2,3,1};
		int limit = 3;
		System.out.println(new BoatsToSavePeople().numRescueBoats(people, limit));
	}

    public int numRescueBoats(int[] people, int limit) {
    	Arrays.sort(people);
    	int start = 0;
    	int end = people.length-1;
    	int count = 0;
    	while(start <= end) {
    		if(people[end] == limit) {
    			end--;
    			count++;
    		}else if(people[end] < limit && (people[end]+people[start]) <= limit) {
    			end--;
    			start++;
    			count++;
    		}else {
    			end--;
    			count++;
    		}
    	}
		return count;
    }
	
}
