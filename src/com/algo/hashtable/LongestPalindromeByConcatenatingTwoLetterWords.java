package com.algo.hashtable;

import java.util.HashMap;

public class LongestPalindromeByConcatenatingTwoLetterWords {

	public static void main(String[] args) {
		String[] words = {"cc","aa","bb"};
		System.out.println(new LongestPalindromeByConcatenatingTwoLetterWords().longestPalindrome(words));
	}
    public int longestPalindrome(String[] words) {
    	HashMap<String,Integer> mirrorMap = new HashMap(); // e.g. ab, ba, ac, ad, ca
    	HashMap<String,Integer> monoMap = new HashMap(); // e.g. aa, bb, cc
    	int count = 0;
    	for(String word : words) {
    		String reverse = new StringBuffer(word).reverse().toString();
    		if(word.equals(reverse)) {
    			monoMap.put(word, monoMap.getOrDefault(word,0)+1);
    		}else if(mirrorMap.getOrDefault(reverse,0) > 0) {
    			mirrorMap.put(reverse, mirrorMap.getOrDefault(reverse,0)-1);
    			count+=4;
    		}else {
    			mirrorMap.put(word, mirrorMap.getOrDefault(word,0)+1);
    		}
    	}
    	
    	boolean middleAdjusted = false;
    	for(Integer value : monoMap.values()) {
    		if(value % 2 == 0) {
    			count += (2 * value);
    		}else {
    			if(!middleAdjusted) {
    				count += (2 * value);
    				middleAdjusted = true;
    			}else {
    				count += (2 * (value-1));
    			}
    		}
    	}
    	return count;
    }
}
