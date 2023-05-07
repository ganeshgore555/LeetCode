package com.algo.arrays;

import java.util.HashMap;

public class CheckWhetherTwoStringsAreAlmostEquivalent {

	public static void main(String[] args) {
		System.out.println(new CheckWhetherTwoStringsAreAlmostEquivalent().checkAlmostEquivalent("aaa", "bccb"));
	}

    public boolean checkAlmostEquivalent(String word1, String word2) {
    	int[] frequency = new int[26];
    	
    	for(char ch : word1.toCharArray()) {
    		frequency[ch - 'a']++;
    	}
    	
    	for(char ch : word2.toCharArray()) {
    		frequency[ch - 'a']--;
    	}
		
    	for(int f : frequency)
			if(Math.abs(f) > 3)
					return false;
		
		return true;
    }
}
