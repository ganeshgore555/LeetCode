package com.algo.arrays;

public class ShiftingLetters {

	public static void main(String[] args) {
		int[] arr = {3,5,9};
		String input = "abc";
		System.out.println(new ShiftingLetters().shiftingLetters(input, arr));
	}

    public String shiftingLetters(String s, int[] shifts) {
        char[] ch = s.toCharArray();
        long r = 0;
        
        for(int i=ch.length-1;i>=0;i--){
            r += shifts[i];
            ch[i] = (char)((ch[i]-'a' + r) % 26 + 'a');
            //System.out.println(i + ":" + ch[i] + " " + r);
        }        
        return String.valueOf(ch);
    }
	
}
