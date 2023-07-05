package com.algo.dp;

import java.util.HashMap;

public class FillingBookcaseShelves {

	public static void main(String[] args) {
		//int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
		//int shelfWidth = 4;
		int[][] books = {{7,3},{7,7},{2,7},{1,6},{2,5}};
		int shelfWidth = 10;
    	long t = System.nanoTime();
		System.out.println(new FillingBookcaseShelves().minHeightShelves(books, shelfWidth));
		System.out.println("Time: " + (System.nanoTime()-t));
		t = System.nanoTime();
		System.out.println(new FillingBookcaseShelves().minHeightShelvesTopDownRecursive(books, shelfWidth));
		System.out.println("Time: " + (System.nanoTime()-t));
	}

    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + books[i - 1][1];
            int height = books[i - 1][1];
            int width = books[i - 1][0];
            for (int j = i - 1; j > 0; j--) {
                if(width + books[j - 1][0] > shelf_width)
                    break;
                height = Math.max(height, books[j - 1][1]);
                width += books[j - 1][0];
                dp[i] = Math.min(dp[i], height + dp[j - 1]);
            }
        }
        return dp[n];
    }
    
    
    // Give TLE since memo isn't helpful
    
    HashMap<String, Integer> memo = new HashMap<>();
    
    public int minHeightShelvesTopDownRecursive(int[][] books, int shelf_width) {
    	return minHeightShelvesRecursive(books, shelf_width, 1, books[0][0], books[0][1], 0);
    }

	private int minHeightShelvesRecursive(int[][] books, int shelf_width, int index, int usedWidth, int rowHeight, int totalHeight) {
		if(index == books.length) {
			return totalHeight + rowHeight;
		}
		
		String key = index + "-" + usedWidth + "-" + totalHeight; 
		if(memo.containsKey(key))
			return memo.get(key);
		
		int placedOnNewRow = minHeightShelvesRecursive(books, shelf_width, index + 1, books[index][0], books[index][1], totalHeight+rowHeight);		
		int placedOnSameRow = Integer.MAX_VALUE;
		if(books[index][0] + usedWidth <= shelf_width) {
			placedOnSameRow = minHeightShelvesRecursive(books, shelf_width, index + 1, books[index][0] + usedWidth, Math.max(books[index][1], rowHeight), totalHeight);
		}		
		memo.put(key, Math.min(placedOnNewRow, placedOnSameRow));
		return memo.get(key);
	}
    
    
}
