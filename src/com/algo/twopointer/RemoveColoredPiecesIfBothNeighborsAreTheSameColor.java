package com.algo.twopointer;

import java.util.Arrays;
import java.util.LinkedList;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

	public static void main(String[] args) {
		String colors = "AAAABBBB";
		System.out.println(new RemoveColoredPiecesIfBothNeighborsAreTheSameColor().winnerOfGame(colors));
	}
	
	public class Node{
		Node next;
		Node prev;
		char value;
		private Node(char value) {
			super();
			this.value = value;
		}
		@Override
		public String toString() {
			return value+"";
		}
	}
	
    public boolean winnerOfGame(String colors) {
        Node curr = new Node(colors.charAt(0));
        Node head = curr;
        Node prev = null;
        Node a = head;
        Node b = head;        
        for(int i = 1; i < colors.length(); i++) {
        	prev = curr;
        	Node temp = new Node(colors.charAt(i));
        	temp.prev = prev;
        	prev.next = temp;
        	curr = temp;
        }
                
        while(a != null && a.next != null && b != null && b.next != null) {
        	while(a.next != null) {
        		Node prevA = a;
        		a = a.next;
        		if(prevA.value == 'A' && a.value == 'A' && a.next != null && a.next.value == 'A') {
        			prevA.next = a.next;
        			a.next.prev = prevA;
        			break;
        		}
        	}
        	while(b.next != null) {
        		Node prevB = b;
        		b = b.next;
        		if(prevB.value == 'B' && b.value == 'B' && b.next != null && b.next.value == 'B') {
        			prevB.next = b.next;
        			b.next.prev = prevB;
        			break;
        		}
        	}        	
        }
        if(a == null || a.next == null)
        	return false;
        else
        	return true;
    }
	
}
