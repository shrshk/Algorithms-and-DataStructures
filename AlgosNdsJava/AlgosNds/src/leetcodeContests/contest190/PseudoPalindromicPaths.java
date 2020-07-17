package leetcodeContests.contest190;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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

public class PseudoPalindromicPaths {
	int result = 0;

	public int pseudoPalindromicPaths(TreeNode root) {
		Deque<Integer> path = new ArrayDeque<>();
		getPaths(root, path);
		return result;
	}

	private void getPaths(TreeNode root, Deque<Integer> path) {
		if (root == null)
			return;
		path.add(root.val);
		if (root.left == null && root.right == null) {	
			System.out.println(path.toString());
			if (isPalindrome(path)) {
				result++;
			}
		}

		getPaths(root.left, path);
		getPaths(root.right, path);
		
		path.removeLast(); // backtrack
	}

	private boolean isPalindrome(Deque<Integer> path) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : path) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int oddCount = 0;
		for (int num : map.keySet()) {
			if (map.get(num) % 2 == 0) {
				continue;
			}
			oddCount++;
		}

		return oddCount <= 1;
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);

		two.right = five;
		one.left = two;
		one.right = three;

		System.out.println(new PseudoPalindromicPaths().pseudoPalindromicPaths(one));
	}
}

// List<List<Integer>> allPaths = new ArrayList<>();
//
// public int pseudoPalindromicPaths(TreeNode root) {
// Deque<Integer> path = new ArrayDeque<>();
// getPaths(root, path);
// return countPalindromes();
// }
//
// private void getPaths(TreeNode root, Deque<Integer> path) {
// if (root == null)
// return;
// path.add(root.val);
// if (root.left == null && root.right == null) {
// allPaths.add(new ArrayList<>(path));
// }
//
// getPaths(root.left, path);
// getPaths(root.right, path);
//
// path.removeLast(); // backtrack
// }
//
// private int countPalindromes() {
//
// int count = 0;
// for (List<Integer> path : allPaths) {
// if (isPalindrome(path))
// count++;
// }
//
// return count;
// }
//
// private boolean isPalindrome(List<Integer> path) {
//
// Map<Integer, Integer> map = new HashMap<>();
//
// for (int num : path) {
// map.put(num, map.getOrDefault(num, 0) + 1);
// }
//
// int oddCount = 0;
//
// for (int num : map.keySet()) {
// if (map.get(num) % 2 == 0) {
// continue;
// }
// oddCount++;
// }
//
// return oddCount <= 1;
// }
