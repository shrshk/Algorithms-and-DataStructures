package leetcode30DayChallenge.august;

import java.util.HashMap;
import java.util.Map;

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
	
	public boolean startsWith(String key) {
		TrieNode current = this;
		for (int i = 0; i < key.length(); i++) {
			current = current.children.get(key.charAt(i));
			if (current == null)
				return false;
		}

		return true;
	}
	
	public boolean search(String key) {
		TrieNode current = this;
		for (int i = 0; i < key.length(); i++) {
			current = current.children.get(key.charAt(i));
			if (current == null)
				return false;
		}

		return current.isLeaf;
	}
	
}

public class WordDictionary {

	TrieNode trieNode;

	public WordDictionary() {
		this.trieNode = new TrieNode();
	}

	public void addWord(String word) {
		trieNode.insert(word);
	}

	public boolean search(String word) {
		return match(word.toCharArray(), 0, trieNode);
	}

	private boolean match(char[] chars, int idx, TrieNode node) {
		if (idx == chars.length)
			return node.isLeaf;
		if (chars[idx] != '.')
			return node.children.get(chars[idx]) != null && match(chars, idx + 1, node.children.get(chars[idx]));
		for (char childChar : node.children.keySet()) {
			if (node.children.get(childChar) != null) {
				if (match(chars, idx + 1, node.children.get(childChar)))
					return true;
			}

		}
		return false;
	}

}