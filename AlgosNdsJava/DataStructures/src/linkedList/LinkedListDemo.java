package linkedList;

import javax.sound.sampled.ReverbType;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		Node x = new Node(23);
		
		list.insertAtHead(5);
		list.insertAtHead(10);
		list.insertAtHead(2);
		list.insertAtHead(12);
		list.insertAtHead(20);
		list.insertAtHead(19);
		//list.insertAtTail(x);
		//list.getHead();
		
//	list.deleteFromHead();	
//	System.out.println(list.find(5));
//System.out.println(list);
//System.out.println(list.length());
//System.out.println(list.reverseLinkedList(list));
//System.out.println(list.findKthElement(2, list));
		System.out.println(list);
//list.appendLastNAtHead(list, 3);
		System.out.println(list.findKthElementFromTheEnd(1, list));
System.out.println(list);
	}

}
