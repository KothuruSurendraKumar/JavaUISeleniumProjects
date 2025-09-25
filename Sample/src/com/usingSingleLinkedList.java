package com;

public class usingSingleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3,new ListNode(9))));
		ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
		
		ListNode l3 = addTwoListNodes(l1,l2);
		while(l3 != null) {
			System.out.println(l3.val);
			l3=l3.next;
		}

	}

	private static ListNode addTwoListNodes(ListNode l1, ListNode l2) {
		// TODO Auto-generated method stub
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		int carry = 0;
		while(l1 != null || l2 != null|| carry != 0) {
			int sum = carry;
			if(l1 != null) {
				sum = sum + l1.val;
				l1 = l1.next;
			}
			if(l2 != null) {
				sum = sum + l2.val;
				l2 = l2.next;
			}
			
			carry = sum/10;
			current.next = new ListNode(sum %10);
			current = current.next;
		}
		
		return dummy.next;
	}

}

class ListNode {
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
