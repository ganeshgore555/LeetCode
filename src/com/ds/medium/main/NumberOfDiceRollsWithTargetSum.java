package com.ds.medium.main;

import java.util.ArrayList;

public class NumberOfDiceRollsWithTargetSum {

	public static void main(String[] args) {
		int n = 2, k = 6, target = 7;
		System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(n, k, target));
	}

    public int numRollsToTarget(int n, int k, int target) {
    	ArrayList<ArrayList<Integer>> list = new ArrayList();
        backtrack(n,k,target,list,new ArrayList<Integer>(),0);
        return list.size();
    }

	private void backtrack(int n, int k, int target, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp, int start) {
		if(start == n) {
			int sum = 0;
			for(int dice : temp) {
				sum += dice;
			}
			if(sum == target) {
				list.add(new ArrayList(temp));
				return;
			}			
		}
		else {
			for(int i = 1; i <= k; i++) {
				temp.add(i);
				backtrack(n, k, target, list, temp, start+1);
				temp.remove(temp.size()-1);
			}
		}
	}
}
