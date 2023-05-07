package com.algo.graph.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		//String s = "ddadddbdddadd";
		//String[] wordDict = {"dd","ad","da","b"};
		String s = "catsanddog";
		String[] wordDict = {"cat","cats","and","dog"};

		ArrayList<String> list = new ArrayList<>(List.of(wordDict));
		System.out.println(new WordBreak().wordBreak(s, list));
	}
		
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start]) {
                continue;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if (end == s.length()) {
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }
}
