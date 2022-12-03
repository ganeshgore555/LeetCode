package com.ds.easy.main;

public class ReverseWordsInString {

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}

    public static String reverseWords(String s) {
    	String[] words = s.split(" ");
    	StringBuffer sb = new StringBuffer(s.length());
    	for(String word : words) {
    		sb.append(reverseString(word.toCharArray())).append(" ");
    	}
		return sb.toString().trim();
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
