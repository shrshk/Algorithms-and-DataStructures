package leetcodeContests.contest160;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxLengthString {
	public int maxLength(List<String> arr) {
		int maxLen = 0;
		// steps
		// for every string i loop rest of the arr j
		// if ith string has dupl. continue
		// check for dups in jth string along with the ith String
		// update maxLen
		for (int i = 0; i < arr.size(); i++) {
			Set<Character> current = new HashSet<>();
			String currentStr = arr.get(i);
			currentStr.chars().forEach(e -> current.add((char) e));
			if (current.size() != currentStr.length())
				continue;
			maxLen = Math.max(maxLen, current.size());
			for (int j = 0; j < arr.size(); j++) {
				if (i == j)
					continue;
				Set<Character> other = new HashSet<>();
				boolean hasDups = false;
				for (char c : arr.get(j).toCharArray()) {
					if (other.contains(c) || current.contains(c)) {						
						hasDups = true;
						break;
					}
					other.add(c);
				}
				if (!hasDups) {
					current.addAll(other);
					System.out.println(current.toString());
				}
				maxLen = Math.max(maxLen, current.size());
			}
		}

		return maxLen;
	}

	public int maxLengthD(List<String> arr) {
		int maxConcatlength = 0;
		for (int i = 0; i < arr.size(); i++) {
			String curr = arr.get(i);
			if (curr.length() != findUniqueWordLength(curr))
				continue;
			int lo = i + 1;
			while (lo < arr.size()) {
				String result = "";
				result = result + curr;
				for (int j = lo; j < arr.size(); j++) {
					String nextCurr = arr.get(j);
					if (nextCurr.length() != findUniqueWordLength(nextCurr))
						continue;
					String concatStr = result + nextCurr;
					result = concatStr.length() != findUniqueWordLength(concatStr) ? result : concatStr;
					if (result.length() > maxConcatlength)
						maxConcatlength = result.length();
				}
				lo++;
			}
		}
		return maxConcatlength;
	}

	static int findUniqueWordLength(String s) {
		HashSet<Character> currWithoutDuplicates = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			currWithoutDuplicates.add(s.charAt(i));
		}
		return currWithoutDuplicates.size();
	}

	public int maxLengths(List<String> arr) {
		Collections.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s2.length() - s1.length();
			}
		});
		Map<Character, Integer> characterInputAddress = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			String curr = arr.get(i);
			if (curr.length() != findUnique(curr))
				continue;
			boolean charaterExists = false;
			for (int j = 0; j < curr.length(); j++) {
				if (characterInputAddress.containsKey(curr.charAt(j))) {
					charaterExists = true;
					break;
				}
			}
			if (!charaterExists) {
				for (int j = 0; j < curr.length(); j++) {
					characterInputAddress.put(curr.charAt(j), i);
				}
			}
		}
		return characterInputAddress.size();
	}

	static int findUnique(String s) {
		HashSet<Character> currWithoutDuplicates = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			currWithoutDuplicates.add(s.charAt(i));
		}
		return currWithoutDuplicates.size();
	}

//	private boolean isDuplicate(String s, Map<Character, Integer> map) {
//		for (int x = 0; x < s.length(); x++) {
//			if (map.containsKey(s.charAt(x))) {
//				return true;
//			}
//		}
//		return false;
//	}

	// "cha","r","act","ers"
	// c h a r

	public static void main(String[] args) {
//		System.out.println(new MaxLengthString().maxLength(Arrays.asList("nzxijudcseqmybar", "javz", "fqbtasiplekwnx",
//				"duhzjlkwyo", "hsmguvln", "ncaegmvxi", "xrszqhwylmtbocjgv", "ybivuerzwohqfjnlpa", "jnqchxfagkumsiv",
//				"svxknebywoizramc", "xtowlghkfrjan", "ol")));
		// "s","sa","m","e","mu","ei"
		// "ab","cd","cde","cdef","efg","fgh","abxyz"
		System.out.println(new MaxLengthString().maxLength(Arrays.asList("s","sa","m","e","mu","ei")));
	}
}
