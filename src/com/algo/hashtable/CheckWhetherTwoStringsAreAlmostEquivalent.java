package com.algo.hashtable;

import java.util.HashMap;

public class CheckWhetherTwoStringsAreAlmostEquivalent {

	public static void main(String[] args) {
		System.out.println(new CheckWhetherTwoStringsAreAlmostEquivalent().checkAlmostEquivalent("aaaa", "bccb"));
	}

    public boolean checkAlmostEquivalent(String word1, String word2) {
    	HashMap<Character, Integer> map = new HashMap<>(); 
    	for(char ch : word1.toCharArray()) {
    		map.put(ch, map.getOrDefault(ch, 0) + 1);
    	}
    	for(char ch : word2.toCharArray()) {
    		map.put(ch, map.getOrDefault(ch, 0) - 1);
    	}
		for(char key : map.keySet()) {
			if(Math.abs(map.get(key)) > 3)
					return false;
		}
		return true;
    }
}
