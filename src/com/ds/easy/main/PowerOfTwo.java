package com.ds.easy.main;

public class PowerOfTwo {

	public static void main(String[] args) {
		System.out.println(new PowerOfTwo().isPowerOfTwo(16));
	}
    public boolean isPowerOfTwo(int n) {
    	long l = (long) n;
        if (l == 0) return false;
        return (l & (-l)) == l;
    }
}
