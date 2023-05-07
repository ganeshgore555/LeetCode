package com.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {

	public static void main(String[] args) {
		int[] num1 = {1,2,3,3};
		int[] num2 = {1,1,2,2};
		System.out.println(new FindTheDifferenceOfTwoArrays().findDifference(num1, num2));
	}

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    	HashSet<Integer> set1 = new HashSet<>();
    	HashSet<Integer> set2 = new HashSet<>();
    	HashSet<Integer> commonSet = new HashSet<>();
    	Arrays.stream(nums1).forEach(i -> set1.add(i));
    	Arrays.stream(nums2).forEach(i -> {
    		if(set1.contains(i)) {
    			set1.remove(i);
    			commonSet.add(i);
    		}
    		else {
    			set2.add(i);
    		}
    	});
    	commonSet.stream().forEach(i -> {
    		if(set2.contains(i)) {
    			set2.remove(i);
    		}
    	});
    	List<List<Integer>> result = new ArrayList<>();
    	result.add(new ArrayList<>(set1));
    	result.add(new ArrayList<>(set2));
		return result;
    }
}
