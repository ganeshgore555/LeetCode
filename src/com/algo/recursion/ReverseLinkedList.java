package com.algo.recursion;

public class ReverseLinkedList {

	public class ListNode {
		int val;
		ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static void main(String[] args) {
		ListNode list = new ReverseLinkedList().new ListNode(1,
				new ReverseLinkedList().new ListNode(2,
					new ReverseLinkedList().new ListNode(4, null)));

		ListNode head = new ReverseLinkedList().reverseList(list);
	}

    public ListNode reverseList(ListNode head) {
    	ListNode prev = null;
    	ListNode next = null;
    	ListNode current = head;
    	
    	while(current != null) {
    		next = current.next;
    		current.next = prev;
    		prev = current;
    		current = next;
    	}
		return prev;
    }
	
}
