package com.algo.priorityqueue;

import java.util.*;

public class MinimumNumberOfRefuelingStops {

	public static void main(String[] args) {
		int target = 100; int startFuel = 10; int[][] stations = {{10,60},{20,30},{30,30},{60,40}};
		System.out.println(new MinimumNumberOfRefuelingStops().minRefuelStops(target, startFuel, stations));
	}

    public int minRefuelStops(int target, int tank, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int ans = 0, prev = 0;
        for (int[] station: stations) {
            int location = station[0];
            int capacity = station[1];
            tank -= location - prev;
            while (!pq.isEmpty() && tank < 0) {  // must refuel in past
                tank += pq.poll();
                ans++;
            }

            if (tank < 0) return -1;
            pq.offer(capacity);
            prev = location;
        }

        // Repeat body for station = (target, inf)
        {
            tank -= target - prev;
            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                ans++;
            }
            if (tank < 0) return -1;
        }

        return ans;
    }
	
}
