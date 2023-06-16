package com.algo.twopointer;

import java.util.Map;

public class SwapAdjacentInLRString {
	// XL -> LX and RX -> XR
	public static void main(String[] args) {
		//String start = "XXXXXLXXXX", end = "LXXXXXXXXX";
		//String start = "RXXLRXRXL", end = "XRLXXRRLX";
		String start = "LXXLXRLXXL", end = "XLLXRXLXLX";
		System.out.println(new SwapAdjacentInLRString().canTransform(start, end));
	}

    public boolean canTransform(String start, String end) {
        int n = start.length();
        char[] f = start.toCharArray();
        char[] s = end.toCharArray();
        int i = 0;
        int j = 0;
        while(true) {
            while(i < n && f[i] == 'X') i++;
            while(j < n && s[j] == 'X') j++;
            if(i == f.length || j == s.length) break;
            if(f[i] != s[j] || (f[i] == 'R' && i > j) || (f[i] == 'L' && i < j)){
                return false;
            }
            i++;
            j++;
        }
        return i == j;
    }
    
}
