package com.algo.twopointer;

public class ReverseWordsInString {

	public static void main(String[] args) {
		String s = " Let's take  LeetCode contest ";
		System.out.println(reverseWords(s));
	}

    public static String reverseWords(String s) {
    	s = reverseString(s.toCharArray());
    	String reverse = "";
    	int startIndex = 0;
    	boolean prevChar = false;
    	for(int index = 0; index < s.length(); index++) {
    		if(s.charAt(index) == ' ') {
    			if(prevChar)
    			{	
    				reverse = reverse + (reverse.length() == 0 ? "" : " ") + reverseString(s.substring(startIndex, index).toCharArray());
    			}
    			prevChar = false;
    			startIndex = index + 1;
    		}else if(index == s.length()-1) {
    			reverse = reverse + (reverse.length() == 0 ? "" : " ") + reverseString(s.substring(startIndex, index+1).toCharArray());
    			startIndex = index + 1;
    		}else {
    			prevChar = true;
    		}
    	}
    	return reverse;
    }
    
    public static String reverseString(char[] s) {
        int low = 0;
        int high = s.length-1;
        while(low <= high) {
        	char temp = s[low];
        	s[low] = s[high];
        	s[high] = temp;
        	low++;
        	high--;
        }
        return new String(s);
    }
}
