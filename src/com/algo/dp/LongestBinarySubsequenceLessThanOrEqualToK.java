package com.algo.dp;

public class LongestBinarySubsequenceLessThanOrEqualToK {

	public static void main(String[] args) {
		System.out.println(new LongestBinarySubsequenceLessThanOrEqualToK().longestSubsequence("1001010", 5));
	}

    public int longestSubsequence(String s, int k) {
        int sum = 0;
        int numOfOnes = 0;
        int numOfZeros = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                numOfZeros++;
            }
            else {
                sum += Math.pow(2, s.length() - 1 - i);
                if (sum <= k) {
                    numOfOnes++;
                }
            }
        }
        return numOfOnes + numOfZeros;
    }
}
