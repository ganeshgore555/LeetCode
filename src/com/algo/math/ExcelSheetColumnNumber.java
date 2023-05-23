package com.algo.math;

import java.util.HashMap;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.err.println(new ExcelSheetColumnNumber().titleToNumber("ZZ"));
		System.err.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
	}
    public int titleToNumber(String columnTitle) {
    	char[] chars = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    	HashMap<Character,Integer> map = new HashMap<Character, Integer>();  
    	for(int i = 1; i <= 26; i++)
    		map.put(chars[i], i);
    	
    	StringBuffer buffer = new StringBuffer(columnTitle);
    	int num = 0;
    	buffer.reverse();
    	for(int i = 0; i < buffer.length(); i++) {
    		num += map.get(buffer.charAt(i)) * Math.pow(26, i);
    	}
    	return num;
    }
}
