package com.algo.hashtable;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(new RomanToInteger().romanToInt("MMMCDLVI") );
	}
	
    public int romanToInt(String s) {
    	char[] chars = s.toCharArray();
    	Map<String, Integer> values = new HashMap<>();
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);

        String prevChar = chars[0] + "";
        int num = 0;
        int temp = values.get(prevChar+"");
        num = temp;
        for(int i = 1; i < chars.length; i++) {
    		if(prevChar != "" && values.get(prevChar + chars[i] + "") != null) {
    			num = num - temp;
    			temp = values.get(prevChar + chars[i] + "");
    			prevChar = "";
    		}else {
    			temp = values.get(chars[i] + "");
    			prevChar = chars[i] + "";
    		}
			num = num + temp;
    	}
		return num;
    }	
}
