package com.algo.twopointer;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {

	public static void main(String[] args) {
		int[] spells = { 5, 1, 3 };
		int[] potions = { 1, 2, 3, 4, 5 };
		int success = 7;
		new SuccessfulPairsOfSpellsAndPotions().successfulPairs(spells, potions, success);
	}

	public int[] successfulPairs(int[] spells, int[] potions, long success) {
		Arrays.sort(potions);
		int[] output = new int[spells.length];
		for (int i = 0; i < spells.length; i++) {
			int start = 0;
			int end = potions.length - 1;
			int mid = 0;
			while (start <= end) {
				mid = start + (end - start) / 2;
				if ((long) spells[i] * (long) potions[mid] >= success) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			output[i] = potions.length - start;
		}
		return output;
	}

}
