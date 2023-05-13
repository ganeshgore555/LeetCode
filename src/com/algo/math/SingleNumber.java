package com.algo.math;

import java.util.HashMap;

public class SingleNumber {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 4, 1 };
		System.out.println(new SingleNumber().singleNumber(nums));
	}

	public int singleNumber(int[] nums) {
		int a = 0;
		for (int i : nums) {
			a ^= i;
		}
		return a;
	}

	public int singleNumberHashmap(int[] nums) {
		HashMap<Integer, Integer> hash_table = new HashMap<>();

		for (int i : nums) {
			hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
		}
		for (int i : nums) {
			if (hash_table.get(i) == 1) {
				return i;
			}
		}
		return 0;
	}
}
