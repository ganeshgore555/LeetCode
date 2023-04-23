package com.algo.arrays;

public class ShiftingLetters {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		String input = "abc";
		System.out.println(new ShiftingLetters().shiftingLetters(input, arr));
	}

    public String shiftingLetters(String s, int[] shifts) {
        long[] num_shifts = new long[s.length()];
        
        for(long r : shifts){
            num_shifts[(int)(r-1)] ++;
        }

        char[] ch = s.toCharArray();
        long r = 0;
        
        for(int i=ch.length-1;i>=0;i--){
            r += num_shifts[i];
            ch[i] = (char)((ch[i]-'a' + r) % 26 + 'a');
            //System.out.println(i + ":" + ch[i] + " " + r);
        }
        
        return String.valueOf(ch);
    }
	
}
