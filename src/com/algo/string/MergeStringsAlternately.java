package com.algo.string;

public class MergeStringsAlternately {

	public static void main(String[] args) {
		System.out.println(new MergeStringsAlternately().mergeAlternately("", "lmn"));
	}

    public String mergeAlternately(String word1, String word2) {
    	StringBuilder builder = new StringBuilder();
    	int i = 0;
    	for(; i < Math.min(word1.length(), word2.length()); i++) {
    		builder.append(word1.charAt(i));
    		builder.append(word2.charAt(i));
    	}
    	builder.append(i == word1.length() ? word2.substring(i):word1.substring(i));
		return builder.toString();
        
    }	
}
