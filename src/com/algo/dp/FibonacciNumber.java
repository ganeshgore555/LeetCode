package com.algo.dp;

import java.util.HashMap;

public class FibonacciNumber {

	public static void main(String[] args) {
		System.out.println(new FibonacciNumber().fib(5));
	}
	HashMap<Integer,Integer> map = new HashMap<>();
    public int fib(int n) {
        if(n==0)
        	return 0;

        if(n==1)
        	return 1;

        if(map.containsKey(n))
        	return map.get(n);
        
        map.put(n, fib(n-1)+fib(n-2));
        return map.get(n);
    }	
}
