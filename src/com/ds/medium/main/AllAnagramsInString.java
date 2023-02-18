package com.ds.medium.main;

import java.util.ArrayList;
import java.util.List;

public class AllAnagramsInString {

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd","abc"));
	}

    public static List<Integer> findAnagrams(String s1, String s2) {
    	List anagramIndex = new ArrayList<Integer>();
        if (s2.length() > s1.length())
            return anagramIndex;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int start = 0;
        for (start = 0; start < s1.length() - s2.length(); start++) {
            if (matches(s1map, s2map))
                anagramIndex.add(start);
            s1map[s1.charAt(start + s2.length()) - 'a']++;
            s1map[s1.charAt(start) - 'a']--;
        }
        if (matches(s1map, s2map))
            anagramIndex.add(start);
        return anagramIndex;
    }
    
    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
	
}
