package com.algo.hashtable;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
	}

    public int lengthOfLongestSubstring(String s) {
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
