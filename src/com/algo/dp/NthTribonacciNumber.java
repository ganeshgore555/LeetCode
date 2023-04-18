package com.algo.dp;

import java.util.HashMap;

public class NthTribonacciNumber {

	public static void main(String[] args) {
		System.out.println(new NthTribonacciNumber().tribonacci(4));
	}
	HashMap<Integer,Integer> map = new HashMap<>();
    public int tribonacci(int n) {
    	if(n == 0)
    		return 0;
    	if(n==1 || n ==2)
    		return 1;
    	if(map.containsKey(n))
    		return map.get(n);
    	
    	int result = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    	map.put(n, result);
    	return result;
    }
}
