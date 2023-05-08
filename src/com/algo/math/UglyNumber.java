package com.algo.math;

public class UglyNumber {

	public static void main(String[] args) {
		System.out.println(new UglyNumber().isUgly(10));
		System.out.println(new UglyNumber().isUgly(11));
		System.out.println(new UglyNumber().isUgly(12));
	}

    public boolean isUgly(int n) {
        while (n > 1) {
            if (n % 2 == 0) n /= 2;
            else if (n % 3 == 0) n /= 3;
            else if (n % 5 == 0) n /= 5;
            else return false;
        }
        return n > 0;
    }
}
