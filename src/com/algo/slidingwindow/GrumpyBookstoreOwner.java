package com.algo.slidingwindow;

public class GrumpyBookstoreOwner {

	public static void main(String[] args) {
		int[] customers =	{1,0,1,2,1,1,7,5};
		int[] grumpy = 		{0,1,0,1,0,1,0,1};
		int minutes = 3;
		System.out.println(new GrumpyBookstoreOwner().maxSatisfied(customers, grumpy, minutes));
	}

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    	
    	int satisfiedWithTechnique = 0;
    	int satisfiedWithoutTechnique = 0;
    	int max = 0;
    	int result = 0;
    	
    	for(int i = 0; i < Math.min(customers.length,minutes); i++) {
    		satisfiedWithTechnique += customers[i];
    		satisfiedWithoutTechnique += (customers[i] * (grumpy[i] == 1 ? 0 : 1));
    		result += (customers[i] * (grumpy[i] == 1 ? 0 : 1));
    	}
    	
    	if(customers.length <= minutes)
    		return satisfiedWithTechnique;
    	
		max = satisfiedWithTechnique-satisfiedWithoutTechnique;
    	int start = 0;
		
    	for(int i = minutes; i < customers.length; i++) {
    		satisfiedWithTechnique -= customers[start];
    		satisfiedWithoutTechnique -= (customers[start] * (grumpy[start] == 1 ? 0 : 1)); 
			start++;
			
    		result += (customers[i] * (grumpy[i] == 1 ? 0 : 1));
    		satisfiedWithTechnique += customers[i];
    		satisfiedWithoutTechnique += (customers[i] * (grumpy[i] == 1 ? 0 : 1));
    		
    		if((satisfiedWithTechnique-satisfiedWithoutTechnique) > max) {
    			max = Math.max(max, (satisfiedWithTechnique-satisfiedWithoutTechnique));
    		}    			
    	}
    	
		return result+max;
    }	
}
