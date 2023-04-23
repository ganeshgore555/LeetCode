package com.algo.dp;

public class RestoreTheArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int numberOfArrays(String s, int k) {
        Integer[] memo = new Integer[s.length()]; // memo[i] is number of ways to print valid arrays from string s start at i
        return numberOfArraysDFS(s, k, 0, memo);
    }
    int numberOfArraysDFS(String s, long k, int i, Integer[] memo) {
        if (i == s.length()) return 1; // base case -> Found a valid way
        if (s.charAt(i) == '0') return 0; // all numbers are in range [1, k] and there are no leading zeros -> So numbers starting with 0 mean invalid!
        if (memo[i] != null) return memo[i];
        int ans = 0;
        long num = 0;
        for (int j = i; j < s.length(); j++) {
            num = num * 10 + s.charAt(j) - '0'; // num is the value of the substring s[i..j]
            if (num > k) break; // num must be in range [1, k]
            ans += numberOfArraysDFS(s, k, j + 1, memo);
            ans %= 1_000_000_007;
        }
        return memo[i] = ans;
    }	
}
