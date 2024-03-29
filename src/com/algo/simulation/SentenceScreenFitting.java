package com.algo.simulation;

public class SentenceScreenFitting {

	public static void main(String[] args) {
		String [] sentence = {"a", "bcd", "e"}; int rows = 3; int cols = 6;
		System.out.println(new SentenceScreenFitting().wordsTyping(sentence, rows, cols));
	}

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0;
        int rowIndex = 0;
        int wordIndex = 0;
        int spaces = cols;
        while(rowIndex < rows){
            if(sentence[wordIndex].length() <= spaces){
                spaces -= sentence[wordIndex].length();
                spaces--; //-1 means extra'-'
                wordIndex++;
            }
            else{
                rowIndex++;
                spaces = cols;
            }
            if(wordIndex == sentence.length){
                count++;
                wordIndex = 0;
            }
        }
        return count;
    }
}
