package com.algo.backtrack;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("243"));
	}

    public List<String> letterCombinations(String digits) {
    	
    	List<String> result = new ArrayList<>();
    	if(digits == null || digits.length() == 0)
    		return result;
    	
        Map<Character, String> letters = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    	
        StringBuffer buffer = new StringBuffer(); 
        
        letterCombinationsBacktract(letters, result, buffer, digits, 0);
        
		return result;
    }

	private void letterCombinationsBacktract(Map<Character, String> letters, List<String> result, StringBuffer buffer, String digits, int n) {
		if(buffer.length() == digits.length()) {
			result.add(buffer.toString());
			return;
		}
		
		String chars = letters.get(digits.charAt(n));
		for(char c : chars.toCharArray()) {
			buffer.append(c);
			letterCombinationsBacktract(letters, result, buffer, digits, n+1);
			buffer.deleteCharAt(buffer.length()-1);
		}
	}
	
}
