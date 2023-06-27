package com.algo.math;

import java.util.Arrays;

public class CountPairsInTwoArrays {

	public static void main(String[] args) {
		int[] nums1 = {1,10,6,2}, nums2 = {1,4,1,5};
		System.out.println(new CountPairsInTwoArrays().countPairs(nums1, nums2));
	}

    // sorting
    // idea: nums1[i] + nums1[j] > nums2[i] + nums2[j] => (nums1[i] - nums2[i]) + (nums1[i] - nums2[j]) > 0 => diffs[i] + diffs[j] > 0
    // 1. use a int[] diffs to track differences between elements of nums1 and nums2
    // 2. now, we need to find how many pairs of diff[i] and diff[j] such diffs[i] + diffs[j] > 0 and i < j. 
    //    a. since we only want to know how many unique pairs in diffs such diffs[i] + diffs[j] > 0, index doesn't matter
    // 3. sort diffs
    // 4. use 2 pointers lo and hi, while hi > lo (for dedupe):
    //    a. for each diffs[hi], we find the min diffs[lo] such that diffs[lo] + diffs[hi] > 0, in this way, for this diffs[hi], there are (hi - lo) valid pairs, result += (hi - lo)
    // 5. return result
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) diffs[i] = nums1[i] - nums2[i];

        Arrays.sort(diffs);

        int lo = 0, hi = n - 1;
        long pairCount = 0;
        while (lo < hi) {
            if (diffs[lo] + diffs[hi] > 0) { 
                pairCount += hi - lo;
                hi--;
            }
            else {
                lo++;
            }
        }

        return pairCount;
    }	
	
}
