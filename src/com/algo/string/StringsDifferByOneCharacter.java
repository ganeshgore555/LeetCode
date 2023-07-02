package com.algo.string;

import java.util.HashSet;

public class StringsDifferByOneCharacter {

	public static void main(String[] args) {
		String[] dict = {"abcd","cccc","abyd","abab"};
		System.out.println(new StringsDifferByOneCharacter().differByOne(dict));
	}
	
	public boolean differByOneWithoutMathPow(String[] dict) {
		HashSet<Long> set = new HashSet<>();
		long mod = (long) Math.pow(10, 20) + 7;
    
		int len = dict[0].length();
		long[] word2hash = new long[dict.length];
		for (int i = 0; i < dict.length; i++) {
			for (int j = 0; j < len; j++) {
				word2hash[i] = (word2hash[i] * 26 + dict[i].charAt(j) - 'a') % mod;
			}
		}
    
		long base = 1;
		for (int j = len - 1; j >= 0; j--) {
			set.clear();
			for (int i = 0; i < dict.length; i++) {
				long newHash = (word2hash[i] - base * (dict[i].charAt(j) - 'a')) % mod;
				if (set.contains(newHash)) {
					return true;
				}
				set.add(newHash);
			}
			base = 26 * base % mod;
		}
    
		return false;
	}
	
	
	public boolean differByOne(String[] dict) {
		HashSet<Long> set = new HashSet<>();
		long mod = (long) Math.pow(10, 20) + 7;
    
		int len = dict[0].length();
		long[] word2hash = new long[dict.length];
		for (int i = 0; i < dict.length; i++) {
			for (int j = 0; j < len; j++) {
				word2hash[i] = (word2hash[i] +  (long) Math.pow(26, len-1-j) * (dict[i].charAt(j) - 'a')) % mod;
			}
		}
    
		for (int j = 0; j < len; j++) {
			set.clear();
			for (int i = 0; i < dict.length; i++) {
				long newHash = (word2hash[i] - (long) Math.pow(26, len-1-j) * (dict[i].charAt(j) - 'a')) % mod;
				if (set.contains(newHash)) {
					return true;
				}
				set.add(newHash);
			}
		}
    
		return false;
	}
	
}
