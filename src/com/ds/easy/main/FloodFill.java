package com.ds.easy.main;

public class FloodFill {

	public static void main(String[] args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(floodFill(image,1,1,2));
	}
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
    	int oldColor = image[sr][sc];
    	depthFill(image,sr,sc,color, oldColor);
		return image;
    }
    
    public static void depthFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
    	if(image[sr][sc] == oldColor && oldColor != newColor) {
	    	image[sr][sc] = newColor;
	    	if(sr > 0) {
	    		depthFill(image, sr - 1, sc, newColor, oldColor);
	    	}
	    	if(sr < image.length-1) {
	    		depthFill(image, sr + 1, sc, newColor, oldColor);
	    	}
	    	if(sc > 0) {
	    		depthFill(image, sr, sc - 1, newColor, oldColor);
	    	}
	    	if(sc < image[0].length-1) {
	    		depthFill(image, sr, sc + 1, newColor, oldColor);
	    	}
    	}
    }
}
