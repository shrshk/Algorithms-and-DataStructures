package googlePrep.phonescreen;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class BinaryTreeIterator {

	Stack<TreeNode> stack;
	TreeNode root;

	public BinaryTreeIterator(TreeNode root) {
		stack = new Stack<>();
		this.root = root;
	}

	/** @return the next smallest number */
	public int next() {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		root = stack.pop();
		int res = root.val;
		root = root.right;
		return res;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty() || root != null;
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
