package com.algo.twopointer;

public class TwoSumIIArrayIsSorted {

	public static void main(String[] args) {
		int[] numbers = {-1,0};
		int target = -1;
		int[] sum = twoSum(numbers, target);
		System.out.println(sum[0] + " " + sum[1]);
	}

    public static int[] twoSum(int[] numbers, int target) {
    	int index = 0;
    	int length = numbers.length;
    	int[] sum = new int[2]; 
    	while(index < length) {
    		int start = index+1;
    		int end = length-1;
    		int mid = start + (end-start)/2;
    		while(start <= end) {
    			if(numbers[mid] + numbers[index] == target) {
    				sum[0] = index + 1;
    				sum[1] = mid + 1;
    				break;				
    			}else if(numbers[mid] + numbers[index] < target){
    				start = mid + 1;
    				mid = start + (end-start)/2;
    			}else {
    				end = mid - 1;
    				mid = start + (end-start)/2;
    			}
    		}
    		index++;
    	}
		return sum;
    }
    
    public int[] twoSum2(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
    	int[] sum = new int[2]; 
        while(low < high){
            if(numbers[low] + numbers[high] == target)
                return new int[]{low+1, high+1};
            
            else if(numbers[low] + numbers[high] < target)
                low++;
            
            else
                high--;
        }
        return sum;
    }
}
