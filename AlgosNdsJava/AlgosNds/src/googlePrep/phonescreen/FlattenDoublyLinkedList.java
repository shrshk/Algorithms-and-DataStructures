package googlePrep.phonescreen;

class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
};

public class FlattenDoublyLinkedList {
	// cases:
	// head null, return head // case 1
	// no child no next , reached the end return // case 2
	// no child next, keep going next no flatten // case 3
	// child, no next - flatten child done. // case 4
	// child, next - flatten child, connect it with next and go next // case 5
	public Node flatten(Node head) {
		flattenTail(head);
		return head;
	}

	private Node flattenTail(Node head) {
		if (head == null)
			return head;
		if (head.child == null) {
			if (head.next == null) {
				return head; // case 2
			}
			return flattenTail(head.next); // case 3
		} else {
			Node child = head.child;
			head.child = null;
			Node next = head.next;
			Node childTail = flattenTail(child);
			head.next = child;
			child.prev = head;
			if (next == null)
				return childTail; // case 4
			childTail.next = next;
			next.prev = childTail;
			return flattenTail(next); // case 5
		}
	}

}
