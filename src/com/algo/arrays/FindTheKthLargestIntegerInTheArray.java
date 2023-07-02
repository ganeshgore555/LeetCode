package com.algo.arrays;

import java.util.*;

public class FindTheKthLargestIntegerInTheArray {

	public static void main(String[] args) {
		String[] nums = {"3","6","7","10"};
		int k = 4;
		System.out.println(new FindTheKthLargestIntegerInTheArray().kthLargestNumber(nums, k));
	}

	public String kthLargestNumber(String[] nums, int k) {
		Arrays.sort(nums, (a,b) -> (a.length() == b.length() ? a.compareTo(b) : Integer.compare(a.length(), b.length())));
		return nums[nums.length-k];
	}

}
