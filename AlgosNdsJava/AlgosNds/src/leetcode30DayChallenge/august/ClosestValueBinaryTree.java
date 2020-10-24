package leetcode30DayChallenge.august;

public class ClosestValueBinaryTree {
	double minDiff = Integer.MAX_VALUE;
	int res = 0;

	public int closestValue(TreeNode root, double target) {

		dfs(root, target);

		return res;
	}

	private void dfs(TreeNode root, double target) {
		if (root == null)
			return;

		double diff = Math.abs(root.val - target);

		if (diff < minDiff) {
			minDiff = diff;
			res = root.val;
		}

		if (root.val > target) {
			closestValue(root.left, target);
		} else {
			closestValue(root.right, target);
		}

	}

	public static void main(String[] args) {
		TreeNode four = new TreeNode(4);
		TreeNode two = new TreeNode(2);
		TreeNode five = new TreeNode(5);
		TreeNode one = new TreeNode(1);
		TreeNode three = new TreeNode(3);

		four.left = two;
		four.right = five;
		two.left = one;
		two.right = three;

		System.out.println(new ClosestValueBinaryTree().closestValue(four, 3.714286));

	}
}
