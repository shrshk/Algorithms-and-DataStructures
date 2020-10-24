package computersAndTacos.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

public class SearchAutoComplete {

	TrieNode trieNode;
	List<String> result;

	public SearchAutoComplete() {
		this.trieNode = new TrieNode();
		this.result = new ArrayList<>();
	}

	public void addWords(List<String> words) {
		for (String word : words)
			trieNode.insert(word);
	}

	public List<String> search(String word) {

		if (!trieNode.startsWith(word) || trieNode.search(word)) {
			result.add(word);
			return result;
		}

		for (char c : word.toCharArray()) {
			trieNode = trieNode.children.get(c);
		}

		dfs(word, trieNode);

		return result;
	}

	private void dfs(String prefix, TrieNode node) {

		if (node == null || node.isLeaf) {
			result.add(prefix);
			return;
		}

		for (char c : node.children.keySet()) {
			dfs(prefix + c, node.children.get(c));
		}

	}
	
	public static void main(String[] args) {
		SearchAutoComplete searchAutoComplete = new SearchAutoComplete();
		searchAutoComplete.addWords(Arrays.asList("sam", "sand", "sanfran"));
		System.out.println(searchAutoComplete.search("sam").toString());
	}

}
