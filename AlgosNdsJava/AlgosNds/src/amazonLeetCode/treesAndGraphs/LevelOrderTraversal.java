package amazonLeetCode.treesAndGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	List<List<Integer>> res = new ArrayList<>();

	// iterative
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		// bfs iterative solution
		// steps
		// every level we go, we create a new arrayList and add it to the result
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> currentLevel = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode current = q.poll();
				currentLevel.add(current.val);
				if (current.left != null) {
					q.add(current.left);
				}
				if (current.right != null) {
					q.add(current.right);
				}

			}
			res.add(currentLevel);
		}

		return res;
	}

	public List<List<Integer>> levelOrderRecursive(TreeNode root) {
		// base case
		if (root == null)
			return res;
		helper(root, 0);
		return res;
	}

	private void helper(TreeNode root, int level) {
		if (res.size() == level)
			res.add(new ArrayList<>());
		res.get(level).add(root.val);
		if (root.left != null)
			helper(root.left, level++);
		if (root.right != null)
			helper(root.right, level++);
	}

}
