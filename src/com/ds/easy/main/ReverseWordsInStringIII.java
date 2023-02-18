package com.ds.easy.main;

public class ReverseWordsInStringIII {

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}

    public static String reverseWordsWithStringBuffer(String s) {
    	String[] words = s.split(" ");
    	StringBuffer sb = new StringBuffer(s.length());
    	for(String word : words) {
    		sb.append(reverseString(word.toCharArray())).append(" ");
    	}
		return sb.toString().trim();
    }

    public static String reverseWords(String s) {
    	String reverse = "";
    	int startIndex = 0;
    	for(int index = 0; index < s.length(); index++) {
    		if(s.charAt(index) == ' ') {
    			reverse = reverse + reverseString(s.substring(startIndex, index).toCharArray());
    			reverse = reverse + " ";
    			startIndex = index + 1;
    		}else if(index == s.length()-1) {
    			reverse = reverse + reverseString(s.substring(startIndex, index+1).toCharArray());
    			startIndex = index + 1;
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
