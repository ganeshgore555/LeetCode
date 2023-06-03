package com.algo.design;

import java.util.*;

public class HitCounter {

	public static void main(String[] args) {
		HitCounter obj = new HitCounter();
		obj.hit(1);
		obj.hit(1);
		obj.hit(1);
		obj.hit(2);
		obj.hit(3);
		System.out.println(obj.getHits(4));
		obj.hit(300);
		System.out.println(obj.getHits(300));
		System.out.println(obj.getHits(301));

	}
	
	
    private LinkedList<Integer> hits; 

    public HitCounter() {
        this.hits = new LinkedList<Integer>();
    }
    
    public void hit(int timestamp) {
        this.hits.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!this.hits.isEmpty()) {
            int diff = timestamp - this.hits.peek();
            if (diff >= 300) this.hits.poll();
            else break;
        }
        return this.hits.size();
    }

}
