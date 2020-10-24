package amazonPractice.wordSquares;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
	boolean isLeaf;
	Map<Character, TrieNode> children;

	TrieNode() {
		isLeaf = false;
		children = new HashMap<>();
	}

	void insert(String word) {
		TrieNode current = this;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!current.children.containsKey(c)) {
				current.children.put(c, new TrieNode());
			}
			current = current.children.get(c);
		}
		current.isLeaf = true;
	}

	boolean hasPrefix(String prefix) {
		TrieNode current = this;
		for (char c : prefix.toCharArray()) {
			if (!current.children.containsKey(c)) {
				return false;
			}
			current = current.children.get(c);
		}
		return true;
	}

	List<String> wordsWithPrefix(String prefix) {
		List<String> res = new ArrayList<>();

		if (!hasPrefix(prefix))
			return res;

		TrieNode current = this;
		for (char c : prefix.toCharArray()) {
			current = current.children.get(c);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(prefix);

		backtrack(current, res, sb);

		return res;
	}

	void backtrack(TrieNode curr, List<String> res, StringBuilder sb) {
		if (curr.isLeaf) {
			res.add(sb.toString());
			return;
		}

		for (char c : curr.children.keySet()) {
			sb.append(c);
			backtrack(curr.children.get(c), res, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}

public class WordSquares {
	public List<List<String>> wordSquares(String[] words) {
		if (words == null || words.length == 0)
			return new ArrayList<>();
		List<List<String>> res = new ArrayList<>();
		int k = words[0].length();
		TrieNode trieNode = new TrieNode();
		for (String word : words) {
			trieNode.insert(word);
		}

		for (String word : words) {
			List<String> tmp = new ArrayList<>();
			tmp.add(word);
			DFS(res, tmp, 1, k, trieNode);
		}

		return res;
	}

	private void DFS(List<List<String>> res, List<String> tmp, int start, int k, TrieNode trieNode) {
		if (start == k) {
			if (tmp.size() == k)
				res.add(new ArrayList<>(tmp));
			return;
		}

		String prefix = getPrefix(start, tmp);

		List<String> allWordsWithPrefix = trieNode.wordsWithPrefix(prefix);

		for (String word : allWordsWithPrefix) {
			tmp.add(word);
			DFS(res, tmp, start + 1, k, trieNode);
			tmp.remove(tmp.size() - 1);
		}

	}

	private String getPrefix(int start, List<String> tmp) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i <= tmp.size(); i++) {
			for (String s : tmp) {
				sb.append(s.charAt(i));
			}

		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = new String[] { "area", "lead", "wall", "lady", "ball" };
		System.out.println(new WordSquares().wordSquares(words));
//		TrieNode node = new TrieNode();
//		for (String word: words) {			
//			node.insert(word);			
//		}
//		System.out.println(node.hasPrefix("le"));
	}
}
