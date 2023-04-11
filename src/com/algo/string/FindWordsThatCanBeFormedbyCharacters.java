package com.algo.string;

public class FindWordsThatCanBeFormedbyCharacters {

	public static void main(String[] args) {
		String[] words = {"cat","bt","hat","tree"};
		String chars = "atach";
		System.out.println(new FindWordsThatCanBeFormedbyCharacters().countCharacters(words, chars));
	}

	
    public int countCharacters(String[] words, String chars) {
        int[] wordMap1 = new int[26];
        int[] charMap2 = new int[26];
        int sum = 0;
        for(int i = 0; i < chars.length(); i++) {
        	charMap2[chars.charAt(i) - 'a']++;
        }
        
        for(String word : words){
            wordMap1 = new int[26];
            for(int i = 0; i < word.length(); i++) {
            	wordMap1[word.charAt(i) - 'a']++;
            }
            if(check(wordMap1,charMap2)) {
            	sum = sum + word.length();
            }
        }
        return sum;
    }
    
    public boolean check(int[] wordMap1,int[] charMap2) {
    	for(int i = 0; i < wordMap1.length; i++) {
    		if(wordMap1[i] != 0 && wordMap1[i] > charMap2[i])
    			return false;
    	}
    	return true;
    }
}
