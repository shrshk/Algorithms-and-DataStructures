package atlassianPrep;

class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		this.val = x;
	}
}
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	// steps 2 4
    	// 1->2->3->4->5->NULL 1->4->3->2->5->NULL
    	// keep m-1, // reverse m to n
    	// get m node and n node
    	// attach m-1 to n node
    	// attach m to n+1 node
    	
    	ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode curr = fakeHead.next;
        int i = 1;
        while (i < m) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode node = prev;
        while (i <= n) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            i++;
        }
        node.next.next = curr;
        node.next = prev;
        return fakeHead.next;
    }
    
	private ListNode reverseLinkedList(ListNode head){
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
}
