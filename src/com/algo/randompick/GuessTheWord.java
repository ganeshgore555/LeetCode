package com.algo.randompick;

import java.util.*;

public class GuessTheWord {

	interface Master {
		public int guess(String word);
	}

	public static void main(String[] args) {

	}

	public void findSecretWord(String[] wordlist, Master master) {
		Random ran = new Random();
		ArrayList<String> possibles = new ArrayList<>();
		for (String word : wordlist) {
			possibles.add(word);
		}
		int trials = 0;
		while (trials < 30) {
			int index = ran.nextInt(possibles.size());
			String testWord = possibles.get(index);
			int matches = master.guess(testWord);
			if (matches == 6)
				return;
			ArrayList<String> newPossibles = new ArrayList<>();
			for (String word : possibles) {
				if (countMatches(testWord, word) == matches) {
					newPossibles.add(word);
				}
			}
			possibles = newPossibles;
			trials++;
		}
	}

	private int countMatches(String word1, String word2) {
		int m = 0;
		for (int i = 0, j = 0; i < 6 && j < 6; ++i, ++j) {
			if (word1.charAt(i) == word2.charAt(j)) {
				m++;
			}
		}
		return m;
	}
}
