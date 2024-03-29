package com.algo.math;

public class AddDigits {
	
	public static void main(String[] args) {
		int n = 29;
		System.out.println(new AddDigits().addDigits(n));
	}
	
	//The original number is divisible by 9 if and only if the sum of its digits is divisible by 9.
	
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
