package com.algo.arrays;

import java.util.Arrays;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {

	public static void main(String[] args) {
		int[] candies = {2,3,5,1,3};
		int extraCandies = 3;
		System.out.println(new KidsWiththeGreatestNumberofCandies().kidsWithCandies(candies, extraCandies));
	}

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).map(i -> i + extraCandies).mapToObj(i -> i >= max ? true : false).toList();
    }
}
