package atlassianPrep;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	TreeNode(int x) {
		this.val = x;
	}
}

public class BinaryTreeCollectLeaves {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> findLeaves(TreeNode root) {
		height(root);
		return res;
	}

	private int height(TreeNode root) {
		if (root == null)
			return -1;
		int level = 1 + Math.max(height(root.left), height(root.right));
		if (res.size() < level + 1) {
			res.add(level, new ArrayList<>());
		}
		List<Integer> currLevel = res.get(level);
		currLevel.add(root.val);
		return level;
	}
}
