package amazonPractice;

//Java Program for Lowest Common Ancestor in a Binary Tree 
//A O(n) solution to find LCA of two given values n1 and n2 
import java.util.ArrayList;
import java.util.List;

//A Binary Tree node 
class Node {
	int data;
	Node left, right;

	Node(int value) {
		data = value;
	}
}

public class LowestCommonAncestorBT {

	private List<Node> path1 = new ArrayList<>();
	private List<Node> path2 = new ArrayList<>();

	// Finds the path from root node to given root of the tree.
	Node findLCA(Node root, Node n1, Node n2) {
		return findLCAInternal(root, n1, n2);
	}

	private Node findLCAInternal(Node root, Node n1, Node n2) {

		if (findPath(root, n1, path1) == null || findPath(root, n2, path2) == null) 
			return null;

		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			// System.out.println(path1.get(i) + " " + path2.get(i));
			if (!path1.get(i).equals(path2.get(i)))
				break;
		}

		return path1.get(i - 1);
	}

	// Finds the path from root node to given root of the tree, Stores the
	// path in a vector path[], returns true if path exists otherwise false
	private List<Node> findPath(Node root, Node n, List<Node> path) {
		// base case
		if (root == null) {
			return path;
		}

		// Store this node . The node will be removed if
		// not in path from root to n.
		path.add(root);

		if (root.data == n.data) {
			return path;
		}

		if (root.left != null && findPath(root.left, n, path) != null) {
			return path;
		}

		if (root.right != null && findPath(root.right, n, path) != null) {
			return path;
		}

		// If not present in subtree rooted with root, remove root from
		// path[] and return false
		path.remove(path.size() - 1);

		return null;
	}

	// Driver code
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		Node lca = new LowestCommonAncestorBT().findLCAInternal(root, root.left.left, root.left.right);
		//Node lca = new LowestCommonAncestorBT().findLCA(root, new Node(10), new Node(11));
		int lcaVal = lca!=null ? lca.data : -1;

		System.out.println("LCA(4, 5): " + lcaVal );

	}
}
