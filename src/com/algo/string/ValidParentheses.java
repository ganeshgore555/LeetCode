package com.algo.string;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s = "{()([])}[]";
		System.out.println(new ValidParentheses().isValid(s));
	}
    public boolean isValid(String s) {
    	Stack<Character> mainStack = new Stack();
    	Stack<Character> tempStack = new Stack();
    	for(char ch : s.toCharArray()) {
    		mainStack.push(ch);
    	}

    	while(!mainStack.isEmpty()) {
    		Character ch = mainStack.pop();
    		if(ch == ')' || ch == '}' || ch == ']') {
    			tempStack.push(ch);
    		}
    		else if(tempStack.isEmpty()){
    			return false;
    		}else {
    			Character tempChar = tempStack.pop();
    			if(tempChar == null ||
    					(ch == '(' && tempChar != ')') ||
    					(ch == '{' && tempChar != '}') ||
    					(ch == '[' && tempChar != ']')) {
    				return false;
    			}
    		}
    			
    	}
    	if(!tempStack.isEmpty())
    		return false;
    	
		return true;
    }
}
