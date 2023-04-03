package com.ds.easy.main;

public class MergeTwoSortedLists {
	public class ListNode {
		int val;
		ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	
	public static void main(String[] args) {
		/*
		ListNode list1 = new MergeTwoSortedLists().new ListNode(1,
							new MergeTwoSortedLists().new ListNode(2,
								new MergeTwoSortedLists().new ListNode(4, null)));
		
		ListNode list2 = new MergeTwoSortedLists().new ListNode(1,
				new MergeTwoSortedLists().new ListNode(3,
					new MergeTwoSortedLists().new ListNode(4, null)));
		*/
		ListNode list1 = new MergeTwoSortedLists().new ListNode(1, null);;
		ListNode list2 = null;
		ListNode list3 = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
		
		while(list3 != null) {
			System.out.print(list3.val + " ");
			list3 = list3.next;
		}
	}

	
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	ListNode head1 = list1; 
    	ListNode head2 = list2;
    	ListNode head3 = null;
    	ListNode tail3 = null;
    	ListNode nextNode = null;

    	while(head1 != null && head2 != null) {
	    	if(head1.val <= head2.val ) {
	    		nextNode = head1;
	    		head1 = head1.next;
	    	}else {
	    		nextNode = head2;
	    		head2 = head2.next;
	    	}
	    	if(head3 == null) {
	    		head3 = nextNode;
	    	}else {
	    		tail3.next = nextNode;
	    	}
    		tail3 = nextNode;
    	}    	
    	if(head1 == null && head2 != null) {
    		if(tail3 != null)
    			tail3.next = head2;
    		else {
        		head3 = head2;
        		tail3 = head2;
    		}
    	}else if(head2 == null && head1 != null) {
    		if(tail3 != null)
    			tail3.next = head1;
    		else {
        		head3 = head1;
        		tail3 = head1;
    		}

    	}
		return head3;
    }
}
