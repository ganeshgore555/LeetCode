package com.algo.bitoperations;

public class NumberOf1Bits {

	public static void main(String[] args) {
		System.out.println(new NumberOf1Bits().hammingWeight(00000000000000000000000100001011));
	}

    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
