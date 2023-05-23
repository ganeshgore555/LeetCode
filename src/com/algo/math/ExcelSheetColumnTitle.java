package com.algo.math;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println(new ExcelSheetColumnTitle().convertToTitle(702));
	}

    public String convertToTitle(int columnNumber) {
    	char[] map = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    	StringBuffer buffer = new StringBuffer();
    	int n = columnNumber;
    	while(n > 26) {
    		int mod = n % 26;
    		if(mod == 0) {
    			buffer.append('Z');
    			n = n - 1;
    		}
    		else
    			buffer.append(map[mod]);
    		n /= 26;
    	}
    	buffer.append(map[n]);
    	buffer.reverse();
    	return buffer.toString();
    }
}
