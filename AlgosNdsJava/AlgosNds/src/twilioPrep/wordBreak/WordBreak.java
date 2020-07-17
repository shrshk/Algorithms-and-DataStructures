package twilioPrep.wordBreak;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

public class WordBreak {
	boolean answer = false;

	public boolean wordBreak(String s, List<String> wordDict) {
		Queue<Integer> q = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();
		q.add(0);
		while (!q.isEmpty()) {
			int currIdx = q.poll();
			for (int i = currIdx + 1; i <= s.length(); i++) {
				if (visited.contains(i))
					continue;
				if (wordDict.contains(s.substring(currIdx, i))) {
					if (i == s.length())
						return true;
					q.add(i);
					visited.add(i);
				}
			}
		}

		return false;
	}

	// public boolean wordBreakDFS(String s, List<String> wordDict) {
	// // steps
	// // call dfs
	// // inc. idx
	//
	// helper(s, wordDict, 0, 1);
	//
	// return answer;
	// }
	//
	// private void helper(String s, List<String> wordDict, int currIdx, int i)
	// {
	//
	// if (!wordDict.contains(s.substring(currIdx, i)))
	// return;
	//
	// if (i == s.length()) {
	// answer = true;
	// return;
	// }
	//
	// currIdx = i;
	//
	// for (i = currIdx + 1; i <= s.length(); i++) {
	// helper(s, wordDict, currIdx, i);
	// }
	//
	// }

	public boolean wordBreakDFS(String s, List<String> wordDict) {
		if (s.length() == 0)
			return false;
		Set<Integer> visited = new HashSet<Integer>();
		boolean answer = helper(s, 0, visited, wordDict);
		System.out.println(visited.toString());
		return answer;
	}

	private boolean helper(String s, int currIdx, Set<Integer> visited, List<String> dict) {
		if (currIdx == s.length())
			return true;
		for (int i = currIdx + 1; i <= s.length(); i++) {
			if (visited.contains(i))
				continue;
			if (dict.contains(s.substring(currIdx, i))) {
				if (helper(s, i, visited, dict))
					return true;
				visited.add(i);
			}
		}
		return false;
	}

	public boolean wordBreakDP(String s, List<String> wD) {
		if (s.length() == 0)
			return false;

		Set<String> wordDict = new HashSet<>(wD);
		Map<String, Boolean> cache = new HashMap<>();

		boolean answer = dfs(s, cache, wordDict);
		System.out.println(cache.toString());
		return answer;
	}

	private boolean dfs(String tmp, Map<String, Boolean> cache, Set<String> dict) {
		if (tmp.length() == 0 || dict.contains(tmp))
			return true;

		if (cache.containsKey(tmp))
			return cache.get(tmp);

		for (int i = 1; i < tmp.length(); i++) {
			if (dict.contains(tmp.substring(0, i)) && dfs(tmp.substring(i), cache, dict)) {
				cache.put(tmp, true);
				return cache.get(tmp);
			}
		}

		cache.put(tmp, false);
		return cache.get(tmp);

	}

	public static void main(String[] args) {
		String s = "catsandog";
		// "cats", "dog", "sand", "and", "cat"]
		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
		System.out.println(new WordBreak().wordBreakDP(s, wordDict));
	}

}
