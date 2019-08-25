package leetcode.shirishFavsList;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}

public class ReverseLinkedList {
	static ListNode reverseLinkedList(ListNode head){
		ListNode prev = null;
		ListNode current = head;
		while(current!=null) {		
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		System.out.println(reverseLinkedList(head).val);
	}
	
}
