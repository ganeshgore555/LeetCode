package com.ds.medium.main;

import java.util.HashMap;

public class OptimalPartitionOfString {

	public static void main(String[] args) {
		String s = "shkqbyutdvknyrpjof";
		System.out.println(new OptimalPartitionOfString().partitionString(s));
	}

    public int partitionString(String s) {    	
    	HashMap<Character, Integer> map = new HashMap();
    	int count = 1;
    	int start = 0;
    	char lastDupe = '-';
    	char lastToLastDupe = '-';
        for(int i = 0; i < s.length(); i++) {
        	Integer prevIndex = map.get(s.charAt(i));
        	if(prevIndex != null && start <= prevIndex)
        	{
        		start = prevIndex + 1;
        		count++;
        		if(lastDupe != '-' && lastToLastDupe != '-' && lastToLastDupe != lastDupe && lastDupe != s.charAt(i)) {
        			count--;
        			start = map.get(lastDupe)+1;
        		}
        		if(lastDupe == '-') {
        			lastDupe = s.charAt(i);
        		}else{
        			lastToLastDupe = lastDupe;
        			lastDupe = s.charAt(i);
        		}	
        	}
        	map.put(s.charAt(i), i);
        }        
        return count;	
    }
}
