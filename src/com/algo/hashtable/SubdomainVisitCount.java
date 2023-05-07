package com.algo.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {

	public static void main(String[] args) {
		String[] domains = {"9001 discuss.leetcode.com"};
		System.out.println(new SubdomainVisitCount().subdomainVisits(domains));
	}
    public List<String> subdomainVisits(String[] cpdomains) {
    	HashMap<String, Integer> map = new HashMap<>();
    	for(String cpDomain : cpdomains) {
    		String[] domainArr = cpDomain.split(" ");
    		int count = Integer.parseInt(domainArr[0]);
    		String domain = domainArr[1];
    		map.put(domain, map.getOrDefault(domain, 0) + count);
    		
    		for(int i = 0; i < domain.length(); i++) {
    			if(domain.charAt(i) == '.') {
    				String subDomains = domain.substring(i+1, domain.length());
    				map.put(subDomains, map.getOrDefault(subDomains, 0) + count);
    			}
    		}
    	}
    	List<String> list = new ArrayList<>();
    	for(String subDomain : map.keySet())
    		list.add(map.get(subDomain) + " " + subDomain);
    	
		return list;
    }
}
