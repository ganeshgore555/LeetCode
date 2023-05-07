package com.algo.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public int lastStoneWeight(int[] stones) {
        
        // Save all stones in descending order.
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) {
            heap.add(stone);
        }

        // While there is more than one stone left, we need to remove the two largest
        // and smash them together. If there is a resulting stone, we need to put into
        // the heap.
        while (heap.size() > 1) {
            int stone1 = heap.remove();
            int stone2 = heap.remove();
            if (stone1 != stone2) {
                heap.add(stone1 - stone2);
            }
        }

        // Check whether or not there is a stone left to return.
        return heap.isEmpty() ? 0 : heap.remove();
    }
	
}
