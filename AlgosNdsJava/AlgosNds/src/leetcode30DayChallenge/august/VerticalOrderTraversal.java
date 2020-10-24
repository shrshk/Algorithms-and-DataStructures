package leetcode30DayChallenge.august;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

class Node {
	int x;
	int y;
	TreeNode treeNode;

	Node(int x, int y, TreeNode treeNode) {
		this.x = x;
		this.y = y;
		this.treeNode = treeNode;
	}
}

public class VerticalOrderTraversal {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		int left = Integer.MAX_VALUE;
		int right = Integer.MIN_VALUE;
		if (root == null)
			return new ArrayList<>();
		Map<Integer, List<Node>> map = new HashMap<>();
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0, 0, root));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				int x = curr.x;
				int y = curr.y;
				TreeNode treeNode = curr.treeNode;
				List<Node> values = map.getOrDefault(x, new ArrayList<>());
				values.add(curr);
				map.put(x, values);
				left = Math.min(left, x);
				right = Math.max(right, x);
				if (treeNode.left != null)
					q.add(new Node(x - 1, y + 1, treeNode.left));
				if (treeNode.right != null)
					q.add(new Node(x + 1, y + 1, treeNode.right));
			}

		}

		return buildResult(map, left, right);

	}

	private List<List<Integer>> buildResult(Map<Integer, List<Node>> map, int left, int right) {
		List<List<Integer>> result = new ArrayList<>();

		for (int i = left; i <= right; i++) {
			List<Node> nodeList = map.get(i);
			Collections.sort(nodeList, new Comparator<Node>() {

				@Override
				public int compare(Node n1, Node n2) {
					if (n1.x != n2.x)
						return n2.x-n1.x;
					if (n1.y!=n2.y)
						return n2.y-n1.y;
					return n2.treeNode.val - n1.treeNode.val;
				}
				
			});
			List<Integer> vals = new ArrayList<>();
			for (Node node : nodeList) {
				vals.add(node.treeNode.val);
			}
			result.add(vals);

		}

		return result;

	}

}