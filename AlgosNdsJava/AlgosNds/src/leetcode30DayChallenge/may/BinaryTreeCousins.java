package leetcode30DayChallenge.may;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

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

public class BinaryTreeCousins {

	public boolean isCousins(TreeNode root, int x, int y) {

		Queue<TreeNode> q = new ArrayDeque<>();

		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			Set<Integer> currLevel = new HashSet<>();
			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if (curr.left != null) {
					q.add(curr.left);
					currLevel.add(curr.left.val);
				}

				if (curr.right != null) {
					q.add(curr.right);
					currLevel.add(curr.right.val);
				}

				if (curr.left != null && curr.right != null) {
					Set<Integer> children = new HashSet<>();
					children.add(curr.left.val);
					children.add(curr.right.val);
					if (children.containsAll(Arrays.asList(x, y)))
						return false;
				}
			}
			if (currLevel.containsAll(Arrays.asList(x, y)))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		TreeNode one  = new TreeNode(1);
		TreeNode two  = new TreeNode(2);
		TreeNode three  = new TreeNode(3);
		TreeNode four  = new TreeNode(4);
		TreeNode five  = new TreeNode(4);
		
		one.left = two;
		one.right = three;
		two.right = four;
		three.right = five;
		
		System.out.println(new BinaryTreeCousins().isCousins(one, 4, 5));
		
	}
}
