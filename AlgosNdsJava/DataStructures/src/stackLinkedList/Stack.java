package stackLinkedList;

import linkedList.DoublyLinkedList;
import linkedList.DoublyLinkedNode;

public class Stack {
	DoublyLinkedList items = new DoublyLinkedList();
	int top = -1;
	private DoublyLinkedNode head;

	public boolean isEmpty(){
		return top<0;
	}
	public void push(int item){
//		if(top==items.length()-1){
//			throw new RuntimeException("Stack is Full"); 
//		}
		 items.insertAtHead(item);
	}
	public void pop(){
//		if(isEmpty()){
//			throw new RuntimeException("Stack is Empty");
//		}
		items.deleteFromHead();
	}
	public void peek(){
		DoublyLinkedNode current=this.head;
		while(current!=null){
			current = current.getNextNode();
			System.out.println(current.getData()); 
		}
		//System.out.println(current.getData());
		//throw new RuntimeException("Stack is Empty");
	
		
	}
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(23);
		stack.push(29);
		stack.push(7);
		stack.push(10);
		System.out.println(stack.items);
		stack.peek();
		stack.pop();
	}
}
