package com.algo.math;

import java.util.*;

public class FindingTheNumberOfVisibleMountains {

	public static void main(String[] args) {
		int[][] peaks = {{2,2},{6,3},{5,4}};
		System.out.println(new FindingTheNumberOfVisibleMountains().visibleMountains(peaks));
	}

    public int visibleMountains(int[][] peaks) {
        int n = peaks.length;

        //Store mountains starting x and ending x.
        int[][] mat = new int[n][2];
        for(int i = 0; i < n; i++){
            mat[i][0] = peaks[i][0] - peaks[i][1];
            mat[i][1] = peaks[i][0] + peaks[i][1];
        }

        //Sort by starting x asc and ending x desc
        Arrays.sort(mat, (a,b)->{return a[0]==b[0] ? b[1]-a[1] : a[0]-b[0];});

        int i = 0;
        int count = 0;
        while(i < mat.length){
            int j = i + 1;
            //If mountain i and mountain j are not identical, increase count.
            if(j == mat.length || mat[i][0] != mat[j][0] || mat[i][1] != mat[j][1])
                count++;

            //skip all the mountains that are covered by mountain i
            while(j < mat.length && (mat[i][0] <= mat[j][0] && mat[i][1] >= mat[j][1])){
                j++;
            }

            //j is pointing mountain that is not covered by previous mountains. In order to include counting, set i to j.
            i = j;
        }
        return count;
    }
}
