package tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	Map<Character, TrieNode> children;
	boolean isLeaf;

	TrieNode() {
		isLeaf = false;
		children = new HashMap<>();
	}

	public void insert(String key) {
		TrieNode current = this;
		for (int i = 0; i < key.length(); i++) {
			if (current.children.get(key.charAt(i)) == null)
				current.children.put(key.charAt(i), new TrieNode());
			current = current.children.get(key.charAt(i));
		}

		current.isLeaf = true;
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

	public boolean startsWith(String key) {
		TrieNode current = this;
		for (int i = 0; i < key.length(); i++) {
			current = current.children.get(key.charAt(i));
			if (current == null)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		double i = Math.floor(Math.random() * 10);
		System.out.println(i);
		TrieNode root = new TrieNode();
		root.insert("shirish");
		System.out.println(root.startsWith("sha"));
	}

}
