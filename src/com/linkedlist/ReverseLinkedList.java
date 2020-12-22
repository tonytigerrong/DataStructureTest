package com.linkedlist;

public class ReverseLinkedList {
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
			while (temp.next != null)
				temp = temp.next;
 
			temp.next = node;
		}
	}
 
 
	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static Node reverseInpairs(Node head){
		Node preNode = null;
		Node currentNode = head;
		Node scdNode =  null;
		Node trdNode = null;
		
		Node returnNode = null;
		// 5 6 7 8 9
		// 6 5 8 7 9
		// null 5 6 7 8 9 null
		while(currentNode != null && currentNode.next != null){
			preNode = null;
			
			scdNode = currentNode.next;
			if(preNode == null) returnNode = scdNode;
			trdNode = currentNode.next.next;
			
			
			if(preNode != null) preNode.next = scdNode;
			currentNode.next = trdNode;
			
			currentNode = trdNode;
		}
		
		return returnNode;
		
//		Node current=head;
//		Node temp=null;
//		Node newHead =null;
//		while (current != null && current.next != null) {
// 
//			if (temp != null) {
//				// This is important step
//				temp.next.next = current.next;
//			}
//			temp=current.next;     
//			current.next=temp.next;
//			temp.next=current;
// 
//			if (newHead == null)
//				newHead = temp;
//			current=current.next;
// 
//		}     
//		return newHead;

	}
 
	public static Node reverseLinkedList(Node currentNode){
		Node preNode = null;
		Node nextNode = null;
		while (currentNode != null){
			nextNode = currentNode.next;
			currentNode.next = preNode;
			preNode = currentNode;
			currentNode = nextNode;
		}
//		currentNode.next = preNode;
		return preNode;
	}
	// Reverse linkedlist using this function 
//	public static Node reverseLinkedList(Node currentNode)
//	{
//		// For first node, previousNode will be null
//		Node previousNode=null;
//		Node nextNode;
//		while(currentNode!=null)
//		{
//			nextNode=currentNode.next;
//			// reversing the link
//			currentNode.next=previousNode;
//			// moving currentNode and previousNode by 1 node
//			previousNode=currentNode;
//			currentNode=nextNode;
//		}
//		return previousNode;
//	}
// 
	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		// Creating a linked list
		Node head=new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(8));
		list.addToTheLast(new Node(9));
 
		list.printList(head);
		//Reversing LinkedList
//		Node reverseHead=reverseLinkedList(head);
//		System.out.println("After reversing");
//		list.printList(reverseHead);
		Node reverseHead = reverseInpairs(head);
		System.out.println("After Inpairs reversing");
		list.printList(reverseHead);
		
		
 
	}
}
