package twilioPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class SuffixTrieNode {

	final static int MAX_CHAR = 256;

	SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];
	List<Integer> indexes;

	SuffixTrieNode() {
		indexes = new LinkedList<Integer>();

		for (int i = 0; i < MAX_CHAR; i++)
			children[i] = null;
	}

	void insertSuffix(String s, int index) {

		indexes.add(index);

		if (s.length() > 0) {

			char cIndex = s.charAt(0);

			if (children[cIndex] == null)
				children[cIndex] = new SuffixTrieNode();

			children[cIndex].insertSuffix(s.substring(1), index + 1);
		}
	}

	List<Integer> search(String s) {

		if (s.length() == 0)
			return indexes;

		if (children[s.charAt(0)] != null)
			return (children[s.charAt(0)]).search(s.substring(1));

		else
			return null;
	}
}

class SuffixTree {

	SuffixTrieNode root = new SuffixTrieNode();

	SuffixTree(String txt) {

		for (int i = 0; i < txt.length(); i++)
			root.insertSuffix(txt.substring(i), i);
	}

	boolean search_tree(String pat) {

		List<Integer> result = root.search(pat);

		return result != null;
	}
}

public class VanityPhoneNumbers {
	private static final Map<Character, Character> map;
	static {
		map = new HashMap<>();
		map.put('A', '2');
		map.put('B', '2');
		map.put('C', '2');
		map.put('D', '3');
		map.put('E', '3');
		map.put('F', '3');
		map.put('G', '4');
		map.put('H', '4');
		map.put('I', '4');
		map.put('J', '5');
		map.put('K', '5');
		map.put('L', '5');
		map.put('M', '6');
		map.put('N', '6');
		map.put('O', '6');
		map.put('P', '7');
		map.put('Q', '7');
		map.put('R', '7');
		map.put('S', '7');
		map.put('T', '8');
		map.put('U', '8');
		map.put('V', '8');
		map.put('W', '9');
		map.put('X', '9');
		map.put('Y', '9');
		map.put('Z', '9');
	}

	public static List<String> vanity(List<String> codes, List<String> numbers) {
		// steps
		// use a suffix to store numbers
		// traverse the tree find match

		// TWLO

		List<String> numCodes = getNumCodes(codes);

		Set<String> set = new HashSet<>();

		for (String num : numbers) {
			for (String numCode : numCodes) {
				if (!set.contains(num)) {
					SuffixTree suffixTree = new SuffixTree(num);
					if (suffixTree.search_tree(numCode)) {
						set.add(num);
					}
				}
			}

		}

		List<String> result = new ArrayList<>(set);

		Collections.sort(result);

		return result;

	}

	private static List<String> getNumCodes(List<String> codes) {
		List<String> numCodes = new ArrayList<>();

		for (String code : codes) {
			StringBuilder numCode = new StringBuilder();
			for (char c : code.toCharArray()) {
				numCode.append(map.get(c));
			}
			numCodes.add(numCode.toString());
		}

		return numCodes;

	}

	public static void main(String[] args) {
		List<String> codes = Arrays.asList("TWLO", "CODE", "HTCH");
		List<String> numbers = Arrays.asList("+14157088956");
		System.out.println(vanity(codes, numbers));
	}

}
