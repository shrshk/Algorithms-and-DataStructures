package leetcode30DayChallenge.june;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import leetcode30DayChallenge.june.wordSearch2.TrieNode;

//class TrieNode {
//	boolean isLeaf;
//	int depth;
//	Map<Character, TrieNode> children;
//
//	TrieNode(int depth) {
//		this.children = new HashMap<>();
//		this.isLeaf = false;
//		this.depth = depth;
//	}
//}

class TrieNode {
	int index;
	int depth;
	Map<Character, TrieNode> children;

	public TrieNode(int index, int depth) {
		this.index = index;
		this.depth = depth;
	}

	boolean isLeaf() {
		return this.children == null;
	}
}

class Trie {
	String s;
	TrieNode root;

	Trie(String s) {
		this.s = s;
		this.root = new TrieNode(0, 0);
	}

	public int insert(TrieNode node, int i) {
		Queue<TrieNode> queue = new ArrayDeque<>();
		queue.offer(node);
		int depth = 0;
		while (!queue.isEmpty()) {
			TrieNode current = queue.poll();
			depth = current.depth;
			int index = current.index;
			if (i + depth == s.length())
				return depth;
			if (current.isLeaf()) {
				current.children = new HashMap<>();
				current.children.put(s.charAt(index+depth), new TrieNode(index, depth + 1));
			}
			TrieNode child = current.children.get(s.charAt(i+depth));
			if (child == null) {
				current.children.put(s.charAt(i+depth), new TrieNode(i, depth + 1));
				return depth;
			}
			queue.offer(child);
		}
		return depth;
	}
	public int insertR(TrieNode node, int index) {
		int depth = node.depth;
		if (index + depth == s.length())
			return depth;
		if (node.isLeaf()) {
			node.children = new HashMap<>();
			node.children.put(s.charAt(node.index+depth), new TrieNode(node.index, depth + 1));
		}

		char c = s.charAt(index + depth); // after we insert b a n for the next
											// level we wanna insert ana under
											// 'a'
		TrieNode current = node.children.get(c);
		if (current == null) {
			node.children.put(c, new TrieNode(index, depth + 1));
			return depth;
		}

		return insertR(current, index);
	}
}

public class LongestDuplicateSubstring {
	// T = O(N*K), S = O(N), where N is length of S and K avg depth of trie. //
	// banana
	String S;
	int maxLo = 0;
	int maxLength = 0;

	public String longestDupSubstring(String s) {
		Trie trie = new Trie(s);
		for (int i = 1; i + maxLength < s.length(); i++) {
			int len = trie.insertR(trie.root, i);
			if (len > maxLength) {
				maxLength = len;
				maxLo = i;
			}
		}
		return s.substring(maxLo, maxLo + maxLength);
	}

	public static void main(String[] args) {
		System.out.println(new LongestDuplicateSubstring().longestDupSubstring("banban"));
	}
}
