package com.ds.medium.main;

import java.util.Arrays;

public class MinimizeMaximumOfArray {

	public static void main(String[] args) {
		int[] nums = {3,7,1,6};
		System.out.println(new MinimizeMaximumOfArray().minimizeArrayValue(nums));
	}

    public int minimizeArrayValue(int[] A) {
        long sum = 0, res = 0;
        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
            res = Math.max(res, (sum + i) / (i + 1));
        }
        return (int)res;
    }
}