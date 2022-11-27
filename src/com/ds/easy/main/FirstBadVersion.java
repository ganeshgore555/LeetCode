package com.ds.easy.main;

public class FirstBadVersion {

	public static void main(String[] args) {
		int version = firstBadVersion(2);
		System.out.println(version);
	}
	
	public static boolean isBadVersion(int version) {
		boolean[] versions = {false,true};
		return versions[version-1];
	}
	    
    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("start:" + start + " end:" + end + " mid:" + mid);
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }	
}
