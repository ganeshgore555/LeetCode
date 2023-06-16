package com.algo.arrays;

public class LexicographicallySmallestStringAfterSubstringOperation {

	// 'a' in prefix is good, skip all 'a' in the beginning.
	// If all characters are 'a', change the last char to 'z'.
	// From the first char not 'a', decrease them, until next 'a'.
	
	public static void main(String[] args) {
		System.out.println(new LexicographicallySmallestStringAfterSubstringOperation().smallestString("cbabc"));
	}

    public String smallestString(String s) {
        int i = 0, n = s.length();
        char[] A = s.toCharArray();
        while (i < n && A[i] == 'a')
            i++;
        if (i == n)
            A[n - 1] = 'z';
        while (i < n && A[i] != 'a')
            --A[i++];
        return String.valueOf(A);
    }
}
