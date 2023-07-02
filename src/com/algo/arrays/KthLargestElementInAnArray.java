package com.algo.arrays;

import java.util.*;

public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(new KthLargestElementInAnArray().findKthLargest(nums, k));
	}

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }        
        return heap.peek();
    }
}
