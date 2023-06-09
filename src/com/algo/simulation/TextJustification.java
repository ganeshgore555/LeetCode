package com.algo.simulation;

import java.util.*;

public class TextJustification {

	public static void main(String[] args) {
		//String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] words = {"What","must","be","acknowleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeedgment","shall","be"};
		int maxWidth = 16;
		new TextJustification().fullJustify(words, maxWidth).stream().forEach(System.out::println);
	}

	
    public List<String> fullJustify(String[] words, int maxWidth) {
    	
    	ArrayList result = new ArrayList<>();
       	int wordCount = 0;
       	LinkedList<String> tempList = new LinkedList<>();
       	int length = 0; 
       	
       	int index = 0;
    	for(String word : words) {
    		if((length + word.length() + wordCount) > maxWidth)
    		{
    			if(wordCount > 0) {
    				buildLine(result, tempList, wordCount, length, maxWidth, index, words.length);    				
	    			tempList = new LinkedList<>();
	    			wordCount = 0;
	    			length = 0;
    			}
    		}
    		
    		while(word.length() > maxWidth) {
    			String temp = word.substring(0, maxWidth);
    			result.add(temp);    			
    			word = word.substring(maxWidth);    			
    		}
    		tempList.add(word);
    		wordCount += 1;
    		length += word.length();
    		index++;
        }
    	buildLine(result, tempList, wordCount, length, maxWidth, index, words.length);
    	return result;
    }


	private void buildLine(ArrayList result, LinkedList<String> tempList, int wordCount, int length, int maxWidth, int index, int words) {
		int whiteSpaces = maxWidth - length;
		int gaps = wordCount-1;
		int minWhiteSpace = (index == words) ? 1 : ((gaps > 0) ? whiteSpaces / gaps : 0);
		int remainderWhiteSpace = (index == words) ? 0 : ((gaps > 0) ? whiteSpaces % gaps : 0);
		String line = "";
		int i = 0;
		for(String temp : tempList) {
			if(i < tempList.size()-1)
				line = line + temp + " ".repeat(minWhiteSpace) + (remainderWhiteSpace > 0 ? " " : "");
			else
				line = line + temp;
			
			i++;
			remainderWhiteSpace--;
		}
		if(line.length() < maxWidth) {
			line = line + " ".repeat(maxWidth-line.length());
		}
		result.add(line);
	}
}
