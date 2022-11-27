package com.ds.easy.main;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int [] nums = {1,2,3,4,5,6,7};
		int target = 2;
		int pos = searchInsert(nums, target);
		System.out.println(pos);
	}
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            //System.out.println("start:" + start + " end:" + end + " mid:" + mid);
            if(nums[mid] == target) {
            	break;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(start >= end) {
        	//System.out.println("start:" + start + " end:" + end + " mid:" + mid);
        	if(nums[mid] >= target) {
        		return mid; 
        	}else{
        		return start;
        	}
        }
        return mid;
    }
}
