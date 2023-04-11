package com.algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println(new Combinations().combine(n, k));
	}

    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		backtrack(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}
	public void backtrack(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if(k==0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for(int i=start;i<=n;i++) {
			comb.add(i);
			backtrack(combs, comb, i+1, n, k-1);
			comb.remove(comb.size()-1);
		}
	}    
}
