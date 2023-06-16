package com.algo.recursion;

public class DecodeString {

	public static void main(String[] args) {
		//String s = "3[a2[c]]";
		String s = "100[leetcode]";
		System.out.println(new DecodeString().decodeString(s));
	}
	
    public String decodeString(String s) {
    	
    	StringBuffer output = new StringBuffer();
    	
    	int repeater = 0;
    	StringBuffer repeatString = new StringBuffer();
    	int open = 0;
    	int close = 0;
    	
    	int i = 0;
        while(i < s.length()) {
        	if(Character.isDigit(s.charAt(i)) && repeater == 0) {
        		StringBuffer temp = new StringBuffer();;
        		while(Character.isDigit(s.charAt(i))) {
        			temp.append(s.charAt(i));
        			i++;
        		}
        		i--;
        		repeater = Integer.parseInt(temp.toString());
        	}else if(s.charAt(i) == '[') {
        		open++;
        		repeatString.append(s.charAt(i));
        	}else if(s.charAt(i) == ']') {
        		close++;
        		repeatString.append(s.charAt(i));
        		if(open == close) {
        			output.append(decodeString(repeatString.substring(1, repeatString.length())).repeat(repeater));
        			repeater = 0;
        			open = 0;
        			close = 0;
        			repeatString = new StringBuffer();
        		}
        	}else {
        		if(repeater == 0)
        			output.append(s.charAt(i));
        		else
        			repeatString.append(s.charAt(i));
        	}
        	i++;
        }
        
        return output.toString();
    }
}
