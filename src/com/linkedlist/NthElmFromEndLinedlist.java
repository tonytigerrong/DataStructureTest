package com.linkedlist;

public class NthElmFromEndLinedlist {
	private Node head;
	 
	private static class Node {
		private int value;
		private Node next;
 
		Node(int value) {
			this.value = value;
 
		}
	}
 
	public void addToTheLast(Node node) {
 
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null 
					&& temp.next != head // stop loop at head point
					)
				temp = temp.next;
 
			temp.next = node;
		}
		node.next = head;
	}
 
 
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}
 
	public boolean ifLoopExists(){
		Node h = head;
		Node t = head;
		while(t.next != null){
			t = t.next;
			if(h == t)
				return true;
		}
		return false;
	}
 
	public Node nthFromLastNode(Node head,int n)
	{
		Node firstPtr=head;
		Node secondPtr=head;
 
		for (int i = 0; i < n; i++) {
			firstPtr=firstPtr.next;
 
		}
 
		while(firstPtr!=null)
		{
			firstPtr=firstPtr.next;
			secondPtr=secondPtr.next;
		}
 
		return secondPtr;
	}
 
	public static void main(String[] args) {
		NthElmFromEndLinedlist list = new NthElmFromEndLinedlist();
		// Creating a linked list
		Node head=new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
 
//		list.printList();
		// Finding 3rd node from end
//		Node nthNodeFromLast= list.nthFromLastNode(head,3);
//		System.out.println("3th node from end is : "+ nthNodeFromLast.value);
		System.out.println("Is loop: "+list.ifLoopExists());
 
	}
}
