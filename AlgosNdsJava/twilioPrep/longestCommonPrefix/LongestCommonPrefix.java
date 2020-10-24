package twilioPrep.longestCommonPrefix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class TrieNode {
	boolean isLeaf;
	Map<Character, TrieNode> children;

	TrieNode() {
		this.children = new HashMap<>();
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
			if (!current.children.containsKey(c)) {
				return false;
			}
			current = current.children.get(c);
		}

		return current.isLeaf;
	}

	String longestCommonPrefix() {
		TrieNode current = this;

		StringBuilder sb = new StringBuilder();
		while (current.children != null && current.children.size() == 1 && current.isLeaf == false) {
			char c = current.children.keySet().iterator().next();
			sb.append(c);
			current = current.children.get(c);
		}

		return sb.toString();
	}
// catsandog
//	boolean wordBreak(String s) {
//		// steps
//		// bfs to go over trie for all possible breakdowns
//		// keep track of start idx and end index and maintain a hashset to keep track of duplicate visits
//		Queue<TrieNode> q = new ArrayDeque<>();
//		TrieNode root = this;
//		q.add(root);
//		Set<Integer> visited = new HashSet<Integer>();
//		visited.add(0);
//		while(!q.isEmpty()) {
//			TrieNode curr = q.poll();
//			for (int i=currIdx+1; i<s.length(); i++) {
//				
//			}
//		}
//		return false;
//	}
	public boolean wordBreakC(String s, Set<String> dict) {
	    if (dict.contains(s)) return true;
	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.offer(0);
	    // use a set to record checked index to avoid repeated work.
	    // This is the key to reduce the running time to O(N^2).
	    Set<Integer> visited = new HashSet<Integer>();
	    visited.add(0);
	    while (!queue.isEmpty()) {
	        int curIdx = queue.poll();
	        for (int i = curIdx+1; i <= s.length(); i++) {
	            if (visited.contains(i)) continue;
	            if (dict.contains(s.substring(curIdx, i))) {
	                if (i == s.length()) return true;
	                queue.offer(i);
	                visited.add(i);
	            }
	        }
	    }
	    return false;
	}

}

public class LongestCommonPrefix {
//	public boolean wordBreak(String s, List<String> wordDict) {
//		TrieNode root = new TrieNode();
//		for (String str : wordDict) {
//			root.insert(str);
//		}
//
//		return root.wordBreak(s);
//	}

	public static void main(String[] args) {
		// s = "leetcode", wordDict = ["leet", "code"]
		String s = "leetcode";
		List<String> wordDict = Arrays.asList("leet", "code");
		//System.out.println(new LongestCommonPrefix().wordBreak(s, wordDict));
		 TrieNode root = new TrieNode();
		 root.insert("banana");
//		 root.insert("shia");
//		 root.insert("shir");
		// System.out.println(root.search("shirish"));
		System.out.println(root.longestCommonPrefix());
	}
}
