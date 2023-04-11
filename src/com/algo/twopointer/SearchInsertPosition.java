package com.algo.twopointer;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int [] nums = {1,2,3,4,5,6,7};
		int target = 8;
		int pos = searchInsert(nums, target);
		System.out.println(pos);
	}
    public static int searchInsert(int[] nums, int target) {        
        int low = 0, mid = 0, high = nums.length-1;
        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;        
    }
}
