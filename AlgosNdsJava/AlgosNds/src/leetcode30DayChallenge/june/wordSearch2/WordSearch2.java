package leetcode30DayChallenge.june.wordSearch2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TrieNode {
	Map<Character, TrieNode> children;
	boolean isLeaf;

	TrieNode() {
		children = new HashMap<>();
		isLeaf = false;
	}

	void insert(String word) {
		TrieNode current = this;
		for (char c : word.toCharArray()) {
			if (!current.children.containsKey(c)) {
				current.children.put(c, new TrieNode());
			}
			current = current.children.get(c);
		}

		current.isLeaf = true;
	}

	boolean search(String word) {
		TrieNode current = this;
		for (char c : word.toCharArray()) {
			if (!current.children.containsKey(c))
				return false;
			current = current.children.get(c);
		}
		return current.isLeaf;
	}

	boolean startsWith(String prefix) {
		TrieNode current = this;
		for (char c : prefix.toCharArray()) {
			if (!current.children.containsKey(c))
				return false;
			current = current.children.get(c);
		}
		return true;
	}

}

public class WordSearch2 {
	Set<String> set = new HashSet<>();
	TrieNode trieNode = new TrieNode();
	int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public List<String> findWords(char[][] board, String[] words) {

		for (String word : words) {
			trieNode.insert(word);
		}

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean[][] used = new boolean[m][n];
				backtrack("", i, j, board, m, n, used);
			}
		}

		return new ArrayList<>(set);
	}

	private void backtrack(String tmp, int i, int j, char[][] board, int m, int n, boolean[][] used) {

		if (i >= m || j >= n || i < 0 || j < 0 || used[i][j])
			return;
		
		tmp+=board[i][j];

		if (!trieNode.startsWith(tmp))
			return;

		if (trieNode.search(tmp)) {
			set.add(tmp);
		}

		used[i][j] = true;

		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			backtrack(tmp, x, y, board, m, n, used);
		}

		used[i][j] = false;
	}

	public static void main(String[] args) {
		// char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't',
		// 'a', 'e' }, { 'i', 'h', 'k', 'r' },
		// { 'i', 'f', 'l', 'v' } };
		char[][] board = new char[][] { { 'a', 'a' } };
		String[] words = new String[] { "a" }; // "aaa" //"oath", "pea",
													// "eat", "rain"
		System.out.println(new WordSearch2().findWords(board, words));
	}

}
