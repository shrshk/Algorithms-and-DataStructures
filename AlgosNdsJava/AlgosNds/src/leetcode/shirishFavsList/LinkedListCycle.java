package leetcode.shirishFavsList;

public class LinkedListCycle {
	static boolean isCyclic(ListNode head) {
		if (head==null || head.next == null)
			return false;
		ListNode slower  = head;
		ListNode faster = head.next;
		while(true) {
			if(faster == null || faster.next == null)
				return false;
			if(faster.equals(slower) || faster.next.equals(slower))
				return true;
			slower = slower.next;
			faster = faster.next.next;			
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		System.out.println(isCyclic(head));
	}
}
