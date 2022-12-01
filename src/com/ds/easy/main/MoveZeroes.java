package com.ds.easy.main;

public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = {0,3,0,0,2,1};
		moveZeroes(nums);
		int index = 0;
    	int length = nums.length;
        while(index < length) {
        	System.out.print(nums[index] + " ");
        	index++;
        }
	}
    public static void moveZeroes(int[] nums) {
    	int index = 0;
    	int length = nums.length;
    	int endZeroIndex = length - 1;
        while(index <= endZeroIndex) {
        	if(nums[index] == 0) {
        		int shiftIndex = index;
        		while(shiftIndex < endZeroIndex) {
        			nums[shiftIndex] = nums[shiftIndex+1];
        			shiftIndex++;
        		}
        		nums[endZeroIndex] = 0;
        		endZeroIndex--;
        	}else {
        		index++;
        	}
        }
    }
    
    public void moveZeroes1(int[] nums) {
        int snowBallSize = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                snowBallSize++; 
            }
            else if (snowBallSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-snowBallSize]=t;
            }
        }
    }
}
