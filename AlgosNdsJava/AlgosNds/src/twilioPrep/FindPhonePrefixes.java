package twilioPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import twilioPrep.longestCommonPrefix.TrieNode;

class TrieNode {
	Map<Character, TrieNode> children;
	boolean isLeaf;

	TrieNode() {
		isLeaf = false;
		children = new HashMap<>();
	}

	public void insert(String key) {
		TrieNode current = this;
		for (char c : key.toCharArray()) {
			if (current.children.get(c) == null) {
				current.children.put(c, new TrieNode());
			}
			current = current.children.get(c);
		}
	}

	public boolean search(String key) {
		TrieNode current = this;
		for (char c : key.toCharArray()) {
			current = current.children.get(c);
			if (current == null)
				return false;

		}

		return current.isLeaf;
	}

	public boolean startsWith(String prefix) {
		TrieNode current = this;
		for (char c : prefix.toCharArray()) {
			current = current.children.get(c);
			if (current == null)
				return false;
		}

		return true;
	}

	public String longestMatchingPrefix(String s) {
		TrieNode current = this;

		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			current = current.children.get(c);
			if (current == null)
				return sb.toString();
			sb.append(c);
		}

		return sb.toString();

	}

}

public class FindPhonePrefixes {
	public List<String> longestPrefixes(String[] areaCodes, String[] phoneNums) {
		List<String> res = new ArrayList<>();

		TrieNode root = new TrieNode();
		for (String areaCode : areaCodes) {
			root.insert(areaCode);
		}

		for (String phoneNum : phoneNums) {
			res.add(root.longestMatchingPrefix(phoneNum));
		}

		return res;
	}

	public static void main(String[] args) {
		// TrieNode root = new TrieNode();
		// root.insert("shirish");
		// System.out.println(root.longestMatchingPrefix("shirisabcefgh"));

		// "213", "21358", "1234", "12"

		// "21349049", "1204539492", "123490485904"

		String[] areaCodes = new String[] { "3569377" };

		String[] phoneNums = new String[] { "35693771800" };

		System.out.println(new FindPhonePrefixes().longestPrefixes(areaCodes, phoneNums));

	}
}
