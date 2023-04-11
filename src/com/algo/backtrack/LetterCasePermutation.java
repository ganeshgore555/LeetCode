package com.algo.backtrack;

import java.util.*;

public class LetterCasePermutation {

	public static void main(String[] args) {
		String s = "a1b2";
		//s = s.toLowerCase();
		System.out.println(new LetterCasePermutation().letterCasePermutation(s));
	}

    public List<String> letterCasePermutation(String s) {
    	ArrayList<String> list = new ArrayList<String>();
    	//backtrack(list, new StringBuffer(), s, 0);
    	backtrack(list, new char[s.length()], s, 0);
		return list;
        
    }

	private void backtrack(ArrayList<String> list, char[] temp, String s, int i) {
		if (i == s.length()) {
			list.add(new String(temp));
			return;
		}else {
			if(!Character.isDigit(s.charAt(i))) {
				temp[i] = Character.toUpperCase(s.charAt(i));
				backtrack(list, temp, s, i+1);
				temp[i] = Character.toLowerCase(s.charAt(i));
				backtrack(list, temp, s, i+1);
			}else {
				temp[i] = s.charAt(i);
				backtrack(list, temp, s, i+1);
			}
		}
	}
	
	private void backtrack(ArrayList<String> list, StringBuffer temp, String s, int start) {
		if (temp.length() == s.length()) {
			list.add(new String(temp));
			return;
		}else {
			for(int i=start;i<s.length();i++) {
				if(!Character.isDigit(s.charAt(i))) {
					String tempChar = s.charAt(i)+"";
					StringBuffer tempUpper = new StringBuffer(temp);
					tempUpper.append(tempChar.toUpperCase());
					backtrack(list, tempUpper, s, i+1);
					temp.append(tempChar.toLowerCase());
					backtrack(list, temp, s, i+1);
				}else {
					temp.append(s.charAt(i));
					backtrack(list, temp, s, i+1);
				}
				temp.deleteCharAt(temp.length()-1);
			}
		}
	}	
}
