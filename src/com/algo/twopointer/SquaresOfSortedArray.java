package com.algo.twopointer;

import java.util.TreeMap;

public class SquaresOfSortedArray {

	public static void main(String[] args) {
		int[] nums = {-7,-3,2,3,11};
		int[] squares = sortedSquares(nums);
    	for(int i = 0; i < squares.length; i++) {
    		System.out.println(squares[i]);
    	}
	}
    public static int[] sortedSquares(int[] nums) {
    	int start = 0;
    	int end = nums.length - 1;
    	int[] squares = new int[nums.length];
    	int index = nums.length-1;  
    	while(index >= 0) {
    		if((nums[start]*nums[start]) >= (nums[end]*nums[end])) {
    			squares[index] = (nums[start]*nums[start]);
    			start++;
    		}else {
    			squares[index] = (nums[end]*nums[end]);
    			end--;
    		}
    		index--;
    	}
		return squares;
    }
}
