package com.algo.backtrack;

import java.util.*;

public class DecodeWaysII {

	public static void main(String[] args) {
		new DecodeWaysII().numDecodings("*");
	}

	
    public int numDecodings(String s) {
		memo = new int[s.length()];
		for(int i = 0; i < memo.length; i++)
			memo[i] = -1;
		char[] map = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		return numDecodingsBacktrack(0,s,map);
    }
    
    int[] memo; 
    
	private int numDecodingsBacktrack(int start, String digits, char[] map) {
		if(start == digits.length()) {
			return 1;
		}
		
		if(memo[start] != -1)
			return memo[start];
		
		int count = 0;
		for(int i = start+1; i <= digits.length(); i++) {
			if(digits.charAt(i) == '*') {
				for(int j = 1; j <= 9; j++) {
					String num = digits.substring(start,i-1) + j;
					if(num.startsWith("0") || Integer.parseInt(num) > 26)
						break;			
					count = count + numDecodingsBacktrack(i,digits,map);
				}
			}else {			
				String num = digits.substring(start,i);
				if(num.startsWith("0") || Integer.parseInt(num) > 26)
					break;			
				count = count + numDecodingsBacktrack(i,digits,map);
			}
		}		
		memo[start] = count;
		return memo[start];
	}
    
}
