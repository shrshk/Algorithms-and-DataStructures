package graphs.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * 
 * }
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class LevelNode {
	int levelNo;
	List<TreeNode> levelTreeNodes;

	LevelNode(int levelNo, List<TreeNode> levelTreeNodes) {
		this.levelNo = levelNo;
		this.levelTreeNodes = levelTreeNodes;
	}
}

public class MaxLevelSumTreeBFS {
	public int maxLevelSum(TreeNode root) {
		Queue<LevelNode> q = new ArrayDeque<>();
		q.add(new LevelNode(1, Arrays.asList(root)));
		int maxSum = Integer.MIN_VALUE;
		int maxSumLevel = 0;
		while (!q.isEmpty()) {
			int levelSum = 0;
			LevelNode levelNode = q.poll();
			int currentLevel = levelNode.levelNo;
			List<TreeNode> treeNodes = levelNode.levelTreeNodes;
			List<TreeNode> nextLevelTreeNodes = new ArrayList<>();
			for (TreeNode treeNode : treeNodes) {
				levelSum += treeNode.val;
				if (treeNode.left != null) {
					nextLevelTreeNodes.add(treeNode.left);
				}
				if (treeNode.right != null) {
					nextLevelTreeNodes.add(treeNode.right);
				}

			}
			if (maxSum < levelSum) {
				maxSum = levelSum;
				maxSumLevel = currentLevel;
			}
			if (!nextLevelTreeNodes.isEmpty())
				q.add(new LevelNode(currentLevel + 1, nextLevelTreeNodes));
		}
		return maxSumLevel;
	}
}