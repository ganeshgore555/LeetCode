package com.algo.hashtable;

public class IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(new IntegerToRoman().intToRoman(1290));
	}
    public String intToRoman(int num) {
        String roman = "";
        int[] intList = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
        final String[] romanList = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        while(num > 0) {
        	for(int i = 0; i < intList.length; i++) {
        		if(num >= intList[i]) {
        			num = num - intList[i];
        			roman = roman + romanList[i];
        			break;
        		}
        	}
        }                
        return roman;
    }
}
