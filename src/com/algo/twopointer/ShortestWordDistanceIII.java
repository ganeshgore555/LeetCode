package com.algo.twopointer;

import java.util.HashMap;

public class ShortestWordDistanceIII {

	public static void main(String[] args) {
		String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding";
		String word2 = "makes";
		System.out.println(new ShortestWordDistanceIII().shortestWordDistance(wordsDict, word1, word2));
	}

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {

		int min = Integer.MAX_VALUE;
		HashMap<String, Integer> map = new HashMap();
		for(int i = 0; i < wordsDict.length; i++ ) {
			if(wordsDict[i] == word1 || wordsDict[i] == word2) {
				if(word1 == word2) { 
					Integer prev = map.get(word1);
					min = prev != null ? Math.min(min, Math.abs(i - prev)) : min;
					map.put(wordsDict[i], i);
				}else {
					map.put(wordsDict[i], i);
					if(map.get(word1) != null && map.get(word2) != null) {
						min = Math.min(min, Math.abs(map.get(word2) - map.get(word1)));
					}
				}
			}						
		}
		return min;
    }
        
    public int shortestWordDistance1(String[] words, String word1, String word2) {
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
