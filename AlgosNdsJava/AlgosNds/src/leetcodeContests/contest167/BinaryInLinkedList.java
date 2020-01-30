package leetcodeContests.contest167;

class ListNode {
	ListNode next;
	int val;
}

public class BinaryInLinkedList {
	public int getDecimalValueBF(ListNode head) {
		String num = "";
		ListNode current = head;
		while (current != null) {
			num += current.val;
			current = current.next;
		}
		return Integer.parseInt(num, 2);
	}

	public int getDecimalValue(ListNode head) {
		int num = 0;
		while (head != null) {
			num = num * 2 + head.val;
			head = head.next;
		}
		return num;
	}

	public int getDecimalValueBW(ListNode head) {
		int ans = 0;
		while (head != null) {
			ans = (ans << 1) | head.val;
			head = head.next;
		}
		return ans;
	}
}
