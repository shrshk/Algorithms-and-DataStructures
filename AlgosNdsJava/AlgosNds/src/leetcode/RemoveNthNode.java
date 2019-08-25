package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.ListNode;

public class RemoveNthNode {
	
	static ListNode removeNthNodeFromEnd(ListNode head, int n) {
		// move one pointer by n
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		for(int i=0;i<=n;i++) {
			fast = fast.next;
		}
		
		while(fast!=null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;		
		
		return dummy.next;
	}
	
	 public static void main(String[] args) {
		 List<ListNode> list = new ArrayList<>();
		 
		 for (int i=1;i<=5;i++) {
			 list.add(new ListNode(i));
		 }
		 
		 for (int i=0;i<4;i++) {
			 list.get(i).next = list.get(i+1);
		 }		 
		 
		 
		ListNode result = removeNthNodeFromEnd(list.get(0), 2);
		
		List<Integer> resultNums = new ArrayList<>();
		
		while(result.next!=null) {
			resultNums.add(result.val);
			result = result.next;
		}
		
		resultNums.add(result.val);
		
		System.out.println(Arrays.toString(resultNums.toArray()));
	}
}
