package facebookPrep.treesAndGraphs;

import java.util.Stack;

public class BinaryTreeKthSmallest {
    public int kthSmallest(TreeNode root, int k) {
    	// inorder traversal
    	Stack<TreeNode> stack = new Stack<>();
    	while(root!=null || !stack.isEmpty()) {
    		while(root!=null) {
    			stack.push(root);
    			root = root.left;
    		}
    		root = stack.pop();
    		if(--k==0) break;
    		root = root.right;
    	}
    	
        return root.val;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		System.out.println(new BinaryTreeKthSmallest().kthSmallest(root, 2));
	}
}
