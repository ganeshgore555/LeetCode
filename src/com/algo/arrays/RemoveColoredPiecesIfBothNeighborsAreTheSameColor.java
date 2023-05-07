package com.algo.arrays;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

	public static void main(String[] args) {
		String colors = "AAAABBBB";
		System.out.println(new RemoveColoredPiecesIfBothNeighborsAreTheSameColor().winnerOfGame(colors));
	}
	
    public boolean winnerOfGame(String colors) {
        if(colors.length() <=2)
        {
            return false;	// BOB will win if "AA" or "BB" or "A" or "B"
        }
        
        int[] triple = triplets(colors);	//Calculating all the triplets in the string AAA, BBB

        if(triple[0] > triple[1])
        {
            return true;    //Alice wins, as it has more number of triplets
        }
        else
        {
            return false; 	//Bob wins, also this condition will be true when triple A == triple B 
        }
    }
	    
    public int[] triplets(String colors)
    {
        int tripleA = 0, tripleB = 0;
        
        for(int i = 2; i<colors.length(); i++)    
        {
            //If, we get 3 continuous A's
            if(colors.charAt(i-2) == 'A' && colors.charAt(i-1) == 'A' && colors.charAt(i) == 'A')
            {
                tripleA++;    
            }
            //If, we get 3 continuous B's
            else if(colors.charAt(i-2) == 'B' && colors.charAt(i-1) == 'B' && colors.charAt(i) == 'B')
            {
                tripleB++;
            }
        }
        return new int[] {tripleA, tripleB};  
    }    
}
