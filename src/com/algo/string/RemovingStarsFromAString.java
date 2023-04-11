package com.algo.string;

public class RemovingStarsFromAString {

	public static void main(String[] args) {
    	String s = "leet**cod*e";
    	System.out.println(new RemovingStarsFromAString().removeStars(s));
	}

    public String removeStars(String s) {
    	String result = "";
    	int starCount = 0;
    	char[] chars = s.toCharArray();
    	for(int i = s.length()-1 ; i >= 0 ; i--) {
    		if(chars[i] == '*')
    			starCount++;
    		else {
    			if(starCount > 0)
    				starCount--;
    			else
    				result = chars[i] + result; 
    		}
    			
    	}
    	return result;
    }
}
