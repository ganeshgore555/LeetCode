package com.algo.priorityqueue;

import java.util.*;

public class KthLargestElementInAStream {

	public static void main(String[] args) {
		int[] nums = {4, 5, 8, 2};
		KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(3, nums);
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(5));
		System.out.println(kthLargest.add(10));
		System.out.println(kthLargest.add(9));
		System.out.println(kthLargest.add(4));
	}

	private static int k;
    private PriorityQueue<Integer> heap;
    
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        
        for (int num: nums) {
            heap.offer(num);
        }
        
        while (heap.size() > k) {
            heap.poll();
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }	
}
