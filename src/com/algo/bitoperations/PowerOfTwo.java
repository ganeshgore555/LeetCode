package com.algo.bitoperations;

public class PowerOfTwo {

	public static void main(String[] args) {
		System.out.println(new PowerOfTwo().isPowerOfTwo(16));
		System.out.println(new PowerOfTwo().isPowerOfTwo(31));
		System.out.println(new PowerOfTwo().isPowerOfTwo(9));
	}
    public boolean isPowerOfTwo(int n) {
    	long l = (long) n;
        if (l == 0) return false;
        System.out.println(n & (-n));
        return (l & (-l)) == l;
    }
}
