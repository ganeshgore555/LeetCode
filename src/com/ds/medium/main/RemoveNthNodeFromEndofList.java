package com.ds.medium.main;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		RemoveNthNodeFromEndofList c = new RemoveNthNodeFromEndofList();
		ListNode node5 = c.new ListNode(5,null);
		ListNode node4 = c.new ListNode(4,node5);
		ListNode node3 = c.new ListNode(3,node4);
		ListNode node2 = c.new ListNode(2,node3);
		ListNode node1 = c.new ListNode(1,node2);
		ListNode head = node1;
		head = removeNthFromEndOptimal(head,3);
		ListNode current = head;
		while(current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {
		}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pointer1 = head;
		ListNode pointer2 = head;
		int totalNode = 1;
		while(true) {
			if(pointer1.next == null) {
				break;
			}else {
				pointer1 = pointer1.next;
				totalNode++;
			}
		}
		System.out.println(totalNode);
		int prevNodeIndex = totalNode - n - 1;
		
		if(prevNodeIndex == -1) { // Remove head
			head = head.next;
		}else if(prevNodeIndex == 0) { // Remove node next to head
			head.next = head.next.next;
		}else { // In between node
			while(prevNodeIndex > 0) {
				if(pointer2.next == null) {
					break;
				}else {
					pointer2 = pointer2.next;
					prevNodeIndex--;
				}
			}
			pointer2.next = pointer2.next.next;
		}
		return head;
	}
	
	public static ListNode removeNthFromEndOptimal(ListNode head, int n) {
		ListNode pointer1 = head;
		ListNode pointer2 = head;
		while(pointer2.next != null) {
			if(n == 0) {
				pointer1 = pointer1.next;
			}else {
				n--;
			}
			pointer2 = pointer2.next;
		}
		if(n == 1) {
			head = head.next;
		}else {
			pointer1.next = pointer1.next.next;
		}
		return head;
	}
	
}
