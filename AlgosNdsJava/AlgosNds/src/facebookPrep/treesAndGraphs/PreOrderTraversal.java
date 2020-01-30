package facebookPrep.treesAndGraphs;

public class PreOrderTraversal {
//	public void flatten(TreeNode root) {
//		// steps
//		// print root // add right to the stack go left
//		Stack<TreeNode> stack = new Stack<>();
//		while (root != null || !stack.isEmpty()) {
//			while (root != null) {
//				if (root.right != null)
//					stack.push(root.right);
//				if (root.left != null)
//					root.right = root.left;
//				root = root.left;
//			}
//			root = stack.pop();
//		}
//		
//		while(root!=null) {
//			System.out.println(root.val);
//			root = root.right;
//		}
//			
//
//	}
	
	public void flatten(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left != null) {
				TreeNode last = cur.left;
				while (last.right != null) last = last.right;
				last.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		new PreOrderTraversal().flatten(root);
	}
}
