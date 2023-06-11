package com.algo.randompick;

public class RandomPickWithWeight {

	public static void main(String[] args) {
		int[] weights = {1,2,13,4,3};
		RandomPickWithWeight obj = new RandomPickWithWeight(weights);
		System.out.println("Total Weight " + obj.totalSum);
		for(int i = 0; i < obj.totalSum ; i++)
			System.out.println(obj.pickIndex());
	}

    private int[] prefixSums;
    private int totalSum;

    public RandomPickWithWeight(int[] w) {
        this.prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();

        // run a binary search to find the target zone
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
	
}
