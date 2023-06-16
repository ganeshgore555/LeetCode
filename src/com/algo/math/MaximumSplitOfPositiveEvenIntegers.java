package com.algo.math;

import java.util.*;

public class MaximumSplitOfPositiveEvenIntegers {

	public static void main(String[] args) {
		System.out.println(new MaximumSplitOfPositiveEvenIntegers().maximumEvenSplit(12));
	}

    public List<Long> maximumEvenSplit(long f) {
        LinkedList<Long> ans = new LinkedList<>();
        if (f % 2 == 0) {
            long i = 2;
            while (i <= f) {
                ans.push(i);
                f -= i;
                i += 2;
            } 
            ans.push(f + ans.pop());
        }
        return ans;
    }
}
