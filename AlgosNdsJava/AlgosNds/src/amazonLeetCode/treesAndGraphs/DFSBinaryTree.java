package amazonLeetCode.treesAndGraphs;

import java.util.Stack;

public class DFSBinaryTree {
	public void dfsRecursive(TreeNode root) {
		if (root == null)
			return;
		dfsRecursive(root.left);
		System.out.println(root.val);
		dfsRecursive(root.right);
	}

	public void dfsIterative(TreeNode root) {
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				System.out.println(current.val);
				current = current.right;
			}
		}

	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		// new DFSBinaryTree().dfsIterative(root);
		new DFSBinaryTree().dfsRecursive(root);
	}
}
