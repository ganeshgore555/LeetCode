package com.algo.trie;

import java.util.*;

public class SumOfPrefixScoresOfStrings {

	public static void main(String[] args) {
		String[] words = {"abc","ab","bc","b"};
		System.out.println(Arrays.toString(new SumOfPrefixScoresOfStrings().sumPrefixScores(words)));
	}

	// This solution gives TLE. Check Trie based solution.
	
    public int[] sumPrefixScoresIterative(String[] words) {
		int[] result = new int[words.length];
        
		HashMap<String,Integer> prefixCount = new HashMap();		
		for(int i = 0; i < words.length; i++) {
			StringBuffer buffer = new StringBuffer();
			int score = 0;
			for(char c : words[i].toCharArray()) {
				buffer.append(c);
				String str = buffer.toString();
				if(prefixCount.containsKey(str)) {
					score += prefixCount.get(str);
				}else {
					int tempScore = 0;
					for(String word : words) {
						if(word.startsWith(str)) {
							++tempScore;
						}
					}
					prefixCount.put(str, tempScore);
					score += tempScore;
				}
			}
			result[i] = score;
		}		
		return result;
    }
	
    
    // Trie Based Solution
    
    Node root = new Node();  // Trie root.
    class Node {
        int score = 0;
        Node[] child = new Node[26];
    }

    public int[] sumPrefixScores(String[] words) {
        for(String word : words) add(word); // make trie.
        
        int [] res = new int[words.length];
        for(int i=0; i<res.length; i++)
            res[i] = calc(words[i]);  // build scores.
        return res;
    }

    void add(String str){
        Node temp = root;
        for(char ch : str.toCharArray()){
            if(temp.child[ch-'a']==null)
                temp.child[ch-'a'] = new Node();
            temp.child[ch-'a'].score++;
            temp = temp.child[ch-'a'];
        }
    }

    int calc(String str){
        int ans = 0;
        Node temp = root;
        for(char ch : str.toCharArray()){
            ans += temp.child[ch-'a'].score;
            temp = temp.child[ch-'a'];
        }
        return ans;
    }    
      
}
