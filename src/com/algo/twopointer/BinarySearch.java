package com.algo.twopointer;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {0,3,5,7,12,19,20,24,25,28,30,34,37,39,40,114,1145,1181,1234,2652};
		//int[] nums = {34,37,39,40,114,1165};
		//int[] nums = {2,5};		
		int target = 21;
		int result = search(nums,target);
		System.out.println(result);
	}

    public static int search(int[] nums, int target) {
    	int min = 0;
    	int max = nums.length - 1;
    	//int mid = min + (max-min) / 2;
    	int mid = (min + max) >>> 2;
		while(min <= max) {
			//System.out.println("min:" + min + " max:" + max + " mid:" + mid);
			if(nums[mid] == target) {
				break;				
			}else if(target > nums[mid]){
				min = mid + 1;
				mid = (min + max) / 2;
			}else {
				max = mid - 1;
				mid = (min + max) / 2;
			}
		}
		if(nums[mid] == target)
			return mid;
		else
			return -1;
    }
	
}
