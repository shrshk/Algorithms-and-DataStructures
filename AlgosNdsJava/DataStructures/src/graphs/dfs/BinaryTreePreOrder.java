package graphs.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreePreOrder {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		res.add(root.val);
		if (root.left != null) {
			res.addAll(preorderTraversal(root.left));
		}
		if (root.right != null) {
			res.addAll(preorderTraversal(root.right));
		}
		return res;
	}
}
