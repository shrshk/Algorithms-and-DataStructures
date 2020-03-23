package leetcodeContests.contest180;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BstToBalancedBst {
	public TreeNode balanceBST(TreeNode root) {
		// steps
		// build list of vals
		// build a bst with list of vals.
		List<Integer> inOrderList = inOrderList(root);
		return buildBalancedBST(inOrderList);
	}

	private TreeNode buildBalancedBST(List<Integer> inOrderList) {
		Collections.sort(inOrderList);
		return buildBalancedBST(inOrderList, 0, inOrderList.size() - 1, null);
	}

	private TreeNode buildBalancedBST(List<Integer> inOrderList, int low, int high, TreeNode root) {
		// base case
		if (low > high) {
			return root;
		}

		// find middle element of current range
		int mid = (low + high) / 2;

		// construct a new node from mid element and assign it to root
		root = new TreeNode(inOrderList.get(mid));

		// left subtree of root will be formed by keys less than mid element
		root.left = buildBalancedBST(inOrderList, low, mid - 1, root.left);

		// right subtree of root will be formed by keys less than mid element
		root.right = buildBalancedBST(inOrderList, mid + 1, high, root.right);

		return root;
	}

	private List<Integer> inOrderList(TreeNode root) {
		List<Integer> inOrder = new ArrayList<>();

		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			inOrder.add(root.val);
			root = root.right;
		}

		return inOrder;
	}
}
