package com.algo.string;

public class BreakAPalindrome {

	public static void main(String[] args) {
		System.out.println(new BreakAPalindrome().breakPalindrome("abccba"));
		System.out.println(new BreakAPalindrome().breakPalindrome("aa"));
	}

    public String breakPalindrome(String palindrome) {
        char[] arr = palindrome.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != 'a') {
            	arr[i] = 'a';
                return String.valueOf(arr);
            }
        }
        arr[n - 1] = 'b'; //if all 'a'
        return n < 2 ? "" : String.valueOf(arr);
    }
}
