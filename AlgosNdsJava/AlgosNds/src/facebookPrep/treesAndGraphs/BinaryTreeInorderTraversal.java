package facebookPrep.treesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;



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
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
System.out.println(3/2);
		System.out.println(new BinaryTreeInorderTraversal().inorderTraversalIterative(root));
		
		List<Integer> x = Arrays.asList(2,1,3,4);
		List<Integer> xx = x.stream().filter(item -> item>=2 && item<=4).collect(Collectors.toList());
		
		System.out.println(xx);

	}
}
