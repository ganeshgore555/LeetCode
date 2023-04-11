package com.algo.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringBruteForce("aabadbccab"));
		System.out.println(lengthOfLongestSubstringHashSet("aabadbccab"));
		System.out.println(lengthOfLongestSubstringHashMap("aabadbccab"));
	}

    public static int lengthOfLongestSubstringBruteForce(String s) {
    	char[] input = s.toCharArray();
    	int max = 0;
    	String tempString = "";
		for(int i=0; i < s.length(); i++) {
			for(int j=i; j < s.length(); j++) {
				if(!tempString.contains(input[j] + "")) {
					tempString = tempString + input[j];
					if(tempString.length() > max) {
						max = tempString.length(); 
					}
				}else {
					if(tempString.length() > max) {
						max = tempString.length(); 
					}
					tempString = "";
					break;
				}
			}
		}
		return max;
    }
    
    public static int lengthOfLongestSubstringHashSet(String s) {
    	char[] input = s.toCharArray();
    	int max = 0;
    	HashSet<Character> set = new HashSet();
		for(int i=0; i < s.length(); i++) {
			for(int j=i; j < s.length(); j++) {
				if(!set.contains(input[j])) {
					set.add(input[j]);
					if(set.size() > max) {
						max = set.size(); 
					}
				}else {
					if(set.size() > max) {
						max = set.size(); 
					}
					set = new HashSet();
					break;
				}
			}
		}
		return max;
    }
    
    public static int lengthOfLongestSubstringHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }
            map.put(currentChar, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }    
}
