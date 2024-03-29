package com.algo.twopointer;


public class ShortestWordDistanceIII {

	public static void main(String[] args) {
		String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding";
		String word2 = "makes";
		System.out.println(new ShortestWordDistanceIII().shortestWordDistance(wordsDict, word1, word2));
	}

        
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
                    min = Math.min(i - index, min);
                }
                index = i;
            }
        }
        return min;
    }    
}
