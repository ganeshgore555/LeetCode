package com.algo.hashtable;

import java.util.*;

public class DetectSquares {

	public static void main(String[] args) {
		DetectSquares obj = new DetectSquares();
		int[] input1 = {3, 10};
		obj.add(input1);
		int[] input2 = {11, 2};
		obj.add(input2);
		int[] input3 = {3, 2};
		obj.add(input3);
		int[] count1 = {11, 10};
		System.out.println(obj.count(count1));		
		obj.add(input3);
		System.out.println(obj.count(count1));	
	}
	
	Map<String,Integer> pointsCount;
    List<int[]> coordinates;
    public DetectSquares() {
        pointsCount = new HashMap<>();
        coordinates = new ArrayList<>();
        
    }
    //store the frequency of all the points, look at the unique way of storing it splitting
    //the points int two parts and forming a string of a point
    public void add(int[] point) {
        coordinates.add(point);
        String strCoordinate = point[0] + "#" + point[1];
        int count = pointsCount.getOrDefault(strCoordinate,0);
        pointsCount.put(strCoordinate,++count);
    }
    
    public int count(int[] point) {
        int total=0;
        int x=point[0];
        int y=point[1];
        
        for(int[] key : coordinates){
            //check if a diagonal point exist whis is having x and y distance as same
            if(Math.abs(key[0]-x) !=0 && Math.abs(key[0]-x) == Math.abs(key[1]-y)){
                //take y of diagonal and x of current point
                String leftCoordinate = key[0] + "#" + y;
                //take x of diagonal and y of current point
                String rightCoordinate = x + "#" + key[1];
                total+=pointsCount.getOrDefault(leftCoordinate,0)
                    * pointsCount.getOrDefault(rightCoordinate,0);
            }
        }
        return total;
    }	
	
	/*
	
    public DetectSquares() {
    	xMap = new HashMap<>();
    	yMap = new HashMap<>();
    }
    
    HashMap<Integer,ArrayList<Integer>> xMap;
    HashMap<Integer,ArrayList<Integer>> yMap;
    HashMap<Integer,ArrayList<Integer>> memo; 
    
    public void add(int[] point) {
        if(!xMap.containsKey(point[0]))
        	xMap.put(point[0], new ArrayList<>());
        xMap.get(point[0]).add(point[1]);
        
        if(!yMap.containsKey(point[1]))
        	yMap.put(point[1], new ArrayList<>());
        yMap.get(point[1]).add(point[0]);
    }
    
    public int count(int[] point) {
    	if(point[0] < 0 || point[1] < 0 || xMap.get(point[0]) == null)
    		return 0;

    	int ans = 0;
    	for(int y : xMap.get(point[0])) {
    		if(y == point[1] || y < 0)
    			continue;
    		int[] nextPoint = {point[0], y}; 
    		ans += countRecursive(point, nextPoint, 1, Math.abs(y-point[1]), true);
    	}
    	return ans;
    }



	private int countRecursive(int[] startPoint, int[] currPoint, int pointCount, int width, boolean xORy) {
		if(pointCount == 3 && ((startPoint[0] == currPoint[0] && Math.abs(startPoint[1] - currPoint[1]) == width) ||
				(startPoint[1] == currPoint[1] && Math.abs(startPoint[0] - currPoint[0]) == width)))
			return 1;
		
		if(pointCount > 3)
			return 0;
		int ans = 0;
		if(xORy) {
	    	for(int x : yMap.get(currPoint[1])) {
	    		if(x == currPoint[0] || x < 0 || Math.abs(x-currPoint[0]) != width)
	    			continue;
	    		int[] nextPoint = {x, currPoint[1]}; 
	    		ans = ans + countRecursive(startPoint, nextPoint, pointCount+1, width, false);
	    	}
		}else {
	    	for(int y : xMap.get(currPoint[0])) {
	    		if(y == currPoint[1] || y < 0 || Math.abs(y-currPoint[1]) != width)
	    			continue;
	    		int[] nextPoint = {currPoint[0], y}; 
	    		ans = ans + countRecursive(startPoint, nextPoint, pointCount+1, width, true);
	    	}
		}		
		return ans;
	}
	
	*/
}
