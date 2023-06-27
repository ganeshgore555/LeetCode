package com.algo.math;

public class PoorPigs {

	public static void main(String[] args) {
		int buckets =4, minutesToDie = 15, minutesToTest = 15;
		System.out.println(new PoorPigs().poorPigs(buckets, minutesToDie, minutesToTest));
	}

   public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while (Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) {
            pigs += 1;
        }
        return pigs;
    }
}
