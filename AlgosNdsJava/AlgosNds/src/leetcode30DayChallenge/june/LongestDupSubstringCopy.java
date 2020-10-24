package leetcode30DayChallenge.june;

public class LongestDupSubstringCopy {
	// T = O(N*K), S = O(N), where N is length of S and K avg depth of trie.
	String S;
	public String longestDupSubstring(String S) {
	    this.S = S;
	    int maxLo = 0, maxLength = 0;
	    TrieNode1 root = new TrieNode1(0, 0);
	    for (int i = 1; i + maxLength < S.length(); i++) {
	        int len = addNew(root, i);
	        if (len > maxLength) {
	            maxLength = len;
	            maxLo = i;
	        }
	    }
	    System.out.println(root);
	    return S.substring(maxLo, maxLo + maxLength);
	}

	private boolean isLeaf(TrieNode1 node) {
	    return node.next == null;
	}

	private int getIndex(int i, int depth) {
	    return S.charAt(i + depth) - 'a';
	}

	private int addNew(TrieNode1 node, int i) {
	    int depth = node.depth;
	    if (i + depth == S.length()) return depth;
	    if (isLeaf(node)) {
	        node.next = new TrieNode1[26];
	        node.next[getIndex(node.i, node.depth)] = new TrieNode1(node.i, depth + 1);
	    }
	    int c = getIndex(i, node.depth);
	    TrieNode1 x = node.next[c];
	    if (x == null) {
	        node.next[c] = new TrieNode1(i, depth + 1);
	        return depth;
	    }
	    return addNew(x, i);
	}

	private static class TrieNode1 {
	    private TrieNode1[] next;
	    private int i;
	    private int depth;

	    public TrieNode1(int i, int depth) {
	        this.i = i;
	        this.depth = depth;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestDupSubstringCopy().longestDupSubstring("banban"));
	}
}
