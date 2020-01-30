package amazonLeetCode.treesAndGraphs;

import java.util.Stack;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		// 3 2 4 1
		// 4 2 3 1 
		//  1
//		   / \
//		   2   2
//		  / \ / \
//		 3  4 4  3		
		return helper(root, root);
	}
	
	private boolean helper(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 ==null)
			return true;
		if (r1 == null || r2 == null)
			return false;
		return (r1.val == r2.val) && helper(r1.left, r2.right) && helper(r1.right, r2.left);
	}
	
	public boolean isSymmetricIterative(TreeNode root) {
		// 2 3 4 // 2 3 4 
		// 1 2 3
		Stack<TreeNode> q = new Stack<>();
		q.add(root);
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode r1 = q.pop();
			TreeNode r2 = q.pop();
			if (r1 == null && r2 == null)
				continue;
			if (r1 == null || r2 == null)
				return false;
			if (r1.val!=r2.val)
				return false;
			q.add(r1.left);
			q.add(r2.right);
			q.add(r1.right);
			q.add(r2.left);
			
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(new SymmetricTree().isSymmetric(root));
		System.out.println(new SymmetricTree().isSymmetricIterative(root));
	}
}
