package com.algo.dp;

import java.util.*;

public class SortIntegersByThePowerValue {

	public static void main(String[] args) {
		int lo = 12, hi = 15, k = 2;
		System.out.println(new SortIntegersByThePowerValue().getKth(lo, hi, k));
	}

    public int getKth(int lo, int hi, int k) {
    	ArrayList<int[]> result = new ArrayList<>(); 
        for(int i = lo; i <= hi; i++) {
        	int power = getKthRecursively(i);
        	int[] currentResult = {i, power};
        	result.add(currentResult);
        }
        Collections.sort(result, (a,b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
        return result.get(k-1)[0];
    }
    
    HashMap<Integer,Integer> memo = new HashMap<>();
	private int getKthRecursively(int x) {
		if(x==1)
			return 0;
		
		if(memo.containsKey(x))
			return memo.get(x);
		
		int result;
		if(x%2 == 0)
			result = 1 + getKthRecursively(x/2);
		else
			result = 1 + getKthRecursively((3*x)+1);
		
		memo.put(x, result);
		return result;
	}	
}
