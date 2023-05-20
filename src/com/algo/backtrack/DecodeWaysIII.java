package com.algo.backtrack;

import java.util.*;

public class DecodeWaysIII {

	public static void main(String[] args) {
		new DecodeWaysIII().possibleDecodings("126");
	}

	
    public void possibleDecodings(String s) {
		ArrayList<String> result = new ArrayList<>();
		StringBuffer buffer = new StringBuffer();
		char[] map = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		possibleDecodingsBacktrack(0,s,map,result,buffer);
		result.stream().forEach(System.out::println);
    }
    
	private void possibleDecodingsBacktrack(int start, String digits, char[] map, ArrayList<String> result, StringBuffer buffer) {
		if(start == digits.length()) {
			result.add(buffer.toString());
			return;
		}
		
		for(int i = start+1; i <= digits.length(); i++) {
			String num = digits.substring(start,i);
			if(num.startsWith("0") || Integer.parseInt(num) > 26)
				break;
			buffer.append(map[Integer.parseInt(num)]);
			possibleDecodingsBacktrack(i,digits,map,result,buffer);
			buffer.deleteCharAt(buffer.length()-1);
		}		

	}
    
}
