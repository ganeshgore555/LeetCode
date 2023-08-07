package com.algo.stack;

import java.util.*;

public class AddTwoNumbersII {

	public class ListNode {
		int val;
		ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode temp1 = l1;
        while(temp1 != null) {
        	s1.push(temp1);
        	temp1 = temp1.next;
        }
        ListNode temp2 = l2;
        while(temp2 != null) {
        	s2.push(temp2);
        	temp2 = temp2.next;
        }
        int carryOver = 0;
        Stack<ListNode> result = new Stack<>();
        while(!s1.isEmpty() || !s2.isEmpty()) {
        	int val1 = !s1.isEmpty() ? s1.pop().val : 0;
        	int val2 = !s2.isEmpty() ? s2.pop().val : 0;
        	int sum = val1 + val2 + carryOver;
        	int val = sum;
        	if(sum > 9) {
        		carryOver = sum / 10;
        		val = sum % 10;
        	}else {
        		carryOver = 0;
        	}
        	ListNode node = new ListNode(val);
        	node.next = result.isEmpty() ? null : result.peek();
        	result.push(node);
        }
        if(carryOver != 0) {
        	ListNode node = new ListNode(carryOver);
        	node.next = result.isEmpty() ? null : result.peek();
        	result.push(node);
        }
        return result.peek();
    }
}
