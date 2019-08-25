package leetcode.shirishFavsList;
class Node {
	int val;
	Node nextNode;
	Node(int x) {
		this.val = x;
	}
}

// 1  2 4      1 3 4     0 -> 1
public class MergeTwoSortedLists {
	static Node mergeTwoLists(Node Node1, Node Node2) {
		if (Node1==null && Node2==null)
			return null;
		if (Node1==null)
			return Node2;
		if (Node2==null)
			return Node1;		
		Node result = new Node(0);
		Node prev = result;
		while (Node1!=null && Node2!=null) {
			if (Node1.val<=Node2.val){
				prev.nextNode = Node1;
				Node1 = Node1.nextNode;
			} else {
				prev.nextNode = Node2;
				Node2 = Node2.nextNode;
			}
			prev = prev.nextNode;
		}
		if (Node1!=null)
			prev.nextNode = Node1;
		if (Node2!=null)
			prev.nextNode = Node2;
		return result.nextNode;
	}
	public static void main(String[] args) {
		Node Node1 = new Node(1);
		Node1.nextNode = new Node(2);
		Node1.nextNode.nextNode = new Node(4);
		Node Node2 = new Node(1);
		Node2.nextNode = new Node(3);
		Node2.nextNode.nextNode = new Node(4);
		System.out.println(mergeTwoLists(Node1, Node2));
	}
	
}
