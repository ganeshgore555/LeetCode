package com.algo.hashtable;

import java.util.HashMap;

public class ValidAnagram {

	public static void main(String[] args) {
		

	}

    public boolean isAnagram(String s, String t) {
    	int[] letters = new int[26];
    	for(char c : s.toCharArray())
    		letters[c - 'a']++;
    	
    	for(char c : t.toCharArray())
    		letters[c - 'a']--;

    	for(int i = 0; i < letters.length; i++) {
    		if(letters[i] != 0)
    			return false;
    	}
		return true;        
    }
}
