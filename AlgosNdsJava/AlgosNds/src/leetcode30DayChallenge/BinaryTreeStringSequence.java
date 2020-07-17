package leetcode30DayChallenge;

public class BinaryTreeStringSequence {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean isValidSequence(TreeNode root, int[] arr) {
		int idx = 0;

		return isValid(root, arr, idx);
	}

	private boolean isValid(TreeNode root, int[] arr, int idx) {
		if (root == null && idx == arr.length-1)
			return true;
		
		return false;
	}

	public static void main(String[] args) {

	}
}
