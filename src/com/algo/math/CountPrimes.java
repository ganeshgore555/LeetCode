package com.algo.math;

public class CountPrimes {

	public static void main(String[] args) {
		System.out.println(new CountPrimes().countPrimes(10));
	}

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        
        boolean[] numbers = new boolean[n];
        for (int p = 2; p <= (int)Math.sqrt(n); ++p) {
            if (numbers[p] == false) {
                for (int j = p*p; j < n; j += p) {
                    numbers[j] = true;
                }
            }
        }
        
        int numberOfPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (numbers[i] == false) {
                ++numberOfPrimes;
            }
        }
        
        return numberOfPrimes;
    }
}
