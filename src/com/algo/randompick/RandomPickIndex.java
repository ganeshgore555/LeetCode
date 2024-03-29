package com.algo.randompick;

import java.util.*;

public class RandomPickIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    private HashMap<Integer, List<Integer>> indices;
    private Random rand;
    
    public RandomPickIndex(int[] nums) {
        this.rand = new Random();
        this.indices = new HashMap<Integer, List<Integer>>();
        int l = nums.length;
        for (int i = 0; i < l; ++i) {
            indices.computeIfAbsent(nums[i], value -> new ArrayList<Integer>()).add(i);
        }
    }
    
    public int pick(int target) {
        int l = indices.get(target).size();
        // pick an index at random
        int randomIndex = indices.get(target).get(rand.nextInt(l));
        return randomIndex;
    }
}
