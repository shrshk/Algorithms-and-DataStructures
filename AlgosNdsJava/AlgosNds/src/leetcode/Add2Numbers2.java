package leetcode;

import java.util.Stack;

public class Add2Numbers2 {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
	        ListNode curr = new ListNode(0);
	        int sum=0;
	        while(l1!=null) {
	            s1.push(l1.val);
	            l1=l1.next;
	        }
	        
	        while(l2!=null) {
	            s2.push(l2.val);
	            l2=l2.next;
	        }
	            
	        while(!s1.isEmpty()||!s2.isEmpty()) {
	            if (!s1.isEmpty())
	                sum+=s1.pop();
	            if(!s2.isEmpty())
	                sum+=s2.pop();
	            curr.val = sum%10;
	            ListNode head = new ListNode(sum/10);
	            head.next = curr;
	            curr = head;
	            sum/=10;
	        }
	        
	        return curr.val == 0? curr.next : curr;
	    }
	}
}
