package linkedList;

public class DoublyLinkedList {
	private DoublyLinkedNode head;
	
	
public void insertAtHead(int data){
	
	 DoublyLinkedNode newNode = new DoublyLinkedNode(data);
	 newNode.setNextNode(this.head);
	 if(this.head!=null){
		 this.head.setPreviousNode(newNode);
	 }
	 this.head=newNode;
}
public int length(){
	int length=0;
	if(head==null){
		return 0;
		
	}
	else{
		DoublyLinkedNode current=this.head;
		while(current!=null){
			length++;
			current = current.getNextNode();
		}
	}
	return length;
}
public void deleteFromHead(){
	this.head=this.head.getNextNode();
}
@Override
public String toString() {
	String result="";
	DoublyLinkedNode current =this.head;
	while(current!=null){
		//current.toString();
		result = result+current.toString();
		
		current=current.getNextNode();
		
	}
	return result;
}
}
