package amazonPractice.copyListWithRandomPtr;

//Definition for a Node.
class Node {
	int val;
	Node next;
	Node random;

	public Node(int val, Node next, Node random) {
		this.val = val;
		this.next = next;
		this.random = random;
	}
}

public class CopyListWithRandomPointer {
	public Node copyRandomList(Node head) {
		if (head == null)
			return head;
		Node curr = head;

		// add copy nodes next to real ones 1 1" 2 " 3 3" ....
		while (curr != null) {
			Node next = curr.next;
			curr.next = new Node(curr.val, next, null);
			curr = next;
		}

		curr = head;

		// assign random node links to copy nodes 1->3 1'->3'
		while (curr != null) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}
			curr = curr.next.next;
		}

		curr = head;
		Node copyHead = head.next;

		while (curr != null) {
			Node next = curr.next.next; //2
			Node copy = curr.next; // 1'

			curr.next = next; // 1->2
			if (next != null) {
				copy.next = next.next; // 1'->2'
			}

			curr = next; // 1=2

		}

		return copyHead;

	}
}
