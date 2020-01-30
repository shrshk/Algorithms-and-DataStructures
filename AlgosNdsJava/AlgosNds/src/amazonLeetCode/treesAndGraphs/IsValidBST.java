package amazonLeetCode.treesAndGraphs;

public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}
	private boolean helper(TreeNode root, TreeNode left, TreeNode right) {
		if (root == null)
			return true;
		if (left!=null && left.val >= root.val)
			return false;
		if (right!=null && right.val <= root.val)
			return false;
		return helper(root.left, left, root) && helper(root.right, root, right);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		System.out.println(new IsValidBST().isValidBST(root));
	}
}
