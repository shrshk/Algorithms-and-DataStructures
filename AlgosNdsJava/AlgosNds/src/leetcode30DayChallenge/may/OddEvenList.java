package leetcode30DayChallenge.may;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class OddEvenList {
	public ListNode oddEvenList(ListNode head) {
		// 2->1->3->5->6->4->7
		// 2->3->6->7->1->5->4->NULL
		// odd even
		ListNode odd = head;
		ListNode even = head.next;

		ListNode firstEven = even;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = firstEven;

		return head;

	}

	public ListNode rearrangeList(ListNode head) {
		ListNode odd = new ListNode();
		ListNode even = new ListNode();
		ListNode oddTail = odd;
		ListNode evenTail = even;

		ListNode curr = head;

		while (curr != null) {
			if (curr != null && curr.val % 2 != 0) {
				oddTail.next = curr;
				oddTail = oddTail.next;
			} else {
				evenTail.next = curr;
				evenTail = evenTail.next;
			}
			curr = curr.next;
		}

		evenTail.next = odd.next;
		odd.next = null;

		return even.next;

	}
}
