package linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
	private Node head;
	
	public void insertAtHead(int data){
		Node newNode = new Node (data);
		newNode.setNextNode(this.head);
		this.head=newNode;
	}
	public Node getHead(){
		return this.head;
	}
	public void setHead(Node node){
		this.head=node;
	}
	//Assgn 4
	public void moveNodes(int n,LinkedList list){
		int x = list.length()-n;
		
		for(int i=0;i<x;i++){
			Node current=this.head;
		}
		
	}
	public void appendLastNAtHead(LinkedList ll, int n) {
		Node ref1 = ll.getHead();
		Node ref2 = ll.getHead();
		// move ref1 by n
		for (int i = 0; i < n; i++) {
			ref1 = ref1.getNextNode();
		}
		while (ref1.getNextNode() != null) {
			ref1 = ref1.getNextNode();
			ref2 = ref2.getNextNode();
		} // now ref1 should be pointing to the last node

		ref1.setNextNode(ll.getHead()); // last node now connects with the head
		// we need to make the next node of ref2 as the head of the list
		ll.setHead(ref2.getNextNode());
		ref2.setNextNode(null);
	}
	//reverse Linked List
	public LinkedList reverseLinkedList(LinkedList list){
		Node prev=null;
		Node next;
		Node current = this.head;
		while(current!=null){
			next = current.getNextNode();
			current.setNextNode(prev);
			//next.setNextNode(current);
			prev=current;
			current=next;
			
		}
		list.setHead(prev);
		return list;
	}
	//Find kth element from the head
	public int findKthElement(int k,LinkedList list){
		Node current = list.getHead();
		
		for(int i=0;i<k;i++){
			current=current.getNextNode();
			
		}
		
		return current.getData();
		
	}
	
	//Find kth element from the end
	public int findKthElementFromTheEnd(int k,LinkedList list){
		Node ref1 = list.getHead();
		Node ref2 = list.getHead();
		for(int i=0;i<k;i++){
			ref1 = ref1.getNextNode();
		}
		while(ref1.getNextNode()!=null){
			ref1 = ref1.getNextNode();
			ref2 = ref2.getNextNode();
		}
		int data = ref2.getData();
		return data;
	}
//	public int findKthElementFromTheEnd(int k,LinkedList list){
//		//int x=list.length()-k;
//	   
//		Node current=list.getHead(list);
//		while(current!=null){
//		for(int j=0;j<list.length();j++){
//			 current=current.getNextNode();
//		}
//		
//		for(int i=list.length();i>=k-1;i--){
//			current.getNextNode();
//		}
//	}
//		return current.getData();
//	}
	
	public void DeleteDuplicates(LinkedList list){
		Node prev=null;
		Node current = list.getHead();
		Set<Integer> mySet = new HashSet<Integer>();
		while(current!=null){
			if(mySet.contains(current.getData())){
				prev.setNextNode(current.getNextNode());
								
			}
			else{
				mySet.add(current.getData());
				prev=current;
			}
			current = current.getNextNode();
		}
		
		
	}
	public void DeleteGivenNode(Node x,LinkedList list){
		Node prev = null;
		Node current = list.getHead();
		
		
			
			while(current!=null){
			if(current==x){
				prev.setNextNode(current.getNextNode());
			}
			else{
				prev=current;
			}
			current = current.getNextNode();
			}
		
		
		
	}
	public void DeleteGivenNode(Node n){
		if(n!=null && n.getNextNode()!=null){
			n.setData(n.getNextNode().getData());
			n.setNextNode(n.getNextNode().getNextNode());
		}
	}
	public boolean isCyclic(LinkedList list){
		if(list==null || list.getHead()==null || list.getHead().getNextNode()==null){
			return false;
		}
		Node slower = list.getHead();
		Node faster = list.getHead().getNextNode();
		while(true){
			if(faster==null || faster.getNextNode()==null){
				return false;
			}
			if(faster.equals(slower)||faster.getNextNode().equals(slower)){
				return true;
			}
			slower = slower.getNextNode();
			faster = faster.getNextNode().getNextNode();
		}
		
		
		
	}
	
	
	
	//End ofAssignment 4
	public int length(){
		Node current = this.head;
		int length = 0;
		while(current!=null){
			length++;
		current = current.getNextNode();
		}
		return length;
	}
	public void deleteFromHead(){
		this.head=this.head.getNextNode();
	}
	public Node find(int data){
		Node current = this.head;
		while(current!=null){
			if(current.getData()==data){
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "{";
		Node current = this.head;
		
		while(current!=null){
			result = result + current.toString();
			current = current.getNextNode();
		}
			result = result + "}";
			return result;
		}
		
	}


