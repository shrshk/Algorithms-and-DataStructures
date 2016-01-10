import java.util.HashSet;
import java.util.Set;

import chapter5.LinkedList;
import chapter5.Node;

public class Assignment4 {

	/**
	 * PROBLEM 1:
	 * One method is straightforward - first find the length by going through
	 * all the nodes, and then get to the (length-n) node from head and update
	 * the references A more interesting method is what is shown here, we keep
	 * two references, both initialised to the head, lets call them ref1 and
	 * ref2 First move ref1 to the nth node. Then move both ref1 and ref2,
	 * together, until ref1 reaches the end of the list. ref2 should now be
	 * pointing to the right node.
	 * 
	 * @param ll
	 */
	public void appendLastNAtHead(LinkedList ll, int n) {
		Node<Integer> ref1 = ll.getHead();
		Node<Integer> ref2 = ll.getHead();
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

	/**
	 * PROBLEM 2:
	 * This method maybe considered to be a part of the linked list itself.
	 * 
	 * @param ll
	 */
	public void reverse(LinkedList ll) {
		Node prev = null;
		Node current = ll.getHead();
		Node next;
		while (current != null) {
			next = current.getNextNode();
			current.setNextNode(prev);
			prev = current;
			current = next;
		}
		ll.setHead(prev);
	}

	/**
	 * PROBLEM 3:
	 * If you have done or understood the solution to problem 1, this is straightforward
	 * 
	 */
	
	/**
	 * PROBLEM 4:
	 * We can use the Set data structure provided by the JDK.
	 * A set contains ONLY UNIQUE elements. So as we traverse the linked list
	 * we can keep checking if the element exists in the set, if it does not, we add the new element to the set
	 * otherwise we remove it from the linked list.
	 * So this will be done in O(n) time.
	 * 
	 * If additional memory is not allowed, then we need to compare each
	 * element with the remaining ones (a loop inside a loop). The time complexity
	 * will be O(n²) [order of n squared - in case your editor is not showing unicode characters]
	 * 
	 */
	public void deleteDuplicates1(LinkedList ll) {
		Set<Integer> items = new HashSet<Integer>(); // assuming that ll contains integer type of data
		Node curr = ll.getHead();
		Node prev = null;
		while (curr != null) {
			if (items.contains(curr.getData())) {
				prev.setNextNode(curr.getNextNode());
			} else {
				items.add((Integer)curr.getData());
				prev = curr;
			}
			curr = curr.getNextNode();
		}
	}
	
	public void deleteDuplicates2(LinkedList ll) {
		// implement the second method yourself
	}
	
	/**
	 * PROBLEM 5:
	 * Given the node to be deleted, we cannot access it's previous node. So what we can do
	 * is that we copy the data from the next node of the node passed to this node, and then delete
	 * the next node.
	 * NOTICE: This problem cannot be solved if the node to be deleted is the last node in the linked list
	 * TIME COMPLEXITY : O(1)
	 */
	public void deleteNode(Node n) {
		if (n != null && n.getNextNode() != null) {
			n.setData(n.getNextNode().getData()); // copy the data over to n
			n.setNextNode(n.getNextNode().getNextNode()); // next node of n is deleted now
		}
	}
	
	/**
	 * PROBLEM 6:
	 * We can use two pointers moving at different speeds. One goes slower (jumps one node at a time),
	 * while the other pointer goes faster (jumps 2 nodes at a time). If the faster pointer is ever equal to the slower
	 * one, then the list is circular (or cyclic). If the faster pointer reaches null, then
	 * there are no cycles in the list (acyclic)
	 * TIME COMPLEXITY : O(n)
	 */
	public boolean isCyclic(LinkedList ll) {
		if (ll == null || ll.getHead() == null || ll.getHead().getNextNode() == null)
			return false;
		Node slower = ll.getHead();
		Node faster = ll.getHead().getNextNode();
		while (true) { // keep going
			if (faster == null || faster.getNextNode() == null)
				return false;
			if (faster.equals(slower) || faster.getNextNode().equals(slower))
				return true;
			slower = slower.getNextNode();
			faster = faster.getNextNode().getNextNode();
		}
	}
	
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.addAtStart(7);
		ll.addAtStart(6);
		ll.addAtStart(5);
		ll.addAtStart(4);
		ll.addAtStart(3);
		ll.addAtStart(2);
		ll.addAtStart(1);
		Assignment4 prob = new Assignment4();
		System.out.println(ll);
//		prob.appendLastNAtHead(ll, 5);
//		prob.reverse(ll);
//		prob.deleteDuplicates1(ll);
//		System.out.println(ll);
		prob.deleteNode(ll.getHead());
		System.out.println(ll);
	}
	
	

}
