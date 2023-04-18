package com.algo.dp;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		//int[] prices = {1,2};
		System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
	}

    public int maxProfitBruteForce(int[] prices) {
    	if(prices.length <= 1)
    		return 0;
    	
        int max = 0;
        for(int i = 0; i <= prices.length-2; i++) {
        	for(int j = i+1; j <= prices.length-1; j++) {
        		max = Math.max(max, prices[j]-prices[i]);
        	}
        }
        
		return max;
    }
    
    public int maxProfit(int[] prices) {
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
        for(int i = 0; i <= prices.length-1; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;        	
        }
		return maxprofit;
	}	
}
