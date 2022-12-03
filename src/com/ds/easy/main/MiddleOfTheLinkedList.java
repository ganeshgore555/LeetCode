package com.ds.easy.main;

public class MiddleOfTheLinkedList {

	public static void main(String[] args) {

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

	public ListNode middleNode(ListNode head) {
		ListNode pointer1 = head;
		ListNode pointer2 = head;
		
		while(true) {
			if(pointer2.next == null) {
				return pointer1;
			}else if(pointer2.next.next == null) {
				return pointer1.next;
			}else {
				pointer1 = pointer1.next;
				pointer2 = pointer2.next.next;
			}
		}
	}
}
