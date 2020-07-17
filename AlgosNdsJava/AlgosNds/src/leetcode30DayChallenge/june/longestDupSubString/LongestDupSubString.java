package leetcode30DayChallenge.june.longestDupSubString;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	int depth;
	int index;
	Map<Character, TrieNode> children;

	TrieNode(int index, int depth) {
		this.children = new HashMap<>();
		this.depth = depth;
		this.index = index;
	}
	
	boolean isLeaf() {
		return this.children.isEmpty();
	}

}

class Trie {
	String s;
	TrieNode root;

	Trie(String s) {
		this.s = s;
		this.root = new TrieNode(0, 0);
	}

	int insert(TrieNode node, int index) {
		int depth = node.depth;
		if (index + depth == s.length())
			return depth;
		if (node.isLeaf()) {
			node.children.put(s.charAt(node.index+depth), new TrieNode(node.index, depth + 1));
		}

		 // after we insert b a n for the next
		// level we wanna insert ana under
		// 'a'
		char c = s.charAt(index + depth);
		TrieNode current = node.children.get(c);
		if (current == null) {
			current = new TrieNode(index, depth + 1);
			node.children.put(c, current);
			return depth;
		}

		return insert(current, index);
	}
}

public class LongestDupSubString {	
	public String longestDupSubstring(String S) {		
		int maxStart = 0, maxLength = 0;
		Trie trie = new Trie(S);
		for (int i = 1; i + maxLength < S.length(); i++) {
			int len = trie.insert(trie.root, i);
			if (len > maxLength) {
				maxLength = len;
				maxStart = i;
			}
		}
		return S.substring(maxStart, maxStart + maxLength);
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestDupSubString().longestDupSubstring("banban"));
	}
}
