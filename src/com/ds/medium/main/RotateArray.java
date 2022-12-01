package com.ds.medium.main;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		rotate(nums,k);
	}

    public static void rotate(int[] nums, int k) {
    	int index = 0;
    	int length = nums.length;
    	int[] output = new int[length]; 
        while(index < length) {
        	output[(index+k)%length] = nums[index];
        	index++;
        }
        index = 0;
        while(index < length) {
        	//System.out.print(output[index] + " ");
        	nums[index] = output[index];
        	index++;
        }
    }
}
