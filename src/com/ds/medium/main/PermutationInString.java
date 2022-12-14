package com.ds.medium.main;

import java.util.HashMap;

public class PermutationInString {

	public static void main(String[] args) {
		System.out.println(checkInclusion("ada","dcdaa"));
	}

    public static boolean checkInclusion(String s1, String s2) {        
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        int toFit = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) toFit += count[i];
        }
        if (toFit == 0) return true;
        for (int i = len1; i < len2; i++) {
            if (++count[s2.charAt(i - len1) - 'a'] > 0) toFit++;
            if (count[s2.charAt(i) - 'a']-- > 0) toFit--;
            if (toFit == 0) return true;
        }
        return false;
    }
    
}
