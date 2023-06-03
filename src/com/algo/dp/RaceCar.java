package com.algo.dp;

import java.util.*;

public class RaceCar {

	public static void main(String[] args) {
		int target = 4;
		System.out.println(new RaceCar().racecar(target));
		System.out.println(new RaceCar().raceBFS(target));
	}

    public int racecar(int target) {
        return raceDP(1, 0, target, 0);	
    }

    HashMap<String,Integer> memo = new HashMap<>();
    
	private int raceDP(int speed, int pos, int target, int moves) {
		if(pos == target) {
			return moves;
		}
				
		if(memo.containsKey(speed + "-" + pos))
			return memo.get(speed + "-" + pos);
		
		int withA = Integer.MAX_VALUE;
		int withR = Integer.MAX_VALUE;		
		
		if((speed > 0 && pos < target) || (pos > target && speed < 0))
			withR = raceDP(speed * 2, pos + speed, target, moves + 1);
		else
			withR = raceDP((speed > 0 ? - 1 : 1), pos, target, moves + 1);
		
		int min = Math.min(withA, withR);
		memo.put(speed + "-" + pos, min);
		return min;
	}
	
	private int raceBFS(int target) {
		LinkedList<Integer[]> queue = new LinkedList();
		Integer[] start = {1,0,0}; // speed, position, moves
		HashSet<Integer[]> visited = new HashSet<Integer[]>();
		int moves = 0;
		queue.offer(start);
		while(!queue.isEmpty()) {
			Integer[] current = queue.poll();
			int speed = current[0];
			int pos = current[1];
			moves = current[2];
			
			if(pos == target) {
				return moves;
			}
			
			Integer[] visitedStep = {speed, pos};
			if(visited.contains(visitedStep))
				continue;
			else {
				visited.add(visitedStep);
				Integer[] accelerate = {speed * 2, pos + speed, moves + 1};
				queue.offer(accelerate);
				if((pos + speed > target && speed > 0) || (pos + speed < target && speed < 0)){
					Integer[] reverse = {(speed > 0 ? -1 : 1), pos, moves + 1};
					queue.offer(reverse);					
				}
			}
		}
		return moves;
	}
	
}
