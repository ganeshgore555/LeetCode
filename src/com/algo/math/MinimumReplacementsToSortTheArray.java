package com.algo.math;

public class MinimumReplacementsToSortTheArray {

	public static void main(String[] args) {
		int[] nums1 = {3,9,3};
		//System.out.println(new MinimumReplacementsToSortTheArray().minimumReplacement(nums1));
		int[] nums2 = {3,23,15,11};
		System.out.println(new MinimumReplacementsToSortTheArray().minimumReplacement(nums2));
	}

	
	public long minimumReplacement(int[] nums) {
        int n=nums.length , prev=nums[n-1];;
        long ans=0;
        for(int i=n-2;i>=0;i--){
            int noOfTime=nums[i]/prev; 
            if((nums[i])%prev!=0){
			    noOfTime++;
                prev=nums[i]/noOfTime;
            }   
            ans+=noOfTime-1;
        }
        return ans;
    }
}
