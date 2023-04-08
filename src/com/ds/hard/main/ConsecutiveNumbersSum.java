package com.ds.hard.main;

public class ConsecutiveNumbersSum {

	public static void main(String[] args) {

	}

	// n = (x + 1) + ... + (x + k)
	// n = x k + k(k + 1)/2
    public int consecutiveNumbersSum1(int n) {
        int count = 0;
        // x > 0 --> n/k - (k + 1)/2 > 0
        int upper_limit = (int)(Math.sqrt(2 * n + 0.25) - 0.5);
        for (int k = 1; k <= upper_limit; ++k) {
            // x should be an integer
            if ((n - k * (k + 1) / 2) % k == 0)
                count++;
        }
        return count;
    }
    
    
    /*
     * n = k + (k+1) + (k+2) + (k+3) + ... + (k+i-1) = i*k + (1+2+3+... + i-1)
     * sum(i) = (1+2+3+...+i-1)
     * n = sum(i) + i*k
     * i*k = n - sum(i)
     * 
     */
    public int consecutiveNumbersSum2(int n) {
        int sum = 0, ans = 0;
        for(int i = 1; sum < n; i++) {
            sum += i;
            if (((n-sum) % i) == 0)
                ans++;
        }
        return ans;
    }    
}
