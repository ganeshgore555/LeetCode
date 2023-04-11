package com.algo.twopointer;

public class ReverseString {

	public static void main(String[] args) {
		char[] s = {'h','e','l','l','o'};
		reverseString(s);
	}

    public static void reverseString(char[] s) {
        int low = 0;
        int high = s.length-1;
        while(low <= high) {
        	char temp = s[low];
        	s[low] = s[high];
        	s[high] = temp;
        	low++;
        	high--;
        }        
    }
}
