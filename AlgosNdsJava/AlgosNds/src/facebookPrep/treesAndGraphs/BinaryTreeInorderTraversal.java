package facebookPrep.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	TreeNode(int x) {
		this.val = x;
	}
}

public class BinaryTreeInorderTraversal {	

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorderList = new ArrayList<>();
		
		helper(root, inorderList);

		return inorderList;
	}
	
	public List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> inorderList = new ArrayList<>();
		
		Stack<TreeNode> stack = new Stack<>();
		while(root!=null || !stack.isEmpty()) {
			while(root!=null) {				
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			inorderList.add(root.val);
			root = root.right;
		}
		

		return inorderList;
	}
	
	private void helper(TreeNode root, List<Integer> inorderList) {
		if (root==null)
			return;
		helper(root.left, inorderList);
		inorderList.add(root.val);
		helper(root.right, inorderList);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);

		System.out.println(new BinaryTreeInorderTraversal().inorderTraversalIterative(root));

	}
}
