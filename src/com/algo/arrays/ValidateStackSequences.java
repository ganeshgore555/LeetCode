package com.algo.arrays;

import java.util.Stack;

public class ValidateStackSequences {

	public static void main(String[] args) {
		int [] pushed = {1,2,3,4,5};
		int [] popped = {4,5,3,2,1};
		System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
	}

    public boolean validateStackSequences(int[] pushed, int[] popped) {		
		Stack<Integer> stack = new Stack();
		int i = 0;
		int j = 0;
		while(i < pushed.length) {			
			if(i < pushed.length && pushed[i] == popped[j])
			{
				i++;
				j++;
			}else if(!stack.isEmpty() && stack.peek() == popped[j]) {
				stack.pop();
				j++;
			}else{
				stack.push(pushed[i]);
				i++;
			}
		}
		while(j < pushed.length && !stack.isEmpty()) {
			if(popped[j] == stack.peek()) {
				stack.pop();
				j++;
			}else {
				return false;
			}
		}
		return true;
    }
}
