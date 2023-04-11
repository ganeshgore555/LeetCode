package com.algo.string;

import java.util.Arrays;
import java.util.HashMap;

public class OptimalPartitionOfString {

	public static void main(String[] args) {
		System.out.println(new OptimalPartitionOfString().partitionString("yzubfsiypfrepcfftiov"));
		System.out.println(new OptimalPartitionOfString().partitionString("shkqbyutdvknyrpjof"));
	}
    
    public int partitionString(String s) {
        boolean []hash = new boolean[26];
        Arrays.fill(hash,false);

        int count = 1;
        for(int i = 0; i < s.length(); i++) {
            int n = s.charAt(i)-'a';
            if(hash[n]==true){
                Arrays.fill(hash,false);
                count++;
            }
            hash[n] = true;
            i++;
        }
        return count;
    }    
}
