package com.algo.dp;

public class LongestCommonSubsequence {

	private int[][] memo;
	private String text1;
	private String text2;

	public int longestCommonSubsequence(String text1, String text2) {
		// Make the memo big enough to hold the cases where the pointers
		// go over the edges of the strings.
		this.memo = new int[text1.length() + 1][text2.length() + 1];
		// We need to initialise the memo array to -1's so that we know
		// whether or not a value has been filled in. Keep the base cases
		// as 0's to simplify the later code a bit.
		for (int i = 0; i < text1.length(); i++) {
			for (int j = 0; j < text2.length(); j++) {
				this.memo[i][j] = -1;
			}
		}
		this.text1 = text1;
		this.text2 = text2;
		return memoSolve(0, 0);
	}

	private int memoSolve(int p1, int p2) {
		// Check whether or not we've already solved this subproblem.
		// This also covers the base cases where p1 == text1.length
		// or p2 == text2.length.
		if (memo[p1][p2] != -1) {
			return memo[p1][p2];
		}

		// Recursive cases.
		int answer = 0;
		if (text1.charAt(p1) == text2.charAt(p2)) {
			answer = 1 + memoSolve(p1 + 1, p2 + 1);
		} else {
			answer = Math.max(memoSolve(p1, p2 + 1), memoSolve(p1 + 1, p2));
		}

		// Add the best answer to the memo before returning it.
		memo[p1][p2] = answer;
		return memo[p1][p2];
	}

	public static void main(String[] args) {
		System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcede", "ace"));
	}

	public int longestCommonSubsequenceBottomUp(String text1, String text2) {

		// If text1 doesn't reference the shortest string, swap them.
		if (text2.length() < text1.length()) {
			String temp = text1;
			text1 = text2;
			text2 = temp;
		}

		// The previous and current column starts with all 0's and like
		// before is 1 more than the length of the first word.
		int[] previous = new int[text1.length() + 1];
		int[] current = new int[text1.length() + 1];

		// Iterate through each column, starting from the last one.
		for (int col = text2.length() - 1; col >= 0; col--) {
			for (int row = text1.length() - 1; row >= 0; row--) {
				if (text1.charAt(row) == text2.charAt(col)) {
					current[row] = 1 + previous[row + 1];
				} else {
					current[row] = Math.max(previous[row], current[row + 1]);
				}
			}
			// The current column becomes the previous one, and vice versa.
			int[] temp = previous;
			previous = current;
			current = temp;
		}

		// The original problem's answer is in previous[0]. Return it.
		return previous[0];
	}
}
