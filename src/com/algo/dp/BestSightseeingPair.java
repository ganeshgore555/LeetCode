package com.algo.dp;

public class BestSightseeingPair {

	public static void main(String[] args) {
		//int[] values = {8,1,5,2,6};
		//int[] values = {1,2,2};
		//int[] values = {7,8,8,10};
		//int[] values = {2,10,9,3,2};
		int[] values = {7,2,6,6,9,4,3};
		System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(values));
	}

	public int maxScoreSightseeingPair(int[] A) {   
        int i=0;
		int max = A[i] + i;
        for(int j=1;j<A.length;j++){
            int curr = A[i] + A[j] + i - j;
            max = curr > max ? curr : max;
            
            // update the value of i to the one that maximizes
            if(A[i] + i < A[j] + j){
                i=j;
            }
        }
        return max;
    }
	
	
    public int maxScoreSightseeingPairIterative(int[] values) {
        int result = 0;
        for(int j = values.length-1 ; j > 0; j--) {
        	for(int i = j - 1;  i >= 0; i--) {
        		result = Math.max(result, (values[i] + values[j] + i - j));
        	}
        }
        return result;
    }	
}
