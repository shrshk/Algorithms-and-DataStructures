package leetcode30DayChallenge.august.streamChecker;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class TrieNode {
	Map<Character, TrieNode> children;
	boolean isLeaf;

	TrieNode() {
		children = new HashMap<>();
		isLeaf = false;
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

}

public class StreamChecker {
	TrieNode root;
	Queue<TrieNode> q;

	public StreamChecker(String[] words) {
		root = new TrieNode();
		q = new ArrayDeque<>();

		for (String word : words) {
			root.insert(word);
		}

		q.add(root);
	}

	public boolean query(char letter) {
		boolean flag = false;

		int size = q.size();

		for (int i = 0; i < size; i++) {
			TrieNode n = q.poll();

			if (n.children.containsKey(letter)) {
				q.add(n.children.get(letter));
				if (n.children.get(letter).isLeaf)
					flag = true;
			}

			if (n == root)
				q.add(root);

		}

		return flag;

	}
}

/* 	public static void main(String[] args) {
		StreamChecker streamChecker = new StreamChecker(new String[] { "cd", "f", "kl" }); // init
																							// the
																							// dictionary.
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('c'));
		System.out.println(streamChecker.query('d'));
		System.out.println(streamChecker.query('e'));
	}
 */

/*
 * ["StreamChecker","query","query","query","query","query","query","query",
 * "query","query",
 * "query","query","query","query","query","query","query","query","query",
 * "query","query","query",
 * "query","query","query","query","query","query","query","query","query"]
 * [[["ab","ba","aaab","abab","baa"]],["a"],["a"],["a"],["a"],["a"],["b"],["a"],
 * ["b"],
 * ["a"],["b"],["b"],["b"],["a"],["b"],["a"],["b"],["b"],["b"],["b"],["a"],["b"]
 * , ["a"],["b"],["a"],["a"],["a"],["b"],["a"],["a"],["a"]]
 */

// ab a

// [null,false,false,false,false,false,true,true,true,true,true,false,false,true,
//
// true,true,true,false,false,false,true,true,true,true,true,true,false,true,true,true,false]
