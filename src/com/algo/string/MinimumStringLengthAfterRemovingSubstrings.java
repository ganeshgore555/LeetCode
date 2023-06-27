package com.algo.string;

import java.util.*;

public class MinimumStringLengthAfterRemovingSubstrings {

	public static void main(String[] args) {
		String s = "cizokxcijwbyspcfcqws";
		int[] indices = {17,1,14,3,9,11};
		String[] sources = {"qw","iz","cf","okxc","wb","ysp"};
		String[] targets = {"m","rq","hc","ymfy","mt","drn"};
		System.out.println(new MinimumStringLengthAfterRemovingSubstrings().findReplaceStringOptimized(s, indices, sources, targets));
	}

	
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer,String> indexString = new HashMap<>();
        HashMap<Integer,Integer> indexLength = new HashMap<>();
        ArrayList<Integer> indexList = new ArrayList<>();

        for(int i = 0; i < indices.length; i++) {
        	if(s.startsWith(sources[i],indices[i])){
        		indexString.put(indices[i], targets[i]);
        		indexLength.put(indices[i], sources[i].length());
        		indexList.add(indices[i]);
        	}
        }
        int indexAdjust = 0;
        String temp = s;
        Collections.sort(indexList);
        for(Integer indexBefore : indexList) {
        	int index = indexBefore + indexAdjust;
        	temp = temp.substring(0,index) + indexString.get(indexBefore) + temp.substring(index+indexLength.get(indexBefore),temp.length());
        	indexAdjust = indexAdjust + indexString.get(indexBefore).length() - indexLength.get(indexBefore);        	
        }
        return temp;
    }
    
    public String findReplaceStringOptimized(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        boolean vis[] = new boolean[n];
        HashMap<Integer , String> map = new HashMap<>();
        HashMap<Integer , Integer> map1 = new HashMap<>();
        for(int i = 0;i < indices.length;i++) {
            int m = indices[i] + sources[i].length();
            if(m <= s.length() && s.substring(indices[i] , m).equals(sources[i])) {
                vis[indices[i]] = true;
                map.put(indices[i] , targets[i]);
                map1.put(indices[i] , sources[i].length());
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i< n;i++) {
            if(vis[i]) {
               ans.append(map.get(i));
               i += map1.get(i)-1;
            
            } 
            else ans.append(s.charAt(i));
            
        }
        return ans.toString();
    }    
}
