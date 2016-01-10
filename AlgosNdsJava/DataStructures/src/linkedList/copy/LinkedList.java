package linkedList.copy;

public class LinkedList{
	private Node head;
	
	public void insertAtHead(int data){
		Node newNode = new Node(data);
		newNode.setNextNode(this.head);
		this.head=newNode;
		
		
	}

	@Override
	public String toString() {
		Node current = this.head;
		String result="";
		while(current!=null){
			result = result+current.toString();
			current = current.getNextNode();
		}
		return result;
		
	}

	
}
